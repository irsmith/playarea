package binaryTrees;
import java.util.Arrays;
import java.util.List;

/**
 * Find height of binary tree. This is not a binary search tree.
 */
public class FindMaxHeightBT {

	class Data {
		BST.Node node;
		int height;

		Data(BST.Node n, int maxHeight) {
			node = n;
			height = maxHeight;
		}
	}

	BST bst;
	int maxHeight;

	public FindMaxHeightBT(BST bst) {
		this.bst = bst;
		Data d = find(bst.root);
		maxHeight = d.height;
	}

	private Data find(BST.Node n) {
		if (n == null)
			return null;
		Data lefth = find(n.left);
		Data righth = find(n.right);
		Data d = new Data(n, 1 + Math.max(
				(lefth != null) ? lefth.height	: 0, 
				(righth != null) ? righth.height	: 0));

		System.out.format("done:%d with height %d %n", d.node.val, d.height);
		return d;
	}

	private int report() {
		return maxHeight;
	}

	public static void main(String[] args) {

		List<Integer> alist = Arrays.asList(5, 3, 0, 2, 4, 1, 6, 7);
		BST bst = new BST(alist);
		System.out.println(bst.levelOrder());
		FindMaxHeightBT f = new FindMaxHeightBT(bst);
		int rv = f.report();
		System.out.println(rv);

	}

}
