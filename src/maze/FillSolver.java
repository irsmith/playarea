package maze;

import java.util.ArrayList;
import java.util.List;

public class FillSolver extends Solver {

	public FillSolver(int startRow, int startCol, char[][] cmaze) {
		super(startRow, startCol, cmaze);
		dfs(startRow, startCol);// find all path to's
	}

	@Override
	public List<Cell> getNeighbors(int row, int col) {
		List<Cell> neighbors = new ArrayList<Cell>();
		if (row != 0 && (maze[row - 1][col] == open)) {
			// north
			neighbors.add(new Cell(row - 1, col));
		}
		if (col != (cols - 1) && (maze[row][col + 1] == open)) {
			// east
			neighbors.add(new Cell(row, col + 1));
		}
		if (col != 0 && (maze[row][col - 1] == open)) {
			// west
			neighbors.add(new Cell(row, col - 1));
		}
		if (row != (rows - 1) && (maze[row + 1][col] == open)) {
			// south
			neighbors.add(new Cell(row + 1, col));
		}
		System.out.format("getneighbors: row:%d col %d len:%d %n", row,
				col, neighbors.size());

		return neighbors;
	}

	private void dfs(int row, int col) {
		maze[row][col] = marked; // visiting this. 1) mark it, 2) descend
		for (Cell neighbor : this.getNeighbors(row, col)) {
			if (maze[neighbor.row][neighbor.col] == open) {
				edgeTo.put(neighbor, new Cell(row, col));
				dfs(neighbor.row, neighbor.col);
			}
		}
		return;
	}
}
