package permutations;
public class StrPermutation {
	public static void permute(char[] a, int length) {
		if (length == 1) {
			System.out.println(a);
			return;
		}
		for (int i = 0; i < length; i++) {
			swap(a, i, length - 1);
			System.out.println(i+" = idx; ready for :" +new String(a));
			permute(a, length - 1);
			swap(a, i, length - 1);
		}
	}


	private static void swap(char[] a, int i, int j) {
        char c = a[i]	;
        a[i] = a[j];
        a[j] = c;
	}
	public static void main(String[] args) {
		String a= "ab";
		a.toLowerCase();
		
		permute(a.toCharArray(), a.length());
	}
}
