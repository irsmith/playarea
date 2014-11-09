package linkedList;

import org.junit.Assert;

public class OverAnOver {
	class Node {
		int value;
		Node next;
		@Override
		public String toString() 	{
			return String.valueOf(value);
		}
	}

	// maint w mutation
	int length;
	Node head;

	public static void main(String[] args) {
		OverAnOver o = new OverAnOver();
		o.print();
		o.addAtBeginning_m(3);
		Assert.assertEquals(1, o.length);
		o.print();
		o.addAtBeginning_m(333);
		o.print();
		o.addAtEnd_m(456);
		Assert.assertEquals(3, o.length);
		o.print();
		o.addAtEnd_m(789);
		Assert.assertEquals(4, o.length);
		o.print();

		Assert.assertEquals(456, 	o.get(2));
		Assert.assertEquals(333, 	o.get(0));


	}

	/** get the value at index i, where list is zero indexed. */
	private int get(int index) {
		if (head == null || index >= length) throw new RuntimeException(); 
		Node curr = head;
		 
		for (int i=0; i<index;i++){
			curr=curr.next;
		}
		
		return  curr.value;
	}

	private void addAtEnd_m(int i) {

		Node last = head;
		while (last != null && last.next != null) {
			last = last.next;
		}
		
		last.next = new Node();
		last.next.value = i;
		// check head is not mutated
		if (head == null)
			head = last;
		length++;
	}

	private void addAtBeginning_m(int i) {

		Node tmp = head;
		head = new Node();

		head.value = i;
		head.next = tmp;
		length++;
	}

	private void print() {

		for (Node n = head; n != null; n = n.next) {
			System.out.print(n.value+ " ");
		}
		System.out.println();
	}
}
