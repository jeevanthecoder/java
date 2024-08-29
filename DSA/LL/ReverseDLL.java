import java.util.Stack;

public class ReverseDLL {
    static class Node{
        int data;
        Node next,back;
        Node(int data, Node next, Node back){
            this.data=data;
            this.next=next;
            this.back=back;

        }
        Node(int data){
            this.data=data;
            this.next=null;
            this.back=null;
        }
    }

    static DLL p = new DLL();
    //Brute Force
    // Using Stacks

    static Stack stack = new Stack<>();

    public static DLL.Node ReverseDLL1(DLL.Node head){
        DLL.Node temp=head;
        while(temp!=null){
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            temp.data= (int) stack.pop();
            temp=temp.next;
        }
        return head;
    }

    /* TC -> O(2N)
       SC -> O(N) This is because we are using an external stack data structure.

     */

    // optimal
   public static DLL.Node ReverseDLL_O(DLL.Node head){
       DLL.Node temp=head;

       DLL.Node prev=null;
       while(temp!=null){
           prev=temp.back;
           temp.back=temp.next;
           temp.next=prev;

           temp=temp.back;
       }
       return prev.back;
   }
    public static void main(String[] args) {
        int[] a={1,2,4,5};
        DLL.Node a1=p.convertArr2DLL(a);
        System.out.println("Brute Force : \n");
        p.print(ReverseDLL1(a1));
        System.out.println("Optimal : \n");

        p.print(ReverseDLL_O(a1));
    }

}
