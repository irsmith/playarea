package linkedList;

import org.junit.Assert;


public class AgainSingleLinkedList {
	// Hint... circular list should have next and previous instead of first and
	// last. The logic matters
	// EVERYTHING HERE NEEDS TO BE MAINTAINED UPON MUTATION!

	Node first;
	int length = 0;// ? have this

	private class Node {
		// http://stackoverflow.com/questions/4300908/java-programming-circular-linkedlist
		// for a cirular linked list, use next and prev (not first and last)
		Node next; // singly linked list
		// Node prev; // doubly linked list
		int value;

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public Node(int v) {
			value = v;
		}
	}

	public int length() {
		return length;
	}

	private void reverse() {

	}

	void print() {
		for (Node x = first; x != null; x = x.next) {
			System.out.print(x.value + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		AgainSingleLinkedList s = new AgainSingleLinkedList();

		// insert at beginning
		s.print();
		s.insertAtBeginning(12);
		Assert.assertEquals(1, s.length());
		s.print();
		s.insertAtBeginning(99);
		Assert.assertEquals(2, s.length());
		s.print();
		// s.insertAtEnd(37);
		// s.print();
		// s.reverse();
		// s.print();

	}

	private void insertAtBeginning(int i) {
		Node newnode = new Node(i);

		Node oldfirst = first;
		first = newnode;
		first.next = oldfirst;
		// Node tmp = head;
		// head = newnode;
		// head.next = tmp;
		length++;
	}

}
