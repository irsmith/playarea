package playground;

public class Permute {
	 public static void permute(char[] a, int seg) {
	     if (seg == 1) {
	        System.out.println(a);
	        return;
	     }
	     for (int i = 0; i < seg; i++) {
	    	System.out.println("permut first "+seg);
	        swap(a, i, seg-1);
	        permute(a, seg-1);
	        swap(a, i, seg-1);
	    }
	 }  
	 public static void swap(char[] a, int i, int j) {
		    char c;
		    c = a[i]; 
		    a[i] = a[j]; 
		    a[j] = c;
		 }
	 
	 public static void main(String[] args) {
		permute(new char[]{'a','b','c','d'}, 4);
	}
}
