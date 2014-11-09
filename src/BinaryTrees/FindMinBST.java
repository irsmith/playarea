package BinaryTrees;
import java.util.Arrays;
import java.util.List;

/**
 * Find min val in binary s tree.
 */
public class FindMinBST {

    BST.Node root;
    private static int findMin(BST.Node n) {
    	BST.Node rv = findMin(n, true);
    	return rv == null? Integer.MAX_VALUE : rv.val;
    	
    }
	private static BST.Node findMin(BST.Node n, boolean b) {
		
        if (n==null) return null;
        if (n.left != null) 
        	return findMin(n.left, true) ;
        else if (n.right != null) return findMin(n.right, true);
        else return n;
	}
	
	/*
	 * NOTE, this is important to ask the constraints because dealing w an empty tree made me confused
	 Given a non-empty binary search tree,
	 return the minimum data value found in that tree.
	http://cslibrary.stanford.edu/110/ BinaryTrees.html
	Binary Trees
	Page: 11
	Note that the entire tree does not need to be searched.
	*/
	
	public static void main(String[] args) {

		List<Integer> alist = Arrays.asList(5, 3, 0, 2, 4, 1, 6, 7);
		BST bst = new BST(alist);
		System.out.println(bst.levelOrder());
		System.out.println(findMin(bst.root));
	}

}
