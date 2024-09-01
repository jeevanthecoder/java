
public class DLL {
    static class Node{
        int data;
        Node next,back;
        Node(int data,Node next,Node back){
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

    public void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
//            if(temp.next.next==null){
//                System.out.print(temp.next.data+" -> ");
//                temp=temp.next;
//                break;
//            }
            temp=temp.next;

        }
        System.out.print("null\nReverse:");

        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.back;

        }
        System.out.print("null\n");

    }
    public Node convertArr2DLL(int[] a){

        Node temp=new Node(a[0]);
        Node head=temp;
        for(int i=1;i<a.length;i++){
            Node newNode=new Node(a[i],null,temp);
            temp.next=newNode;
            temp=newNode;
        }
        return head;
    }
}
