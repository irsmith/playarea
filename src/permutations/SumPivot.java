package permutations;
//http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
public class SumPivot {

	
	public static void main(String[] args) {
		System.err.println(pivot(new int[]{-1,-2,3,-1,1,-3,3}));

		
		System.err.println(pivot(new int[]{}));
		System.err.println(pivot(new int[]{1,2,3}));
		System.err.println(pivot(new int[]{-1,-2,-3}));


	}

	private static boolean pivot(int[] a) {


		if (a.length == 0 || a.length == 1) return false;
		
		
		int i=1;
		int j=a.length -1;
	
		int sumleft = a[0];
		int sumright = a[a.length -1];
		
		while (j > i) {
			
			int gleft = Math.abs((sumleft + a[i]) - sumright);
			int gright = Math.abs((sumright + a[j]) - sumleft);
			if (gleft < gright) {
				sumleft += a[i++];
				
			} else {
				sumright += a[j--];
			}
			
			if (sumleft == sumright) return true;
			
		}
		return false;
	}
}
