package todo;
//http://www.glassdoor.com/Interview/Find-the-balance-point-in-an-array-The-index-where-the-sum-of-the-elements-to-the-left-it-is-the-same-as-the-sum-of-the-e-QTN_245781.htm
//http://www.geeksforgeeks.org/equilibrium-index-of-an-array/

public class BalancePoint {

	
	public static void main(String[] args) {
		// do for both sorted array and unsorted
		//Integer a[] = { 2, 4,-1,-1};
		//Integer a[] = { 0,0,2, 4,-1,-1};
		Integer a[] = { 33,1,2};

		System.out.println(balancePoint(a));
		
	}

	private static int balancePoint(Integer[] a) {
		
        long sumall = 0;
        for (int c : a) {
        	sumall+=c;
        }
        int sumleft = 0;
        for (int i=0;i<a.length;i++) {
        	sumleft += a[i];
        	sumall -= a[i];
        	if (sumleft == sumall) return i;
        }
		return -1;
	}
}
