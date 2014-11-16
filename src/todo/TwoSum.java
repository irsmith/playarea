package todo;

// given arrary of ints and target ret t/f if 2 values can sum to Target
public class TwoSum {

	
	public static void main(String[] args) {
		String dog = "dog";
		rev (dog.toCharArray(), 0,2);
		String a = "  dog  food ";

		revall(a);
		System.out.println(a);
	}

	private static void revall(String a) {

		char[] aa = a.toCharArray();
		int E = 0;
		int S = 0;
		while (E < a.length()) {
			S = E;
			if (aa[E] == ' ') {
				E++;
			} else {
				 while (aa[E] != ' ' && E < a.length()) {
					 E++;
				 }
				 rev(aa, S, E-1);
			}
			
		}
		return ;
	}

	private static void rev(char[] a, int s, int e) {
		

		 int i = s;
		 int j = e;
		 while (j > i) {
			 char tmp = a[i];
			 a[i] = a[j];
			 a[j] = tmp;
			 j--;
			 i++;
		 }
		
	}
	
}
