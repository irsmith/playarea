package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import binary_tree.Bst2.Node;

/*
 Given a binary tree, print out all of its root-to-leaf
 paths, one per line. Uses a recursive helper to do the work.
 */

public class PrintPaths {

	static Map<Bst2.Node, Bst2.Node> m = new HashMap<Bst2.Node, Bst2.Node>();
	static List<Node> leafs = new ArrayList<Node>();

	public static void main(String[] args) {

		Bst2 b = new Bst2(new Integer[] { 5, 4, 8, -2, 9 });
		PrintPaths pp = new PrintPaths();
		System.out.println(b.levelOrder());
		dfs(b.root, null);
		for (Node l : leafs) {
			System.out.println(pp.getPath(l));
		}

	}

	// dfs traverse, using a map for "edge to" query cache
	private static void dfs(Node n, Node fromNode) {
		if (n == null) {
			return;
		}
		if (n.left == null && n.right == null) {
			leafs.add(n);
		}
		m.put(n, fromNode);
		dfs(n.left, n);
		dfs(n.right, n);
	}

	// query the edge to structure
	List<Node> getPath(Node n) {
		List<Node> r = new LinkedList<Node>();
		Node cur = n;
		Bst2.Node from = null;
        r.add(n);
		while ((from = m.get(cur)) != null) {
			r.add(from);
			cur = from;
		}
		return r;
	}

}
