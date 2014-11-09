package todo;

import java.util.Random;

//mcdowel pag 220 Given a node in a BST, find next mode
// you can assume there are up links to parent

public class FindClosestBSt {

	Random r;
	static Node root;

	class Node {
		public Node(int v) {
			key = v;
		}

		Node parent;
		Node left;
		Node right;
		int sz = 1;
		int key;

		@Override
		public String toString() {
			return Integer.toString(key);
		}
	}

	// if r is not null makes a non-search tree, used for testing
	public FindClosestBSt() {
	}

	public void add(int v) {
		root = add(v, root);
	}

	@Override
	public String toString() {
		return recprint(root);

	}

	private String recprint(Node n) {
		if (n == null) {
			return "";
		} else {
			return recprint(n.left) + " " + n + " " + recprint(n.right);// inorder
																		// 2
			// 10 25 28 30 125
			// return n + " " + recprint(n.left) + " " + recprint(n.right); //
			// pre
			// order
			// 28
			// return recprint(n.left) +" "+ recprint(n.right)+ " "+n; //post
			// order 2 25 10 125 30 28
		}

	}

	private Node add(int v, Node n) {
		if (n == null) {
			Node newn = new Node(v);
			return newn;
		} else {
			if (v <= n.key) { // NO! compare input arg (prospective key) to THIS
								// node's key!
				n.left = add(v, n.left);
			} else if (v > n.key) {
				n.right = add(v, n.right);
			} else if (v == n.key) {
				n.key = v;
			}

		}
		return n;
	}

	public static void main(String[] args) {
		FindClosestBSt t = new FindClosestBSt();
		t.add(28);
		t.add(10);
		t.add(30);
		t.add(25);
		t.add(125);
		t.add(2);

		t.recprint(t.root);
		System.out.println(t);
		System.out.println(findNext(29, t.root));
		System.out.println(find(285, t.root));

	}

	/**
	 * return node of next in order of query node q. return null if none exists
	 * (higher than q).
	 */
	private static Node findNext(int target, Node n) {
		return null;
	}

	private static Node find(int qi, Node n) {
		if (n == null)
			return null;
		if (qi == n.key)
			return n;
		if (qi <= n.key) {
			return find(qi, n.left);
		} else {
			return find(qi, n.right);
		}
	}

}
