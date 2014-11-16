package binaryTrees;
import java.util.Arrays;
import java.util.List;

/**
 * Find height of binary tree. This is not a binary search tree.
 */
public class SimpleFindDepthBT {

    BST.Node root;
    private static int depth(BST.Node n) {
    	if (n==null) return 0;
    	int maxleft = depth(n.left);
    	int maxright = depth(n.right);
    	return 1 + Math.max(maxleft, maxright);
    }
	public static void main(String[] args) {

		List<Integer> alist = Arrays.asList(5, 3, 0, 2, 4, 1, 6, 7);
		BST bst = new BST(alist);
		System.out.println(bst.levelOrder());
		System.out.println(depth(bst.root));
	}

}
