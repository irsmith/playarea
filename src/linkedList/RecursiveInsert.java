package linkedList;

public class RecursiveInsert {
	// mutators maintain these!
	int length;
	Node first;

	class Node {
		int value;
		Node next;

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	void print(Node hh) {

		for (Node n = hh; n != null; n = n.next) {
			System.out.print(n.value + " ");
		}
		System.out.println();
	}
//http://www.ics.uci.edu/~pattis/ICS-21/lectures/llrecursion/lecture.html
	Node insertOrdered(Node n, int value) {
		if (n == null || value < n.value) {
			Node newn = new Node();
			newn.value = value;

			return newn;
		} else {
			n.next = insertOrdered(n.next, value);
			return n;
		}
	}

	Node insertRear(Node n, int value) {
		if (n == null) {
			Node newn = new Node();
			newn.value = value;

			return newn;
		} else {
			n.next = insertRear(n.next, value);
			return n;
		}
	}

	public static void main(String[] args) {
		RecursiveInsert r = new RecursiveInsert();
		r.push(789);
		r.push(456);
		r.push(123);
		r.print(r.first);// 123 456 789
		// r.recursivePrint(r.first);
		r.insertRear(r.first, 101112);
		r.print(r.first);// 123 456 789 101112
		r.insertOrdered(r.first, 1000);
		r.print(r.first);
	}

	private void push(int i) {
		// create the node
		Node newn = new Node();
		newn.value = i;

		// add before first
		Node oldfirst = first;
		first = newn;
		newn.next = oldfirst;
	}

	private void recursivePrint(Node n) {
		if (n == null) {
			return;
		} else {
			System.out.println(n.value);
			recursivePrint(n.next);

		}

	}
}
