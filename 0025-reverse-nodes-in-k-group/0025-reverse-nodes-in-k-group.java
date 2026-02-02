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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
         if(head==null || head.next==null) return head;
        ListNode res=null;
        ListNode left=head;
        ListNode right;
        ListNode nextleft=null;
        ListNode prevleft=null;
        
        while(true){
            right=left;
            for(int i=0; i<k-1;i++){
                if(right==null){
                   break;
                }
                right=right.next;
            }
            if(right!=null){
                nextleft=right.next;
                reverse(left,k);
                if(prevleft!=null){
                    prevleft.next=right;
                }
                if(res==null){
                    res=right;
                }
                prevleft=left;
                left=nextleft;
            }else{
                if(prevleft!=null){
                    prevleft.next=left;
                }
                if(res==null){
                    res=left;
                   
                }
                 break;
            }
          
        }
          return res;
        
    }
    public void reverse(ListNode head, int k){
        ListNode curr=head;
        ListNode prev=null;
        while(k>0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            k--;
        }
    }
}