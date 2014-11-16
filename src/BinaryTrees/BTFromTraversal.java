package binaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/if-you-are-given-two-traversal-sequences-can-you
 * -construct-the-binary-tree/ Given in-order and pre-order traversal of a
 * binary search tree, build the binary search tree, and print out post-order of
 * this tree.
 * 
 * For example, In-order traversal is {10, 12, 20, 30, 37, 40, 45}
 * 
 * Pre-order traversal is {30, 20, 10, 12, 40, 37, 45}
 * 
 * To construct a BST you need only one (not in-order) traversal.
 * 
 * In general, to build a binary tree you are going to need two traversals, in
 * order and pre-order for example. However, for the special case of BST - the
 * in-order traversal is always the sorted array containing the elements, so you
 * can always reconstruct it and use an algorithm to reconstruct a generic tree
 * from pre-order and in-order traversals.
 * 
 * So, the information that the tree is a BST, along with the elements in it
 * (even unordered) are equivalent to an in-order traversal.
 */
public class BTFromTraversal {


	static Nod bt;
	static Integer[] inorder;
	static Integer[] preorder;
	static Nod bst = null;

	// triciky part is , nulls may be enqueud
	private String levelorder(Nod n) {
		StringBuilder sb = new StringBuilder();
		List<Nod> q = new ArrayList<Nod>();
		q.add(n);
		while (!q.isEmpty()) {
			Nod cur = q.remove(0);
			if (cur == null)
				continue;
			// visit q
			sb.append(cur.data.toString()).append(" ");
			q.add(cur.left);
			q.add(cur.right);
		}
		return sb.toString();
	}

	public BTFromTraversal(int rootidx, Integer[] i, Integer[] p) {
		inorder = i;
		preorder = p;
	}

	public static Nod buildBSTfromUnsortedIn() {
		for (int k = 0; k < preorder.length; k++) {
			bst = buildBST(bst, preorder[k]);

		}
		return bst;
	}

	private static Nod buildBST(Nod n, Integer v) {
		if (n == null)
			return new Nod(v);
		if ( n.data.compareTo(v) < 0) {
			n.right = buildBST(n.right, v);
		} else {
			n.left = buildBST(n.left, v);

		}
		return n;
	}

	private static void buildBT() {

		for (int r = 0; r < inorder.length; r++) {
			int rootval = inorder[r];
			int whereToSplitPreorder = r;
			bt = insert(rootval, whereToSplitPreorder); // pick from preorder
		}
	}

	private static Nod insert(int rootidx, int pivot) {

		//
		// }
		// Nod rv = new Nod(rootidx);
		//
		// int pivotinorder = -1;
		// // get idx for root val and define left arr and right arr
		// for (int i = 0; i < inorder.length; i++) {
		// if (rootval == inorder[i]) {
		// pivotinorder = i;
		// }
		// }
		// assert pivotinorder > 0;
		//
		// return rv;

		return null;
	}

	private static void buildBalancedBSTfromSortedIn() {

		Integer[] sorted = Arrays.copyOf(inorder, inorder.length); 
		Arrays.sort(sorted);
		bst = buildSorted_helper(sorted, 0, sorted.length - 1);
	}

	private static Nod buildSorted_helper(Integer[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + ((end - start) / 2);
		System.out.format("start:%d, end:%d mid=%d %n", start, end, mid);

		Nod r = new Nod(arr[mid]);
		r.left = buildSorted_helper(arr, start, mid - 1);
		r.right = buildSorted_helper(arr, mid + 1, end);
		return r;
	}

	// Know java idiom: java does not have multiple out params so for recursive, pass in the Nod and often
	// return same Nod.
	public static void main(String[] args) {
		BTFromTraversal driver = new BTFromTraversal(0,
		new Integer[] { 10, 12, 20, 30, 37, 40, 45 }, // inorder: the input stream
				new Integer[] { 30, 20, 10, 12, 40, 37, 45 }); // pre order ==
																// all the roots
		buildBSTfromUnsortedIn();
		System.out.println(driver.levelorder(bst));
        BTreePrinter.printNode(bst);

		buildBalancedBSTfromSortedIn();
		System.out.println(driver.levelorder(bst));
		BTreePrinter.printNode(bst);
		// buildBT();
		// System.out.println(driver.levelorder(bt));

	}

}
