package binaryTrees;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BTNodeDelete {

	Map<Nod, Nod> edgeto = new HashMap<Nod, Nod>();

	private class Dat {
		Nod n;
		int lev;

		Dat(Nod n, int l) {
			this.n = n;
			this.lev = l;
		}
	}

	Random r = new Random();
	Nod bt;

	public BTNodeDelete(List<Integer> random) {
		for (int i : random) {
			bt = insert(bt, i);
		}
	}

	private Nod insert(Nod n, Integer integer) {
		if (n == null)
			return new Nod(integer);
		if (r.nextBoolean() == true)
			n.left = insert(n.left, integer);
		else
			n.right = insert(n.right, integer);
		return n;
	}



	private void deldeep(Nod bt, Nod target) {
		Dat deep = dfs(new Dat(bt, 0));
		System.out.println("deepest:" + deep.n);
		// transfer value from deepest to target
		target.data = deep.n.data;
		// delete deepest
		Nod parent = edgeto.get(deep.n);
		if (parent.left == deep.n)
			parent.left = null;
		else
			parent.right = null;
	}

	private Dat dfs(Dat cur) {

		if (cur.n == null)
			return null;
		edgeto.put(cur.n.left, cur.n); // history of how we got to cur.left is cur
		Dat L = dfs(new Dat(cur.n.left, cur.lev + 1));
		edgeto.put(cur.n.right, cur.n); 
		Dat R = dfs(new Dat(cur.n.right, cur.lev + 1));
		if (L == null && R == null)
			return cur;

		Dat deepch = null;
		if (L == null)
			deepch = R;
		else if (R == null)
			deepch = L;
		else
			deepch = (L.lev > R.lev) ? L : R;

		return (deepch.lev > cur.lev) ? deepch : cur;
	}

	private Nod findByValue(Nod n, Integer i) {
		if (n == null)
			return null;
		if (n.data == i)
			return n;
		Nod left = findByValue(n.left, i);
		if (left != null)
			return left;
		else
			return findByValue(n.right, i);
	}
	
	// given target node, find deepest node and transfer data from deepNode to
	// target then delete deepNode
	public static void main(String[] args) {
		List<Integer> random = Arrays.asList(0,1,2,3,4,5,6,7);
		Collections.shuffle(random);
		BTNodeDelete driver = new BTNodeDelete(random);

		BTreePrinter.printNode(driver.bt);
		Nod target = driver.findByValue(driver.bt,
				random.get(random.size() / 2));
		System.out.println("target: " + target);
		driver.deldeep(driver.bt, target);
		BTreePrinter.printNode(driver.bt);

	}
}
