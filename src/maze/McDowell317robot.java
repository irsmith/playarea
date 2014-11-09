package maze;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;

public class McDowell317robot {

	static Node target = null;
	Node[][] grid;
	private boolean found;

	static class Node {
		int row;
		int col;
		boolean marked = false;
		boolean blocked = false;
		Node pathTo;// marked with the node from which entered this first

		Node(int r, int c) {
			row = r;
			col = c;
		}
		@Override
		public String toString() {
			return String.format("r:%d c:%d", row,col);
		}
	}

	boolean isFound() {
		return found;
	}

	List<Node> pathTo(Node target) {
		if (target.pathTo == null)
			return null;
		List<Node> rv = new LinkedList<Node>();
		for (Node c=target;c!=null;c=c.pathTo){
			rv.add(0,c);
		}
//		Node cur = target;
//		while (cur.pathTo != null) {
//			System.out.println(cur);
//			rv.add(0, cur.pathTo);
//			cur = cur.pathTo;
//			
//		}
		return rv;
	}

	public McDowell317robot(Dimension dim, int[][] blocked) {
		grid = new Node[dim.height][dim.width];
		int[][] test = new int[dim.width][dim.height];

		for (int r = 0; r < dim.getHeight(); r++) {
			for (int c = 0; c < dim.getWidth(); c++) {
				grid[r][c] = new Node(r, c);
			}
		}

		for (int r = 0; r < blocked.length; r++) {
			grid[blocked[r][0]][blocked[r][1]].blocked = true;
		}
		target = grid[dim.height - 1][dim.width - 1];
		grid[0][0].marked = true;
		// todo return true if target found
		dfs(grid[0][0]);

	}

	// upon visit, mark as visited, (this is different than blocked. For blocked
	// we never to there.
	// for Marked, we go there once... and then never again?? So getDown() could
	// query marked.
	// set pathTo to the node by which we hav entered this for first time
	// TODO if n == target set found class variable.... or return boolean
	private void dfs(Node n) {
		if (n == null)
			return;

		Node down = getDown(n);
		if (down != null && !down.marked) {
			down.marked = true;
			down.pathTo = n;
			if (down == target) {
				found = true;
				// return; do this next pass
			}
			dfs(down);
		}
		Node right = getRight(n);
		if (right != null && !right.marked) {
			right.marked = true;
			right.pathTo = n;
			if (right == target) {
				found = true;
			}
			dfs(right);
		}

	}

	Node getDown(Node current) {
		if (current.row + 1 == grid.length)
			return null;
		if (grid[current.row + 1][current.col].blocked)
			return null;
		return grid[current.row + 1][current.col];
	}

	Node getRight(Node current) {
		if (current.col + 1 == grid[0].length)
			return null;
		if (grid[current.row][current.col + 1].blocked)
			return null;
		return grid[current.row][current.col + 1];
	}

	// robot on grid, find path from s to target, with some blocked
	public static void main(String[] args) {
		Dimension dim = new Dimension(3, 5);// cols and row (width, height

		// test 1,1 dim (source = target_
		// construct grid
		// insert obstructions - optional
		int[][] blocked2 = { { 1, 0 }, { 1, 1 }, { 3, 4 } }; // next , target
																// not possible

		int[][] blocked = { { 1, 0 }, { 1, 1 } };
		McDowell317robot grid = new McDowell317robot(dim, blocked);

		List<Node> path = grid.pathTo(target);
		System.out.println("target:"+target+"path:"+path);

	}

}
