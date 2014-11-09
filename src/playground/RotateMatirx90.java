package playground;

public class RotateMatirx90 {
	// Java version, fully tested

	public static void reverseElementsRowWise(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n / 2; ++j) {
				int temp = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}

	public static void transpose(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
				print(matrix);
				System.out.println();

			}
		}
	}

	public static void rotate90(int[][] matrix) {
		transpose(matrix);
		reverseElementsRowWise(matrix);
	}

	public static void print(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		System.out.println("before");
		print(matrix);
		rotate90(matrix);
		System.out.println("after");
		print(matrix);
	}
}
