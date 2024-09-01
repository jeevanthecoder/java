import java.util.Stack;

public class ReverseLL {
    public static DLL.Node reverseI(DLL.Node head){

        Stack s = new Stack();
        DLL.Node temp=head;
        while(temp!=null){
            s.push(temp.data);
            temp=temp.next;
        }
        DLL.Node res=new DLL.Node(0);
        DLL.Node res1=res;

        while (true) {

            try {
                DLL.Node newNode = new DLL.Node((Integer) s.pop());
                res.next = newNode;
                res = newNode;
            } catch (Exception e) {
                break;
            }
        }
        return res1.next;
    }

    //Optimal
    public static DLL.Node reverseII(DLL.Node head){
        DLL.Node prev=null;
        DLL.Node current=head;
        while(current!=null){
            DLL.Node temp=current.next;
            current.next=prev;

            //Iteration
            prev=current;
            current=temp;


        }
        return prev;
    }

    //Optimal II

    public static DLL.Node reverseIII(DLL.Node head){
        if(head==null || head.next==null)return head;

        DLL.Node newHead= reverseIII(head.next);

        DLL.Node front=head.next;

        front.next=head;

        head.next=null;

        return newHead;


    }
    public static void main(String[] args) {
        int[] a={4,3,5,6,7,8};
        DLL p = new DLL();
        p.print(reverseII(p.convertArr2DLL(a)));
    }
}
