import java.util.*;

public class RemoveNodes {
    static DLL p1 = new DLL();
    
    public static DLL.Node modifiedList(int[] nums, DLL.Node head) {
        int flag=0;
        ArrayList<Integer> a = new ArrayList<>();
        for(int i:nums){
            a.add(i);
        }
        DLL.Node res=head;
        DLL.Node temp=res;
        DLL.Node prev=res;
        int pr=1;
        while(res!=null){
            p1.print(temp);
            System.out.println("Condition 1 : "+res.data);
            if(a.contains(res.data)) {
                
                if(pr>=1) {
                    pr++;
                    System.out.println("pr : "+pr);
                    System.out.println("Inside 1 with data : "+res.data);
                    res = res.next;
                    temp = temp.next;
                    
                }else{
                    pr=0;
                    System.out.println("pr : "+pr);
                    System.out.println("Inside 2 with data : "+res.data);
                    prev.next=res.next;
                    res=prev.next;
                }
            }
            else if(res.next!=null && a.contains(res.next.data)){

                System.out.println("Inside 3 with data : "+res.next.data);
                pr=0;
                System.out.println("pr : "+pr);
                System.out.println("res : "+res.data);
                System.out.println("res.next.next : "+res.next.next.data);
                res.next=res.next.next;
                prev=res;
                res=res.next;
            }else {

//                System.out.println("Inside 1 with data : "+res.data);
                pr=0;
                System.out.println("pr : "+pr);
                prev=res;
                res = res.next;
            }

        }
        return temp;
    }

    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> a = new HashSet<>();
        for(int i:nums){
            a.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(head!=null){
            if(!a.contains(head.val))res.add(head.val);
            head=head.next;
        }
        ListNode temp=new ListNode();
        ListNode resNode=temp;
        for(int i=0;i<res.size();i++){
            ListNode t=new ListNode(res.get(i));
            resNode.next=t;
            resNode=resNode.next;
        }
        return temp.next;
    }
    public static ListNode modifiedList1(int[] nums, ListNode head) {
        int flag=0;
        Set<Integer> a = new HashSet<>();
        for(int i:nums){
            a.add(i);
        }
        ListNode res=head;
        ListNode temp=res;
        ListNode prev=res;
        int pr=1;
        while(res!=null){
            if(a.contains(res.val)) {

                if(pr>=1) {
                    pr++;
                    res = res.next;
                    temp = temp.next;

                }else{
                    pr=0;
                    prev.next=res.next;
                    res=prev.next;
                }
            }
            else if(res.next!=null && a.contains(res.next.val)){

                pr=0;
                res.next=res.next.next;
                prev=res;
                res=res.next;
            }else {

                pr=0;
                prev=res;
                res = res.next;
            }

        }
        return temp;
    }
    public static void main (String[] args) {
        int[] nums = {1,2,3};
        int[] head = {1,2,3,5,1,4};
        DLL p = new DLL();
        DLL.Node head1 = p.convertArr2DLL(head);
        p.print(modifiedList(nums,head1));

        System.out.println(Integer.MAX_VALUE);
        
        
//        System.out.println(a.contains(41));
    }
    

}
