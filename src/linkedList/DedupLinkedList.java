package linkedList;

//http://cslibrary.stanford.edu/105/

// both recursive and iteratv
//https://www.youtube.com/watch?v=KYH83T4q6Vs
public class DedupLinkedList {

	Node head;

	class Node {
		Node next;
		int val;

		Node(int v) {
			val = v;
		}

		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}

	public DedupLinkedList(Integer[] integers) {
		// create ll, insert sorted
		for (int i : integers) {
			System.out.println(this);
			if (head == null) {
				head = new Node(i);
				continue;
			}
			Node prev = null;
			Node n = head;
			while (n != null && n.val <= i) {
				prev = n;
				n = n.next;
			}

			Node newn = new Node(i);
			prev.next = newn;
			newn.next = n;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node c = head;
		while (c != null) {
			sb.append(c.toString()).append(" ");
			c = c.next;
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		DedupLinkedList ll = new DedupLinkedList(new Integer[] { 2, 2, 34, 5,
				5, 6, 31 });
		System.out.println(ll);

		Node newhead = ll.dedup(ll.head);
		System.out.println(ll);

	}

	private Node dedup(Node n) {
		head = dedup(n, null);
		return head;
	}

	// recursive
	private Node dedup(Node n, Node prev) {
		//on way down, save whether isDup
		boolean isdup = false;
		if (n == null) {
			return null;
		}
		if (prev != null && n.val == prev.val)
			isdup = true;
		
		// descend... retrun value will reset next
		n.next = dedup(n.next, n);
		
		// skip this if a dup
		if (isdup) {
			return n.next;
		} else {
			return n;
		}
	}

}
