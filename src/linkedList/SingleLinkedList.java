package linkedList;

import org.junit.Assert;

public class SingleLinkedList {
	// Hint... circular list should have next and previous instead of first and
	// last. The logic matters

	Node first;
	Node last; // EVERY mutation of List needs to handle all pointers!
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

	public void insertAtBeginning(int v) {
		Node newN = new Node(v);

		Node oldFirst = first;
		first = newN;
		newN.next = oldFirst;
		last = (length == 0) ? first : oldFirst;
		length++;
		return;
	}

	public void insertAtEnd(int v) {
		Node oldLast = last;
		Node newNode = new Node(v);
		last = newNode;
		oldLast.next = newNode;
	}

	public int removeLast() {
		// this is O(n) for singly linked list. Even if we maintain last pointer
		// for LL, if our Node does not
		// have "prev" member, we cannot find its left neighbor. Unless you use
		// a doubly-linked list this is O(n).
		return -1;
	}

	public static void main(String[] args) {
		SingleLinkedList s = new SingleLinkedList();

		// insert at beginning
		s.print();
		s.insertAtBeginning(10);
		Assert.assertEquals(1, s.length());
		s.print();
		s.insertAtBeginning(9);
		Assert.assertEquals(2, s.length());
		s.print();
		s.insertAtEnd(101);
		s.print();
		s.reverse();
		s.print();

	}

	private void reverse() {
		Node prev = null;
		for (Node x = first; x != null; x = x.next) {
			Node oldPrev = prev;
			prev = x;
			prev.next = oldPrev;
		}
		
	}

	private void print() {
		for (Node n = first; n != null; n = n.next) {
			System.out.print(n.value + " ");

		}
		System.out.println();
	}

	
}
