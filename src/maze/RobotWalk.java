package maze;

import java.util.ArrayList;
import java.util.List;

/**
 * given a matrix maze, S=0,0 and Target = x-1,y-1 find a path from S to T Also
 * do it with a blackout list. Point represents a position on matrix. You may
 * move down or right.
 * 
 * Progression: add blockedlist add more move directions Can it be implemented
 * w/out marked?
 */
public class RobotWalk {

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override 
		public String toString() {
			return String.valueOf(x)+":"+String.valueOf(y);
		}
	}

	List<Point> marked = new ArrayList<Point>();
	Point target;
	int gridWidth;
	int gridHeight;

	RobotWalk(int gridWidth, int gridHeight) {
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		target = new Point(gridWidth - 1, gridHeight - 1);
	}


	List<Point> getMoves(Point p) {
		List<Point> r = new ArrayList<Point>();

		Point downmove = (p.y + 1 < gridHeight) ? new Point(p.x, p.y + 1)
				: null;
		Point rightmove = (p.x + 1 < gridWidth) ? new Point(p.x + 1, p.y)
				: null;
		if (downmove != null) r.add(downmove);
		if (rightmove != null) r.add(rightmove);

		return r;
	}

	boolean dfs(Point p) {

		System.out.println("at p:"+p);
		if (p.x == target.x && p.y == target.y)
			return true;

		for (Point nextMove : getMoves(p)) {
			System.out.println("move to:"+nextMove);

			if (marked.contains(nextMove))
				continue;
			marked.add(nextMove);
			if (dfs(nextMove) == true) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		RobotWalk rw = new RobotWalk(3,2);//or RobotWalk(w,h, blacklist)
		boolean res = rw.dfs(new Point(0,0));
		System.out.println(res);
	}

}
