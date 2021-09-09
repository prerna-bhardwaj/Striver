package linked_list;

public class ListNode {
	int data;
	ListNode next;
	
	public ListNode() {
		data = 0;
		next = null;
	}
	
	public ListNode(int data) {
		this.data = data;
		next = null;
	}
	
	public static ListNode getList() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		return head;
	}
	
	public static ListNode getListEven() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		return head;
	}
	
	public static ListNode getEmptyList() {
		return null;
	}
	
	public static void printList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null\n");
	}
}
