package linked_list;

/*
You are given two non-empty linked lists representing two non-negative integers. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

NOTE : The digits are stored in reverse order, and each of their nodes contains a single digit. 
*/

public class addTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		ListNode start = new ListNode();
		ListNode temp = start;
        int carry = 0, sum = 0;
        
        while(l1 != null || l2 != null) {
            int first = (l1 == null) ? 0 : l1.data;
            int second = (l2 == null) ? 0 : l2.data;
            sum = first + second + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)  
                l2 = l2.next;
        }
        if(carry > 0)
            temp.next = new ListNode(carry);
        return start.next;
    }

    public static void main(String[] args) {
    	ListNode head1 = new ListNode(1);
    	head1.next = new ListNode(9);
    	head1.next.next = new ListNode(9);
    	ListNode.printList(head1);

    	ListNode head2 = new ListNode(1);
    	head2.next = new ListNode(9);
    	ListNode.printList(head2);
    	
    	ListNode newList = addTwoNumbers(head1, head2);
    	ListNode.printList(newList);
    	// 991 + 91 = 1082
    }
}