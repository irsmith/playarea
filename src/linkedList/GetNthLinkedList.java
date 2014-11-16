package linkedList;

public class GetNthLinkedList {

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
	
	public GetNthLinkedList(Integer[] integers) {
       //insert sorted
		for (int i:integers) {
			//System.out.println(this);
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
	

	// takes index into "array" and returns data at that index
	private int getnth(int idx, Node n) {
		
		int k = -1;
		for (Node cur=n; cur!=null;cur=cur.next){
			if (++k == idx) {
				return cur.val;
			}
		}
		return -1;
	}
	
	private int pop(Node n) {
		assert n!= null;
		Node oldhead = head;
		head = head.next;
		
		return oldhead.val;
	}
	public static void main(String[] args) {
		GetNthLinkedList ll = new GetNthLinkedList(new Integer[]{2,3,4,5,6});
		System.out.println(ll.getnth(3, ll.head));
		System.out.println(ll.pop(ll.head));
		System.out.println(ll);
		System.out.println(ll.pop(ll.head));
		System.out.println(ll);System.out.println(ll.pop(ll.head));
		System.out.println(ll);
	}

	
}
