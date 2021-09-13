class Solution {
   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        
        ListNode result=new ListNode();
        ListNode tt=result; //헤더 역할 tt가 필요하다.
        int cnt=0;
        
        while(l1!=null||l2!=null){
           int sum=cnt;
            
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
        
            result.next=new ListNode(sum%10);
            result=result.next;
            
            if(sum>=10){cnt=1;}
            else{cnt=0;}
        }
        
        if (cnt > 0) {
            
            result.next=new ListNode(cnt);
            result=result.next;
        }
        
        return tt.next;
    }
}