public class RemoveNthNode {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {

          int count=0,flag=0;
          ListNode node1=head;
          ListNode node=head;
          if(head.next==null && n==1)return null;
          while(head.next!=null){
              node=head;
              count=n;
              while(count>=0){
                  if(node.next==null)flag=1;
                  node=node.next;
                  count--;
              }
              if(flag==1){
                  if(head.next.next==null)
                  head.next=null;
                  else
                      head.next=head.next.next;
                  break;
              }
              head=head.next;
          }
          return node1;

    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {

          ListNode node1=head;
        ListNode node2=head;
          int count=0,index=0;
          while(node1!=null){
              node1=node1.next;
              count++;
          }
        if(count==1 & n==1)return null;
        index=count-n;
        if(index==0){
            return head.next;
        }

        if(index==1 && count>=2){
            head.next=head.next.next;
              return node2;
          }
          for(int i=1;i<index;i++){
            head=head.next;
          }
          head.next=head.next.next;

          return node2;

    }


}
