package playground;

public class Rotate {
	// Java version, fully tested

	static int N = 4;

	private static void print(int[][] m) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(m[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void rotate90(int[][] m) {
		// transpose
		for (int r = 0; r < N ; r++) {
			for (int c = r+1; c < N ; c++) {
				//System.out.format("M[%d][%d]", r, c);
				int temp = m[r][c];
				m[r][c] = m[c][r];
				m[c][r] = temp;
				//swap(m[r][c],m[c][r]);
			}
		}
		print(m);
		System.out.println();
		//swap each row
		for (int r=0; r<N; r++) {
			for (int c=0;c < (N/2); c++) {
			   //swap(m[r][c],m[r][(N-1) - c]);
				int tmp = m[r][c];
				m[r][c] = m[r][(N-1) -c];
				m[r][(N-1) -c] = tmp;
			}
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
