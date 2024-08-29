/*
    Input Format:
(Pointer/Access to the head of the two linked lists)

num1  = 243, num2 = 564

l1 = [2,4,3]
l2 = [5,6,4]

Result: sum = 807; L = [7,0,8]

Explanation: Since the digits are stored in reverse order, reverse the numbers first to get the or
original number and then add them as → 342 + 465 = 807. Refer to the image below.
     */

public class AddTwoNumbers {
    public static DLL.Node AddTwoNum(DLL.Node l1,DLL.Node l2){
        DLL.Node dummy=new DLL.Node(0);
        DLL.Node cur=dummy;
        int sum=0;
        while(l1!=null || l2!=null){

            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2=l2.next;
            }

            DLL.Node newNode = new DLL.Node(sum%10);
            cur.next=newNode;
            cur=newNode;

            // Carry gets remained in 'sum'
            sum/=10;


        }
        if(sum!=0){
            DLL.Node newNode = new DLL.Node(sum);
            cur.next=newNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] a1={3,5};
        int[] a2={4,5,9,9};
        DLL p = new DLL();
        System.out.println("a1 : \n");
        p.print(p.convertArr2DLL(a1));
        System.out.println("a2 : \n");
        p.print(p.convertArr2DLL(a2));
        System.out.println("Result : ");
        p.print(AddTwoNum(p.convertArr2DLL(a1),p.convertArr2DLL(a2)));
    }
}
