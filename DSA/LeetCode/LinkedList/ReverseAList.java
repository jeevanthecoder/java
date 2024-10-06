import java.util.ArrayList;

public class ReverseAList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

        public ListNode reverseList(ListNode head) {
            ArrayList<Integer> List_values = new ArrayList<>();
            while(head!=null){
                List_values.add(head.val);
                head=head.next;
            }
            ListNode node1=new ListNode();
            ListNode node2=node1;
            for(int i=0;i<List_values.size();i++){
                node1.next=new ListNode(List_values.get(List_values.size()-i-1));
                node1=node1.next;
            }

            return node2.next;
        }

}
