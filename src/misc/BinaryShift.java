package misc;

public class BinaryShift {
	//http://stackoverflow.com/questions/7971074/working-with-binary-numbers-in-java
	//=0314159(a xor (b shl i))
public static void main(String[] args) {
	
	int a = 100;
	System.out.println(a << 2);
	int b = 0b1010;//6
	System.out.println(b ^  7);

	long sum = 0;
	for (int i = 0;i< 314159;i++) {
		sum += ( a ^  (b << i)) ;
	}
	System.out.println(sum % (1000000000 + 7));
}
}
