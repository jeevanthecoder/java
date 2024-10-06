import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        while(temp!=null){
            set.add(temp.val);
            temp=temp.next;
        }

        ListNode res=new ListNode();
        ListNode result=res;
        for(int i:set){
            ListNode t1=new ListNode(i);
            res.next=t1;
            res=res.next;
        }
        return result.next;

    }
}
