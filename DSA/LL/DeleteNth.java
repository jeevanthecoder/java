public class DeleteNth {
    public static DLL.Node removeKthNode(DLL.Node head, int K)
    {
        // Write your code here.
        if(head==null || K==0)return head;

        DLL.Node temp = head;
        DLL.Node res=temp;
        int cnt=0;
        while(temp!=null){
            cnt++;
//            System.out.println(cnt+"->"+temp.data);
            temp=temp.next;
        }
        int cnt1=Math.abs(K-cnt);
//        System.out.println("\n"+cnt+" "+cnt1+"\n");
        temp=head;

        if(K==cnt)return head.next;

        while(cnt1!=1 && temp!=null){

//            System.out.println(cnt1+"->"+temp.data);
            temp=temp.next;
            cnt1--;
        }
        if(cnt1==1){
            temp.next=temp.next.next;
        }
        return res;
    }

    /* Optimal
    -> Using Two pointer approach
    */
    public static DLL.Node removeKthNodeOptimal(DLL.Node head,int k){

        DLL.Node fast=head,slow=head;
        for(int i=0;i<k;i++)fast=fast.next;
        if(fast==null)return head.next;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return head;

    }
    public static void main(String[] args) {
        int[] a={4,3,5,6,7,8};
        DLL p = new DLL();
        p.print(removeKthNodeOptimal(p.convertArr2DLL(a),3));
    }
}
