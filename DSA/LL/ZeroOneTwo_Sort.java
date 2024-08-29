public class ZeroOneTwo_Sort {

    /*
    Brute Force
    -> Values changing technique
     */
    public static DLL.Node sort(DLL.Node l1){
        if(l1==null || l1.next==null)return l1;
        int cnt0=0,cnt1=0,cnt2=0;
        DLL.Node dummy = l1;
        DLL.Node head = dummy;
        while(dummy!=null && dummy.next!=null){
            if(dummy.data==0)cnt0++;
            if(dummy.data==1)cnt1++;
            if(dummy.data==2)cnt2++;
dummy=dummy.next;
        }
        System.out.println("cnt0: "+cnt0+"\ncnt1: "+cnt1+"\ncnt2: "+cnt2+"Done");
        dummy=l1;


            while(cnt0!=0){
                l1.data=0;
                l1=l1.next;
                cnt0--;
            }
            while(cnt1!=0){
                l1.data=1;
                l1=l1.next;
                cnt1--;
            }while(cnt2!=0){
                l1.data=2;
                l1=l1.next;
                cnt2--;
            }

        return head;
    }
    /*
    TC -> O(2N)
    SC -> O(1)
     */

    /*
    Optimal Solution
    -> Cannot do "DATA REPLACEMENT"
    -> Have to do only 1 pass
     */

    public static DLL.Node sort_Optimal(DLL.Node l1){
        DLL.Node dummy=l1;
        DLL.Node zeros=new DLL.Node(5);
        DLL.Node head=zeros;
        DLL.Node ones=new DLL.Node(5),twos=new DLL.Node(5);
        DLL.Node zeroHead=zeros,oneHead=ones,twoHead=twos;
        while(dummy!=null && dummy.next!=null){
            if(dummy.data==0){
                DLL.Node newNode = new DLL.Node(0);
                zeros.next=newNode;
                zeros=newNode;

            }
            if(dummy.data==1){
                DLL.Node newNode = new DLL.Node(1);
                ones.next=newNode;
                ones=newNode;
            }
            if(dummy.data==2){
                DLL.Node newNode = new DLL.Node(2);
                twos.next=newNode;
                twos=newNode;
            }
            dummy=dummy.next;

        }
        head=zeroHead.next;
        zeros.next=oneHead.next;
        ones.next=twoHead.next;

        return head;

    }
    public static void main(String[] args) {

        int[] a2={0,1,0,2,1,1,0,2,0,2,0,1,1,2};
        DLL p = new DLL();
        System.out.println("a2 : \n");
        p.print(p.convertArr2DLL(a2));
        System.out.println("Result : ");
        p.print(sort_Optimal(p.convertArr2DLL(a2)));
    }
}
