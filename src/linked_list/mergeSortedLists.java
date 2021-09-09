package linked_list;

public class mergeSortedLists {
	
	// O(n1 + n2) time | O(n1 + n2) space
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode a = l1, b = l2, c = l3;
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                c.next = new ListNode(a.data);
                c = c.next;                    
                a = a.next;                    
            }   
            else {
                c.next = new ListNode(b.data);
                c = c.next;                    
                b = b.next;
            }
        }
        
        while(a != null) {
            c.next = new ListNode(a.data);
            c = c.next;                    
            a = a.next;
        }
        
        while(b != null) {
            c.next = new ListNode(b.data);
            c = c.next;                    
            b = b.next;
        }
        return l3.next;
    }
	
	// O(n1 + n2) time | O(1) space
	public static ListNode mergeTwoListsInPlace(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode a = l1, b = l2, c = l3;
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                c.next = a;
                c = c.next;                    
                a = a.next;                    
            }   
            else {
                c.next = b;
                c = c.next;                    
                b = b.next;
            }
        }
        if(a != null)
            c.next = a;
        if(b != null)
            c.next = b;
        return l3.next;
    }
	public static ListNode mergeTwoListsInPlaceModified(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode a = l1, b = l2, c = l3;
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                while(a != null && b != null && a.data < b.data) {
                    c.next = a;
                    c = c.next;                    
                    a = a.next;
                }                    
            }   
            else {
                while(a != null && b != null && a.data >= b.data) {
                    c.next = b;
                    c = c.next;                    
                    b = b.next;
                }                    
            }
        }
        if(a != null)
            c.next = a;
        if(b != null)
            c.next = b;
        return l3.next;
    }
	
	
	public static void main(String[] args) {
		ListNode head1 = ListNode.getList();
		ListNode head2 = ListNode.getList();
		ListNode.printList(head1);
		ListNode.printList(head2);
		ListNode merged = mergeTwoLists(head1, head2);
		ListNode.printList(merged);

		head1 = ListNode.getEmptyList();
		ListNode.printList(head1);
		ListNode.printList(head2);
		merged = mergeTwoListsInPlace(head1, head2);
		ListNode.printList(merged);
		
		head2 = ListNode.getEmptyList();
		ListNode.printList(head1);
		ListNode.printList(head2);
		merged = mergeTwoListsInPlaceModified(head1, head2);
		ListNode.printList(merged);
	}
}
