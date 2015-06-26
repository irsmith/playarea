package binary_tree;

import java.util.LinkedList;

public class Bst2 {
	public Node root;

	public class Node {
		public int v;
		public Node left;
		public Node right;

		public Node(int v2) {
			v = v2;
		}

		@Override
		public String toString() {
			return String.valueOf(v);
		}
	}

	Node insert(int v, Node n) {
		if (n == null)
			return new Node(v);
		// find where it goes, either r or left
		if (v < n.v) {
			n.left = insert(v, n.left);
		} else if (v > n.v ){
			n.right = insert(v, n.right);
		} else {
			n.v = v;
		}
		return n;
	}

	String levelOrder() {
		assert root != null;
		StringBuilder sb = new StringBuilder();
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {

			Node n = q.remove();
			assert n != null;

			sb.append(String.valueOf(n.v)).append(" ");
			if (n.left != null) q.add(n.left);
			if (n.right != null) q.add(n.right);
		}

		return sb.toString();
	}

	public Bst2(Integer[] a) {
		for (int i = 0; i < a.length; i++) {
			root = insert(a[i], root);

		}
	}

	public static void main(String[] args) {
		Integer a[] = { 8, -2, 9, 1 };

		Bst2 b = new Bst2(a);
		System.out.println(b.levelOrder());
		

	}
}
