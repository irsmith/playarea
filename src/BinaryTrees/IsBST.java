package binaryTrees;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public  class IsBST {
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

	public IsBST(int[] a) {
		// if you want balanced, shuffle it
		// Arrays.sort(a);
		root = null;
		for (int i = 0; i < a.length; i++) {
			root = insert(a[i], root);

		}
	}

	public IsBST(List<Integer> alist) {
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

		List<Integer> a = Arrays.asList(5, 3, 8, 2, 0, 5, 4, 4, 9, 10, 11, 12, 13, 14 );
		Collections.shuffle(a);
		IsBST bst = new IsBST(a);
		Node r = bst.getRoot();
		System.out.println(bst);
		System.out.println(bst.levelOrder());
	}

	private Node getRoot() {
		return root;
	}

///**
//14. isBST2() Solution (C/C++)
//Binary Trees
//Page: 17
///*
// Returns true if the given tree is a binary search tree
// (efficient version).
//*/
//int isBST2(struct node* node) {
//  return(isBSTUtil(node, INT_MIN, INT_MAX));
//}
///*
// Returns true if the given tree is a BST and its
// values are >= min and <= max.
//*/
//int isBSTUtil(struct node* node, int min, int max) {
//  if (node==NULL) return(true);
//  // false if this node violates the min/max constraint
//  if (node->data<min || node->data>max) return(false);
//  // otherwise check the subtrees recursively,
//  // tightening the min or max constraint
//  return
//    isBSTUtil(node->left, min, node->data) &&
//    isBSTUtil(node->right, node->data+1, max)
//  );
//}
// */
	boolean isBst(Node n) {
	    return isBst(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isBst(Node n, int min, int max) {
		
		if (n==null) return true;
		if (n.val > min || n.val <max) return false;
		return isBst(n.left, min, n.val) && isBst(n.right, n.val, max);
	}
}
