package linkedList;

//http://cslibrary.stanford.edu/105/

// both recursive and iteratv
//https://www.youtube.com/watch?v=KYH83T4q6Vs
public class FrontBackSplitLinkedList {

	Node head;

	class Data {
		Node front;
		Node back;

		public String toString() {
			return "f:" + printll(front) + " b:" + printll(back);
		}

		Data(Node f, Node b) {
			front = f;
			back = b;
		}
	}

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

	/**
	 * Given a list, split it into two sublists — one for the front half, and
	 * one for the back half. If the number of elements is odd, the extra
	 * element should go in the front list. So FrontBackSplit() on the list {2,
	 * 3, 5, 7, 11} should yield the two lists {2, 3, 5} and {7, 11}. Getting
	 * this right for all the cases is harder than it looks. You should check
	 * your solution against a few cases (length = 2, length = 3, length=4) to
	 * make sure that the list gets split correctly near the short-list boundary
	 * conditions. If it works right for length=4, it probably works right for
	 * length=1000. You will probably need special case code to deal with the
	 * (length <2) cases. Hint. Probably the simplest strategy is to compute the
	 * length of the list, then use a for loop to hop over the right number of
	 * nodes to find the last node of the front half, and then cut the list at
	 * that point. There is a trick technique that uses two pointers to traverse
	 * the list. A "slow" pointer advances one nodes at a time, while the "fast"
	 * pointer goes two nodes at a time. When the fast pointer reaches the end,
	 * the slow pointer will be about half way. For either strategy, care is
	 * required to split the list at the right point.
	 * 
	 * @param integers
	 */
	public FrontBackSplitLinkedList(Integer[] integers) {
		// insert sorted
		for (int i : integers) {
			System.out.println(this);
			if (head == null) {
				head = new Node(i);
				System.out.println(head);
				continue;
			}
			Node prev = null;
			Node n = head;
			while (n != null && n.val <= i) {
				prev = n;
				n = n.next;
			}
			// so n=null or n.val > i
			// assert n.val > i thus insert before n (after prev
			Node newn = new Node(i);
			prev.next = newn;
			newn.next = n;
		}
	}

	public String printll(Node head) {
		StringBuilder sb = new StringBuilder();
		Node c = head;
		while (c != null) {
			sb.append(c.toString()).append(" ");
			c = c.next;
		}
		return sb.toString();
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
		FrontBackSplitLinkedList ll = new FrontBackSplitLinkedList(
				new Integer[] { 0, 1, 2, 3, 4 });
		System.out.println(ll.head);

		Data d = ll.split(ll.head);
		System.out.println("font=="+d.front);
		System.out.println("bk=="+d.back);

	}

	private Data split(Node head) {
		Node bkhead = null;
		Node fast = head, slow = head;
		boolean done = false;
		do {
			slow = slow.next;
			if (fast.next == null) { // fast always on even idx; list len is odd
				done=true;
				bkhead = slow.next;
			} else if (fast.next.next == null) { // list len is even
				done=true;
				bkhead = slow.next;
			} else {
				fast = fast.next.next;
			}

		} while (!done);
		slow.next = null;
		return new Data(head, bkhead);
	}
}
