package linkedList;

public class ReverseLL {
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

	// returns reversed list
	void reverse_m(Node head) {
		if (head == null || head.next == null)
			return;
		// now we have 2 or more, make pointers to first, second and third;
		Node second = head.next;
		Node third = head.next.next;

		// reverse first and second to make beginning of the NULLL-terminated
		// list
		second.next = head;
		head.next = null;

		if (third == null)
			return; // tiny optimization....

		Node current = third;
		Node previousNode = second;
		// starting at third, if next is not null , add it to front of list
		// for (Node current = third; current != null; current = current.next) {
		while (current != null) {
			Node nextNode = current.next;
			current.next = previousNode;

			previousNode = current;
			current = nextNode;

		}

	}

	/** add to beginning. */
	void add(int i) {
		Node newnode = new Node();
		newnode.value = i;
		Node oldhead = first;
		first = newnode;
		first.next = oldhead;
		length++;

	}

	public static void main(String[] args) {
		ReverseLL r = new ReverseLL();
		r.add(456);
		r.add(789);
		r.add(123);
		r.print(r.first);// 123 789 456
		r.recursivePrint(r.first);

//		r.reverse2();
//		
//		r.delete(789);
//		r.print(r.first);
//		r.delete(456);
//		r.print(r.first);// 123 789 456

		// Node rev = r.reverse_m(r.fisrt);
		// r.print(rev);
	}

	private void recursivePrint(Node h) {
        if (h == null) {
        	return;
        } else {
        	recursivePrint(h.next);
        	System.out.print(h.value+" ,");
        }
		
	}

	private void reverse2() {
		if (first == null || first.next == null)
			return;

		
		
	}

	private void delete(int i) {
		if (first.value == i) {
			first = first.next;
			return;
		}
		Node prev = first;
		for (Node n = first.next; n != null; n = n.next) {
            if (n.value == i) {
            	// delete n
            	prev.next = n.next;
            }
            prev = n;
		}
	}
}
