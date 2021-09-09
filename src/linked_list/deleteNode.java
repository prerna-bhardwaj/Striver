package linked_list;

public class deleteNode {
	public static void deleteNodeWithRef(ListNode node) {
		// Check is it is an internal node
//		System.out.println(node);
		if(node.next != null) {
    		node.data = node.next.data;
            node.next = node.next.next;        	
        }
		else
			node = null;
		System.out.println(node);
    }
	
	public static void main(String[] args) {
		ListNode head = ListNode.getList();
		ListNode.printList(head);
		deleteNodeWithRef(head.next.next);
		ListNode.printList(head);
		
		// If ref to tail node is given, not working ??????
		head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode.printList(head);
		deleteNodeWithRef(head.next);
		ListNode.printList(head);
		
	}
}
