package binary_tree;
import java.util.LinkedList;
import java.util.List;

public  class BST {
	public static class Node {
		Node left;
		Node right;
		int val;

		Node(int v) {
			val = v;
		}

		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}

	Node root = null;

	public BST(int[] a) {
		// if you want balanced, shuffle it
		// Arrays.sort(a);
		root = null;
		for (int i = 0; i < a.length; i++) {
			root = insert(a[i], root);

		}
	}

	private int[] convertListToPrimitive(List<Integer> alist) {
		int[] rv = new int[alist.size()];
		// convert list to primitive array. Java has no built in to do this
		for (int i = 0; i < alist.size(); i++) {
			rv[i] = alist.get(i);
		}
		return rv;
	}
	
	public BST(List<Integer> alist) {
	    root = null;
		for (int i:alist) {
			root = insert(i, root);
		}
	}

	// visualize newing from top down. Look for where it goes (either l or r of
	// n) then
	// insert it on its left side or insert it on its right side
	private Node insert(int v, Node n) {

		// find where v should go then insert it
		if (n == null)
			return new Node(v);
		if (v == n.val) {
			// do nothing
		} else if (v < n.val) {
			n.left = insert(v, n.left);
		} else {
			n.right = insert(v, n.right);
		}
		return n;
	}

	@Override
	public String toString() {
		return inorder(root);
	}

	String inorder(Node n) {
		if (n == null)
			return "";
		return " l:" + inorder(n.left) + " n:" + String.valueOf(n.val) + " r:"
				+ inorder(n.right);
	}

	String levelOrder() {
		List<Integer> rv = new LinkedList<Integer>();

		List<Node> ll = new LinkedList<Node>();
		ll.add(root);
		while (!ll.isEmpty()) {
			Node n = ll.remove(0); // not get! remove!
			if (n == null)
				continue;
			rv.add(n.val);
			ll.add(n.left);
			ll.add(n.right);
		}
		return rv.toString();
	}

	public static void main(String[] args) {

		int[] a = new int[] { 5, 3, 8, 2, 0, 5, 4, 4, 9, 10, 11, 12, 13, 14 };
		BST bst = new BST(a);
		Node r = bst.getRoot();
		System.out.println(bst);
		System.out.println(bst.levelOrder());

		// int[] a = new int[] {5,3,8,2,0,5,4,4};
		// BST bst = new BST(a);
		// Node r = bst.getRoot();
		// System.out.println(bst);

	}

	private Node getRoot() {
		return root;
	}


}
