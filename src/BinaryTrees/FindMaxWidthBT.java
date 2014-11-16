package binaryTrees;
import java.util.Arrays;
import java.util.List;

/**
 * Find height of binary tree. This is not a binary search tree.
 */
public class FindMaxWidthBT {

	class Data {
		BST.Node node;
		int height;
		int width;

		Data(BST.Node n, int maxHeight, int w) {
			node = n;
			height = maxHeight;
			width = w;
		}
	}

	BST bst;
	int maxHeight;
	int maxWidth;

	public FindMaxWidthBT(BST bst) {
		this.bst = bst;
		Data d = find(bst.root);
		maxHeight = d.height;
		maxWidth = d.width;
	}

	private Data find(BST.Node n) {
		if (n == null)
			return null;
		Data leftd = find(n.left);
		Data rightd = find(n.right);
		int leftHeight = leftd == null ? 0 : leftd.height;
		int rightHeight = rightd == null ? 0 : rightd.height;
		int currentHeight = 1 + Math.max(leftHeight, rightHeight);
		int currentWidth = 1 + leftHeight + rightHeight;
		Data d = new Data(n, currentHeight, currentWidth);

		System.out.format("done:%d with height %d , width %d %n", d.node.val,
				d.height, d.width);
		return d;
	}

	private int report() {
		return maxWidth;
	}

	public static void main(String[] args) {

		List<Integer> alist = Arrays.asList(5, 3, 0, 2, 4, 1, 6, 7);
		BST bst = new BST(alist);
		FindMaxWidthBT f = new FindMaxWidthBT(bst);
		int rv = f.report();
		System.out.println(rv);

	}

}
