import java.util.Random;

public class MergeSortedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null)return null;

            ListNode node1=new ListNode();
            ListNode node2=node1;
            if(list1==null)return list2;

            else if(list1!=null && list2!=null) {

                while(list1!=null && list2!=null) {
                    while (list2 != null && list1 != null && list1.val <= list2.val) {
                        node1.next = new ListNode(list1.val);
                        node1 = node1.next;
                        list1 = list1.next;
                    }
                    while (list2 != null && list1 != null && list2.val <= list1.val) {
                        node1.next = new ListNode(list2.val);
                        node1 = node1.next;
                        list2 = list2.next;
                    }
                }

                    while (list1 != null) {
                        node1.next = new ListNode(list1.val);
                        node1 = node1.next;
                        list1 = list1.next;
                    }

                    while (list2 != null) {
                        node1.next = new ListNode(list2.val);
                        node1 = node1.next;
                        list2 = list2.next;
                    }


            }else return list1;

            return node2.next;
        }

    public static void main(String[] args) {
        ListNode node1=new ListNode(0);
        ListNode node2=new ListNode(0);

        ListNode n1=node1;
        ListNode n2=node2;
        for(int i=1;i<9;i++){
            node1.next=new ListNode(i);
//            System.out.println(node1.next.val);
            node1=node1.next;
        }
        System.out.println("\n\nNode 2 \n\n ");
        for(int i=2;i<15;i++){
            node2.next=new ListNode(i*3);

            node2=node2.next;
//            System.out.println(node2.val);
        }
        ListNode n11=n1;
        ListNode n22=n2;
        while(n11!=null){
            System.out.print(n11.val+" ");
            n11=n11.next;
        }

        System.out.println();

        while(n22!=null){
            System.out.print(n22.val+" ");
            n22=n22.next;
        }

        ListNode result=mergeTwoLists(n1,n2);

        System.out.println("\nResult : ");
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }

    }

}
