package linked_list;

public class deleteNthNodeFromEnd {
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode slow = start, fast = start;
        int i = 1;
        while(fast != null && i <= n) {
            fast = fast.next;
            i++;
        }
        // NOTE : Now, fast points to the nth node from start
        
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
	
	public static void main(String[] args) {
		ListNode head = ListNode.getList();
		ListNode.printList(head);
		ListNode newHead = removeNthFromEnd(head, 2);
		ListNode.printList(newHead);
		
		head = new ListNode(1);
		ListNode.printList(head);
		newHead = removeNthFromEnd(head, 1);
		ListNode.printList(newHead);
		
	}
}
