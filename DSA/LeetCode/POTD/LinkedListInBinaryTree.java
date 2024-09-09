public class LinkedListInBinaryTree {
    
    // Most Optimal

    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head,head,root);
    }
    public boolean dfs(ListNode head,ListNode cur,TreeNode root){
        if(cur==null)
            return true;
        if(root==null)
            return false;

        if(cur.val==root.val){
            cur=cur.next;
        }else if(head.val==root.val){
            head=head.next;
        }else
            cur=head;

        return dfs(head,cur,root.left)||dfs(head,cur,root.right);
    }
    
    public static boolean isSubPath1(ListNode head, TreeNode root) {
        int len=0;
        int[] cnt=new int[1];
        ListNode temp = head;
        ListNode res = temp;
        while(res!=null){
            len++;
            res=res.next;
        }
        char dir='-';
        recur(head,root,cnt,temp,root,dir,len);
        System.out.println("len : "+len);
        System.out.println("cnt : "+cnt[0]);
        if(cnt[0]==len)
            return true;
        
        return false;

    }
    public static void recur(ListNode head,TreeNode root,int[] cnt,ListNode temp,TreeNode rootTemp,char dir,int len){
        if(root==null || head==null)return;
        System.out.println("root.val : "+root.val+" head.val : "+head.val);
        if(head!=null){
            if(root.val==head.val){

                cnt[0]++;
                if(cnt[0]==len)return;
                if(root.left!=null && head.next!=null && root.left.val==head.next.val){
                    if(dir=='-')dir='l';
                    System.out.println(root.val+" cnt : "+cnt[0]);
                    recur(head.next, root.left,cnt,temp,rootTemp,dir,len);
                }else if(root.right!=null && head.next!=null && root.right.val==head.next.val){
                    if(dir=='-')dir='r';
                    System.out.println(root.val+" cnt : "+cnt[0]);
                    recur(head.next,root.right,cnt,temp,rootTemp,dir,len);
                }else if(rootTemp.val== head.val){
                    System.out.println("Inside cond 1 else");
                    if(dir=='l'){

                        head=temp;root=rootTemp;
                        dir='-';cnt[0]=0;
                        if(root.val==head.val) {
                            cnt[0]++;
                            recur(head.next, root.right, cnt, temp, rootTemp, dir,len);
                        }
                        else 
                            recur(head,root,cnt,temp,rootTemp,dir,len);
                    }
                }
                

            }else if(cnt[0]>0 && root.val!=head.val){
            }
            else{

                System.out.println("Inside else");
                System.out.println(root.val);
                recur(head.next,root.left,cnt,temp,rootTemp,dir,len);
                head=temp;
                root=rootTemp;
                recur(head.next,root.right,cnt,temp,rootTemp,dir,len);
            }

        }
    }
    

    public static void main (String[] args) {
        TreeNode root5= new TreeNode(3);
        TreeNode root3= new TreeNode(1);
        TreeNode root4= new TreeNode(8,root3,root5);        
        TreeNode root1= new TreeNode(6);
        TreeNode root7= new TreeNode(2,root1,root4);
        TreeNode root2= new TreeNode(4,root7,null);

        TreeNode root8= new TreeNode(1);
        TreeNode root66= new TreeNode(2,root8,null);
        TreeNode root61= new TreeNode(4,null,root66);

        TreeNode root= new TreeNode(1,root61,root2);

        ListNode l1=new ListNode(8);
        ListNode l2=new ListNode(2,l1);
        ListNode l=new ListNode(4,l2);




//
//        TreeNode root3= new TreeNode(4);
//        TreeNode root4= new TreeNode(3);
//        TreeNode root1= new TreeNode(6,root4,root3);
//        TreeNode root7= new TreeNode(2);
//        TreeNode root2= new TreeNode(1);
//
//        TreeNode root8= new TreeNode(1,root2,root7);
//
//        TreeNode root= new TreeNode(1,root8,root1);
//
//        ListNode l1=new ListNode(1);
//        ListNode l2=new ListNode(1,l1);
//        ListNode l=new ListNode(1,l2);

//        TreeNode root3= new TreeNode(1);
//        TreeNode root4= new TreeNode(3);
//        TreeNode root1= new TreeNode(8,root3,root4);
//        TreeNode root7= new TreeNode(6);
//        TreeNode root2= new TreeNode(2,root7,root1);
//        TreeNode root71= new TreeNode(4,root2,null);
//        
//        TreeNode root72= new TreeNode(1);
//        TreeNode root73= new TreeNode(2,root72,null);
//        TreeNode root74= new TreeNode(4,null,root73);
//
//        TreeNode root= new TreeNode(1,root74,root71);
//
//        ListNode l1=new ListNode(6);
//        ListNode l2=new ListNode(2,l1);
//        ListNode l3=new ListNode(4,l2);
//        ListNode l=new ListNode(1,l3);
        
        System.out.println(isSubPath1(l,root));
        


    }
}
