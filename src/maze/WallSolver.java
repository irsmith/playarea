package maze;

import java.util.List;

public class WallSolver extends Solver {

	enum Dir {
		N, E, S, W
	};

	public WallSolver(int startRow, int startCol, char[][] cmaze) {
		super(startRow, startCol, cmaze);
		int targetRow = rows - 1;
		int targetCol = cols - 1;

		followLeftWall(maze, targetRow, targetCol);

	}

	/**
	 * Will start at the (i,j) corresponding to the entrance of the maze going
	 * with the initial direction "east", and then will keep calling nextMove
	 * function to determine where to go next, until it reaches the exit of the
	 * maze.
	 * 
	 * @param maze
	 * @param targetRow
	 * @param targetCol
	 */
	private void followLeftWall(char[][] maze, int targetRow, int targetCol) {

		Dir dir = Dir.E;
		int currentRow = 0;
		int currentCol = 0;
		while (!(currentRow == targetRow && currentCol == targetCol)) {
			dir = nextMove(maze, currentRow, currentCol, dir);
			System.out.format("from %d:%d move %s %n",currentRow, currentCol, dir);
			Cell prev = new Cell(currentRow,currentCol);
			switch (dir) {
			case E:
				currentCol++;
				break;
			case N:
				currentRow--;
				break;
			case W:
				currentCol--;
				break;
			case S:
				currentRow++;
				break;
			}
			edgeTo.put(new Cell(currentRow, currentCol), prev);
		}
	}

	/**
	 * Computes the direction in which you need to go based on your current
	 * direction (east, west, north or south) and the point where you are at in
	 * the maze (i, j ). For instance, if you are currently going east, it will
	 * check if there is a wall on the left, and if no, your new direction will
	 * be north (assuming we always try to go left); if there is a wall on the
	 * left, it will check whether other options are possible: going east,
	 * south, west, in this order of preference.
	 * 
	 * @param maze
	 * @param currentRow
	 * @param currentCol
	 * @param dir
	 * @return
	 */
	private Dir nextMove(char[][] maze, int r, int c, Dir prevDir) {

		switch (prevDir) {
		case E: {
			if (canMoveNorth(r, c))
				return Dir.N;
			else if (canMoveEast(r, c))
				return Dir.E;
			else if (canMoveSouth(r, c))
				return Dir.S;
			break;
		}
		case N: {
			if (canMoveWest(r, c))
				return Dir.W;
			else if (canMoveNorth(r, c))
				return Dir.N;
			else if (canMoveEast(r, c))
				return Dir.E;
			break;
		}
		case W: {
			if (canMoveSouth(r, c))
				return Dir.S;
			else if (canMoveWest(r, c))
				return Dir.W;
			else if (canMoveNorth(r, c))
				return Dir.N;
			break;

		}
		case S: {
			if (canMoveEast(r, c))
				return Dir.E;
			else if (canMoveSouth(r, c))
				return Dir.S;
			else if (canMoveWest(r, c))
				return Dir.W;
			break;

		}
		}
		return null;
	}

	private boolean canMoveNorth(int r, int c) {
		if (r == 0)
			return false;
		if (maze[r - 1][c] == wall)
			return false;
		return true;
	}

	private boolean canMoveSouth(int r, int c) {
		if (r == rows - 1)
			return false;
		if (maze[r + 1][c] == wall)
			return false;
		return true;
	}

	private boolean canMoveEast(int r, int c) {
		if (c == cols - 1)
			return false;
		if (maze[r][c + 1] == wall)
			return false;
		return true;
	}

	private boolean canMoveWest(int r, int c) {
		if (c == 0)
			return false;
		if (maze[r][c - 1] == wall)
			return false;
		return true;
	}

	@Override
	public List<Cell> getNeighbors(int row, int col) {
		// TODO Auto-generated method stub
		return null;
	}

}
