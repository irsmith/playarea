package BinaryTrees;

import java.util.Arrays;


public class BalancedBST {
	class Node {
		Node left;
		Node right;
		int val;
		Node(int v) {
			val = v;
		}
		@Override
		public String toString() {
			return Integer.toString(val);
		}
	}
	Node root = null;
	
	public BalancedBST(int[] a) {
		
		// if you want balanced, sort it
		Arrays.sort(a);
		if (a.length == 0) return ;
		root = make(a, 0, a.length-1);
	}
	@Override
	public String toString() {
		return inorder(root);
	}
	
	String inorder(Node n) {
		if (n==null) return "";
		return inorder(n.left)+" " + n.val+" "+ inorder( n.right);
	}

	// visualize newing from bottom up !including the null links! so base case returns null
	private Node make(int[] a, int start, int end) {

		if ( end < start) return null;
		int mid = start + ( (end-start)/2);
				
		Node newn = new Node(a[mid]);
		newn.left = make(a, start,mid-1);
		newn.right = make (a, mid+1,end);
		
		return newn;
	}

	public static void main(String[] args) {
		int[] a = new int[] {5,3,8,2,0,5,4,4};

		BalancedBST bst = new BalancedBST(a);
		Node r = bst.getRoot();
		System.out.println(bst);

	}

	private Node getRoot() {
		return root;
	}

}
