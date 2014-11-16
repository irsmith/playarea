package binaryTrees;
import java.util.Random;

public class BinarySearchTree {

	Random r;
	static NodeSimple root;

	class NodeSimple {
		public NodeSimple(int v) {
			key = v;
		}

		NodeSimple left;
		NodeSimple right;
		int sz = 1;
		int key;

		@Override
		public String toString() {
			return Integer.toString(key);
		}
	}

	// if r is not null makes a non-search tree, used for testing
	public BinarySearchTree(Random r) {
		this.r = r;
	}

	public void add(int v) {
		root = add(v, root);
	}

	@Override
	public String toString() {
		return recprint(root);

	}

	private String recprint(NodeSimple n) {
		if (n == null) {
			return "";
		} else {
			// return recprint(n.left) +" "+ n +" "+ recprint(n.right);inorder 2
			// 10 25 28 30 125
			return n + " " + recprint(n.left) + " " + recprint(n.right); // pre
																			// order
																			// 28
			// return recprint(n.left) +" "+ recprint(n.right)+ " "+n; //post
			// order 2 25 10 125 30 28
		}

	}

	private NodeSimple add(int v, NodeSimple n) {
		if (n == null) {
			NodeSimple newn = new NodeSimple(v);
			return newn;
		} else if (r == null) {
			if (v <= n.key) { // NO! compare input arg (prospective key) to THIS
								// node's key!
				n.left = add(v, n.left);
			} else if (v > n.key) {
				n.right = add(v, n.right);
			} else if (v == n.key) {
				n.key = v;
			}

		} else {
			if (r.nextBoolean()) {
				System.out.println("adding left");
				n.left = add(v, n.left);
			} else {
				System.out.println("adding r");

				n.right = add(v, n.right);
			}
		}
		return n;
	}

	public static boolean isBst(NodeSimple n) {
		return isBst(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBst(NodeSimple n, int min, int max) {
		if (n == null) {
			return true;
		}
		if (n.key < min)
			return false;

		if (n.key > max)
			return false;

		boolean leftIsBst = isBst(n.left, min, n.key);
		if (!leftIsBst)
			return false;
		boolean rightIsBst = isBst(n.right, n.key, max);
		if (!rightIsBst)
			return false;
		return true;

	}

	public static void main(String[] args) {
		Random r = new Random();
		BinarySearchTree t = new BinarySearchTree(null);
		addData(t);
		System.out.println(t);
		System.out.println(isBst(root));

//		BinarySearchTree t = new BinarySearchTree(r);
//		addData(t);
//		System.out.println(t);
//		System.out.println(isBst(root));

	}

	private static void addData(BinarySearchTree t) {
		t.add(28);
		t.add(10);
		t.add(30);
		t.add(25);
		t.add(125);
		t.add(2);
	}
}
