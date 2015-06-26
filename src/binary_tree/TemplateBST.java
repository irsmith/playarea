package binary_tree;
import java.util.Arrays;
import java.util.List;

/**
 */
public class TemplateBST {

    BST.Node root;
 	public static void main(String[] args) {

		List<Integer> alist = Arrays.asList(5, 3, 0, 2, 4, 1, 6, 7);
		BST bst = new BST(alist);
		System.out.println(bst.levelOrder());
	}

}
