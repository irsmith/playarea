package maze;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class Solver {

	private static final String WALL = "WallFollower";
	private static final String FILL = "FloodFill";
	protected char marked = 'm';
	protected char wall = '1';
	protected char open = '0';


	public static class Cell {
		public int row;
		public int col;

		Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object that) {
			if (that.getClass() != Cell.class)
				return false;
			Cell c = (Cell) that;

			return (c.row == this.row) && (c.col == this.col);
		}

		@Override
		public int hashCode() {
			return row * 13 + col * 17;
		}

		@Override
		public String toString() {
			return String.format("%d:%d", row, col);
		}
	}

	protected char[][] maze;
	protected int rows;
	protected int cols;
	protected Map<Cell, Cell> edgeTo = new HashMap<Cell, Cell>();

	public Solver(int startRow, int startCol, char[][] cmaze) {
		this.maze = cmaze;
		this.cols = cmaze.length;
		this.rows = cmaze[0].length;
		edgeTo.put(new Cell(startRow, startCol), null);
	}

	/**
	 * edge cases: huge files (nbr rows, cols) how to calc the size are col
	 * jagged? file does not exist or is not readable file format is not
	 * scalable since you have to read it all in to discover its size. Better to
	 * have line count on top
	 * 
	 * @param fr
	 * @return
	 */
	private static char[][] readMaze(String fname) {
		List<String> all = null;
		try {
			all = Files.readAllLines(Paths.get(fname), StandardCharsets.UTF_8);
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		String line1 = all.get(0);
		char[] l1 = line1.toCharArray();
		assert line1.length() == l1.length;
		int cols = l1.length;
		int rows = all.size();
		char[][] maze = new char[rows][cols];
		for (int r = 0; r < rows; r++) {
			String line = all.get(r);
			for (int c = 0; c < cols; c++) {
				maze[r][c] = line.charAt(c) == '#' ? '1' : '0';
			}
		}
		return maze;
	}

	public Iterator<Cell> pathTo(int targetRow, int targetCol) {
		Deque<Cell> stack = new ArrayDeque<Cell>();
		Cell c = new Cell(targetRow, targetCol);
		stack.push(c);
		while (edgeTo.get(c) != null) {
			stack.push(edgeTo.get(c));
			c = edgeTo.get(c);
		}
		return stack.iterator();
	}

	public abstract List<Cell> getNeighbors(int row, int col);

	void report(int i, int j) {
		System.out.format("path to %d %d %n:", i, j);
		Iterator<Cell> it = this.pathTo(i, j);
		if (!it.hasNext()) {
			System.out.print("no solution");
		} else {
			while (it.hasNext())
				System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {

		String algo = args[1];
		if (algo == null || algo.isEmpty()
				|| !(algo.equals(WALL) || algo.equals(FILL))) {
			throw new Exception("invalid algo param:" + algo);
		}
		char[][] m = readMaze(args[0]);

		Solver solver = null;

		if (algo.equalsIgnoreCase(WALL)) {
			solver = new WallSolver(0, 0, m); // wierd pacakging 
		} else {
			solver = new FillSolver(0, 0, m);

		}
		solver.report(3, 3);
		solver.report(34, 4);
		solver.report(3, 1);

	}

}
