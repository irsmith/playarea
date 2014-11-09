package phoneScreen;


public class CloseTo1000 {

	// Write a method which given two integers, returns the integer that is
	// closest to 1000.
	// Either define whether a and b are distinct, or define a return value for this case.
	static int closest(int a, int b) throws Exception {
        if (a == b) throw new Exception("depends on problem constraints");

		//if (a == Integer.MAX_VALUE || a==Integer.MIN_VALUE || b==Integer.MAX_VALUE||b==Integer.MIN_VALUE) {  handled by using long
        long gapa = Math.abs(1000 - a);//use long for -2^32
        long gapb = Math.abs(1000 - b);
        return (gapa < gapb) ? a : b;
		
	}

	//http://stackoverflow.com/questions/23794848/a-method-which-given-two-integers-returns-the-value-that-is-closest-to-1000
	public static void main(String[] args) throws Exception {
	//	NumberFormatter nf = new NumberFormatter("###.##");
		
		// java int or byte is always signed, so int max is 2^63 -1 and min is 
		//-231 and a maximum value of 231-1. 
		//byte b = 0b10000000; // won't compile because max signed byte is 2^-1
		byte b = 0b1000000; // 1 followed by 6 zeros
	    b = 0b1111111; // 0 followed by 7 ones is Byte.Max is positive ( + 2^7 - 1)
		System.out.format(": %d %n", b);

	    b = +0b0000000; // 0 followed by 7 zeros is 0
		System.out.format(": %d %n", b);

	    b = -0b1111111; // neg 0 followed by 7 ones is Byte.Min is neg (2^7)

		System.out.format(": %d %n", b);
		System.out.println(closest(-2, -4));
		System.out.println(closest(-2, 4));

		//System.out.println(closest(-2, -2));
		System.out.println(closest(998, 1002));
		System.out.println(closest(Integer.MIN_VALUE,3));

	}

}
