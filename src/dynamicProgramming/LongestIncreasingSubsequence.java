package dynamicProgramming;

//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/

//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

public class LongestIncreasingSubsequence {

	class Data {
		int length;
		int maxSoFar;

		public Data(int length, int m) {
			super();
			this.length = length;
			this.maxSoFar = m;
		}
	}

	int lis_helper(int a[]) {
		int maxSoFar = Integer.MIN_VALUE;
		int len = 0; // length so far. If len=1 then we are at a[0]
		Data data = _lis(a, maxSoFar, len);
		return data.length;
	}

	private Data _lis(int[] a, int max_ref, int len) {
		if (len == 1) return new Data(1, max_ref);//?? not sure about what max should be
		
		
		Data thisdata = null;
	    int res, max_ending_here = 1; // length of LIS ending with arr[n-1]
	    
		  /* Recursively get all LIS ending with arr[0], arr[1] ... ar[n-2]. If
	       arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs
	       to be updated, then update it */
	    for(int i = 1; i < len; i++)
	    {
	    	
	        Data d = _lis(a, i, max_ref);
	        res = d.length;
	        if (a[i-1] < a[len-1] && res + 1 > max_ending_here)
	            max_ending_here = res + 1;
	    }
	 
	    // Compare max_ending_here with the overall max. And update the
	    // overall max if needed
	    if (*max_ref < max_ending_here)
	       *max_ref = max_ending_here;
	 
	    // Return length of LIS ending with arr[n-1]
	    return max_ending_here;
		return thisdata;
	}
}
