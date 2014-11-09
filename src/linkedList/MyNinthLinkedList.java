package linkedList;

import org.junit.*;

public class MyNinthLinkedList {

	// singly linked
	class Node {
		Node next;
		int value;
	}

	// maintain with each mutation
	int length;
	Node head;

	void addBeginning(int val) {

		Node oldhead = head;
		head = new Node();
		head.next = oldhead;
		head.value = val;
        length++;
	}

	void print() {

		for (Node n = head; n != null; n = n.next) {

			System.out.print(n.value + " ");

		}
        System.out.println();
	}

	public static void main(String[] args) {
		MyNinthLinkedList nin = new MyNinthLinkedList();
		nin.addBeginning(16);
		nin.print();
		nin.addBeginning(43);
		nin.print();

		nin.addBeginning(57);
		nin.print();
		Assert.assertEquals(3, nin.length);
		
		nin.addAtEnd(333);
		nin.print();
		Assert.assertEquals(4, nin.length);

	}

	private void addAtEnd(int i) {
		Node newnode = new Node();
		newnode.value = i;
        //case A
		if (head == null) {
			head = newnode;
			
		} else {
			//point to last
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newnode;
		}
		length++;

	}

}