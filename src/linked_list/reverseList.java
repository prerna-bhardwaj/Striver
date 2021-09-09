package linked_list;

public class reverseList {
	// Iterative solution
	// O(n) time | O(1) space
	public static ListNode reverse(ListNode head) {
		ListNode prev = null, curr = head, next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		ListNode head = ListNode.getList();
		ListNode.printList(head);
		ListNode reversedHead = reverse(head);
		ListNode.printList(reversedHead);
		
		head = ListNode.getListEven();
		ListNode.printList(head);
		reversedHead = reverse(head);
		ListNode.printList(reversedHead);
		
		head = ListNode.getEmptyList();
		ListNode.printList(head);
		reversedHead = reverse(head);
		ListNode.printList(reversedHead);
	}
}
