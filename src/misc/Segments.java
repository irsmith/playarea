package misc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 
 * Scanner sc = new Scanner(System.in);
 int numberOfLines = Integer.parseInt(sc.nextLine());


 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

 java7
 List<String> all = Files.readAllLines(System.in, StandardCharsets.UTF_8);

 */
public class Segments {

	public static void main(String[] args) throws Exception {
		
		List<Integer> rv = new ArrayList<Integer>();
		
		int A [] = new int[] {486 ,962, 556, 698, 608, 201, 836, 446, 193 ,861, 280, 804, 710, 442, 349 };
		int B [] = new int[] {3,4,5};
		int i = 0;
		int j = 0;
		
		Arrays.sort(A);
		Set<Integer> set = new HashSet<Integer> ();
		for (int x : A) {
			set.add(x);
		}
		
		for (int y: B) {
			if (set.contains(y)){
				rv.add(y);
			}
		}
		System.out.println(rv);
		
//		Scanner sc = new Scanner(System.in);
//		int nbrSeg = sc.nextInt();
//		int nbrTestCases = sc.nextInt();
//
//		int[] widths = new int[nbrSeg];
//		for (int j = 0; j < nbrSeg; j++) {
//			widths[j] = sc.nextInt();
//		}
//
//		for (int i = 0; i < nbrTestCases; i++) {
//			int start = sc.nextInt();
//			int end = sc.nextInt();
//			int min = Integer.MAX_VALUE;
//			for (int k = start; k <= end; k++) {
//				if (widths[k] < min) {
//					min = widths[k];
//				}
//			}
//			System.out.println(min);
//		}
	}

}
