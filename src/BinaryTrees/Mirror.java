package binaryTrees;

import binaryTrees.Bst2.Node;

/**
 * /*
 Change a tree so that the roles of the
 left and right pointers are swapped at every node.
 * @author irene
 *
 */
public class Mirror {
 
	public static void main(String[] args) {
		Bst2 b = new Bst2(new Integer[] {5,23,37,8,33});
		
		Node newtree = mirror(b.root);
		System.out.println(b.levelOrder());

        System.out.println(print(newtree));
		
	}

	private static String print(Node n) {
       // print preorder
		if (n==null) return "";
		return String.valueOf(n.v)+" "+print(n.right) + " "+print(n.left) ; 
		
	}

	private static Node mirror(Node n) {
		if (n==null) return null;
		Node tmp = n.left;
		n.left = n.right;
		n.right = tmp;
		
        mirror(n.left);
        mirror(n.right);
		return n;
	}
}
