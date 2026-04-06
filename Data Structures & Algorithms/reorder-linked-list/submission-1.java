/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution 
{
    public ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null)
        {
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }

    public ListNode findMiddle(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    public void reorderList(ListNode head) 
    {

        ListNode middle=findMiddle(head);
        ListNode second=reverse(middle.next);
        middle.next=null;
        ListNode first=head;

        while(second !=null)
        {
            ListNode temp1=first.next;
            ListNode temp2=second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        }
        
}
