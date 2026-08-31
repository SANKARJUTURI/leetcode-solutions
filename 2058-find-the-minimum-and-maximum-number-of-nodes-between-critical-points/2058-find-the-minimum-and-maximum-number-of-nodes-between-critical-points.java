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
    public int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        ListNode temp=head.next;
        ListNode prev=head;
        int max=0;
        int min=Integer.MAX_VALUE;
        List<Integer>L=new ArrayList<>();
        int n=2;
        while(temp.next!=null)
        {
            ListNode next=temp.next;
            if((prev.val>temp.val && next.val>temp.val) || 
            (prev.val<temp.val && next.val<temp.val))
            {
                L.add(n);
            }
            prev=temp;
            temp=next;
            n++;
        }
        if(L.size()<2)return new int[] {-1,-1};
        int b=L.get(L.size()-1)-L.get(0);
        int a=b;
        for(int i=1;i<L.size();i++)
        {
            a=Math.min(L.get(i)-L.get(i-1),a);
        }
        return new int[] {a,b};
    }
}