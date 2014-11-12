package todo;
//http://cslibrary.stanford.edu/105/

// both recursive and iteratv
//https://www.youtube.com/watch?v=KYH83T4q6Vs
public class ReverseLinkedList {

	Node head;
	
	class Node {
		Node next;
		int val;
		Node(int v){
			val=v;
		}
		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}
	
	public ReverseLinkedList(Integer[] integers) {
       //insert sorted
		for (int i:integers) {
			System.out.println(this);
			if (head ==null) {
				head = new Node(i);
				System.out.println(head);
				continue;
			}
			Node prev = null;
			Node n = head;
			while (n !=null && n.val <= i) {
				prev = n;
				n=n.next;
			}
			// so n=null or n.val > i
					// assert n.val > i thus insert before n (after prev
			Node newn =new Node(i);
			prev.next=newn;
			newn.next = n;
		}
	}

	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node c = head;
		while(c != null){
			sb.append(c.toString()).append(" ");
			c=c.next;
		}
		return sb.toString();
			
	}
	public static void main(String[] args) {
		ReverseLinkedList ll = new ReverseLinkedList(new Integer[]{2,34,5,6,31});
		Node res = ll.rev(ll.head);
		
	}

	private Node rev(Node root2) {
		// TODO Auto-generated method stub
		return null;
	}
}
