package linked_list;

public class intersectionOfYList {
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        int i = 1;
        boolean one = false;
        // Get the length of shorter list in i
        while(a != null && b != null) {
            i++;
            a = a.next;
            b = b.next;
        }
        // Obtain the difference in length of both lists by completely traversing the longer one
        int diff = 0;
        if(a != null) {
            while(a != null) {
                diff++;
                a = a.next;
            }
            one = true;
        }
        else {
            while(b != null) {
                diff++;
                b = b.next;
            }
        }
        a = headA;
        b = headB;
        // Traverse the longer on by 'diff' # of nodes
        if(one == true) {
            while(diff > 0) {
                a = a.next;
                diff--;
            }
        }
        else {
            while(diff > 0) {
                b = b.next;
                diff--;
            }
        }
        // Now iterate both lists till they collide
        while(a != null && b != null) {
            if(a == b) 
                return a;
            a = a.next;
            b = b.next;
        }
        // In case of no intersection return null.
        return null;
    }
	
	// O(n + m) time | O(1) space
	public static ListNode getIntersectionNodeOptimal(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)  
            return null;
		ListNode a = headA, b = headB;
        while(a != b) {
        	// for the end of the first iteration, reset the pointers to head of the other LL
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		
		ListNode head2 = new ListNode(11);
		head2.next = new ListNode(12);
		head2.next.next = new ListNode(13);
		head2.next.next.next = head1.next.next.next;
		
		ListNode.printList(head1);
		ListNode.printList(head2);
		ListNode intersection = getIntersectionNode(head1, head2);
		System.out.println(intersection == null ? intersection : intersection.data);
		
		head2.next.next.next = null;
		ListNode.printList(head1);
		ListNode.printList(head2);
		intersection = getIntersectionNodeOptimal(head1, head2);
		System.out.println(intersection == null ? intersection : intersection.data);
		
	}
}
