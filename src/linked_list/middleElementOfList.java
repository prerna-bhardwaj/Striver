package linked_list;

public class middleElementOfList {
	
	// O(n/2) time | O(1) space
	public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
	
	public static void main(String[] args) {
		ListNode head = ListNode.getList();
		ListNode.printList(head);
		ListNode middle = middleNode(head);
		System.out.println(middle + " " + middle.data);
		
		head = ListNode.getListEven();
		ListNode.printList(head);
		middle = middleNode(head);
		System.out.println(middle + " " + middle.data);
		
		head = ListNode.getEmptyList();
		ListNode.printList(head);
		middle = middleNode(head);
		System.out.println(middle);
	}
}
