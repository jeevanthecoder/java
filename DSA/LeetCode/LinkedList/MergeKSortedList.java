public class MergeKSortedList {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode mergeKLists(ListNode[] lists) {

          int i=0;

        ListNode node1=new ListNode();
        ListNode node2=node1;

          while(i< lists.length-1 && (i+1)<lists.length){
              ListNode list1=lists[i];
              ListNode list2=lists[i+1];

              if(list1==null && list2==null)return null;

              if(list1==null)return list2;

              else if(list1!=null && list2!=null) {

                  while(list1!=null && list2!=null) {
                      while (list2 != null && list1 != null && list1.val <= list2.val) {
//                          System.out.println("loop 1 :" + list1.val);
                          node1.next = new ListNode(list1.val);
                          node1 = node1.next;
                          list1 = list1.next;
                      }
                      while (list2 != null && list1 != null && list2.val <= list1.val) {
//                          System.out.println("loop 2 :" + list2.val);
                          node1.next = new ListNode(list2.val);
                          node1 = node1.next;
                          list2 = list2.next;
                      }
                  }

                  while (list1 != null) {
//                      System.out.println("loop 3: " + list1.val);
                      node1.next = new ListNode(list1.val);
                      node1 = node1.next;
                      list1 = list1.next;
                  }

                  while (list2 != null) {
//                      System.out.println("loop 4" + list2.val);
                      node1.next = new ListNode(list2.val);
                      node1 = node1.next;
                      list2 = list2.next;
                  }


              }else return list1;

i++;
          }
        if(lists.length%2==1){
            ListNode list2=lists[lists.length-1];
            while(node1!=null && list2!=null) {
                while (list2 != null && node1 != null && list2.val <= node1.val) {
                    node1.next = new ListNode(list2.val);
                    node1 = node1.next;
                    list2 = list2.next;
                }
            }
            while (list2 != null) {
//                System.out.println("loop 4" + list2.val);
                node1.next = new ListNode(list2.val);
                node1 = node1.next;
                list2 = list2.next;
            }


        }

        return node2.next;
    }
}
