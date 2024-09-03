import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKsortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode();
        ListNode res=head;

        if(lists==null)
            return head;
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            
            while(lists[i]!=null){
                
                arr.add(lists[i].val);
                lists[i]=lists[i].next;
            }

        }
        Collections.sort(arr);
        
        for(int i=0;i<arr.size();i++){
            ListNode temp1=new ListNode(arr.get(i));
            head.next=temp1;
            head=temp1;

        }

        return res.next;
    }
public static ListNode[] createLL(int[][] num){
        ListNode[] res = new ListNode[num.length];
        
        for(int i=0;i<num.length;i++){
            ListNode head=new ListNode();
            ListNode r1=head;
            for(int j=0;j<num[i].length;j++){
                
                ListNode temp=new ListNode(num[i][j]);
                head.next=temp;
                head=temp;
                
            }
//            print(r1.next);
//            System.out.println();
            res[i]=r1.next;
        }
       return res;
}
    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            if(temp.next==null)
                System.out.println(temp.val);
            else
            System.out.print(temp.val + " -> ");

            temp = temp.next;

        }
    }
    public static void main (String[] args) {
        int [][] list={
                {1,4,5},
                {3,4,6},
                {2}
        };
        ListNode head=new ListNode();
        print(mergeKLists(createLL(list)));
        
    }
    
}
