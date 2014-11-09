package todo;

import BinaryTrees.Bst2;

/**
 * 7. hasPathSum() Solution (C/C++) /* Given a tree and a sum, return true if
 * there is a path from the root down to a leaf, such that adding up all the
 * values along the path equals the given sum.
 * http://cslibrary.stanford.edu/110/ BinaryTrees.html Binary Trees Page: 12
 * Strategy: subtract the node value from the sum when recurring down, and check
 * to see if the sum is 0 when you run out of tree.
 *
 */
public class HasPathSum {

	public static void main(String[] args) {
		Integer a[] = { 8, -2, 9, 1 };
		Bst2 b = new Bst2(a);
		System.out.println(hasPath(17, b.root));

	}

	// input target decrements by node amount each time.
	private static boolean hasPath(int target, Bst2.Node n) {

		if (n == null) {
			// we are at leaf. check results

			return (target == 0) ? true: false;
		}
		// visit
		System.out.format("sum=%d at node %s%n", target, n.v);
		target -= n.v;
		System.out.format("AFTER sum=%d at node %s%n", target, n.v);

        boolean lefttrail = hasPath(target, n.left);
        if (lefttrail == true)
			return true;
		else {
	        return hasPath(target, n.right);
		}
	}
}
