import java.util.ArrayList;
/*
Here Odd index elements should be grouped 1st and then Even indexed elements
 */

public class OddEvenLL {
    public static DLL.Node oddEvenLL(DLL.Node l1){
        ArrayList<Integer> arr= new ArrayList<>();
        DLL.Node dummy=l1;
        if(l1==null)return l1;
        while(dummy!=null && dummy.next!=null){
            arr.add(dummy.data);
            dummy=dummy.next.next;
        }
        dummy=l1.next;
        while(dummy!=null && dummy.next!=null){
            arr.add(dummy.data);
            dummy=dummy.next.next;
        }
        dummy=l1;
        for(int i=0;i<arr.size();i++){
            if(l1.next==null)break;
            l1.data=arr.get(i);
            l1=l1.next;
        }
        return dummy;

    }
/*
    TC -> O(2N)
    SC -> O(N)
 */

    // Optimal

    public static DLL.Node oddEven_Optimal(DLL.Node l1){

        if(l1==null || l1.next==null)return l1;

        DLL.Node Odd = l1;
        DLL.Node Even = l1.next;
        DLL.Node EvenHead = l1.next;

        while(Even!=null && Even.next!=null){
            Odd.next=Odd.next.next;
            Even.next=Even.next.next;

            Odd=Odd.next;
            Even=Even.next;
        }
        Odd.next=EvenHead;
        return l1;
    }

    /*
    TC -> O(N)
    SC -> O(1)
     */
    public static void main(String[] args) {

        int[] a2={4,5,9,9,4,6};
        DLL p = new DLL();
        System.out.println("a2 : \n");
        p.print(p.convertArr2DLL(a2));
        System.out.println("Result : ");
        p.print(oddEven_Optimal(p.convertArr2DLL(a2)));
    }
}
