package recursion;

public class RemoveDups {

	public static void main(String[] args) {
		System.out.println(mod(5, 3));

//		
//		System.out.println(sumto(5));
//
//		System.out.println(rm("aa"));
//
//		System.out.println(rm("aabbbcdefff"));
//
//		System.out.println(rm(""));
//		System.out.println(reverse("cat"));

	}

	//compute modulo m w/out using %
	private static int mod(int N, int m) {
		
		return N - (N/m);
	}
	
	
	private static int sumto(int k) {
		if (k==0) {
			return 0;
		}else {
			return k + sumto(k-1);
		}
	}
	private static String reverse(String string) {

		if (string == null || string.length()<=1) {
			return string;
		} 
		return string.substring(string.length()-1) + reverse(string.substring(0, string.length()-1));
		
	}

	// rm dups
	private static String rm(String string) {

		if (string == null || string.length() <= 1) {
			return string;
		} else {
			if (string.charAt(0) == string.charAt(1)) {
				// knock off the front
				return rm(string.substring(1));
			} else {
				return string.substring(0, 1) + rm(string.substring(1));
			}
		}
	}

}
