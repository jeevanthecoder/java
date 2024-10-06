import java.util.*;

public class CountConsistentStrings {
    public static int countConsistentStrings(String allowed, String[] words) {
        int res=0,cnt=0,flag=0,neg=0;
        for(int i=0;i< words.length;i++){
            cnt=0;neg=0;

            System.out.println("Inside loop : "+words[i]);
            for(int k=0;k<words[i].length();k++){
                for(int j=0;j<allowed.length();j++) {
                    if (String.valueOf(allowed.charAt(j)).contains(String.valueOf(words[i].charAt(k)))) {
                        System.out.println(i);
                        cnt++;flag=1;
                        break;
                    }else{
                        flag=0;neg++;
                    }
                }
                if(flag==0)break;
            }
            System.out.println(i+" cnt : "+cnt);
            System.out.println("neg : "+neg);
            if((cnt<= allowed.length() || cnt>=allowed.length()) && cnt>0 && neg==0){

                System.out.println(words[i]+" = "+allowed);
                res++;
            }

        }

        return res;
    }
    public static int countConsistentStrings2(String allowed, String[] words) {
        int res=0,cnt=0;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<allowed.length();i++){
            int k=allowed.charAt(i)-'a';
            arr.add(k);
        }
        System.out.println(arr);
        for(int i=0;i<words.length;i++){
            cnt=0;
            for(int j=0;j<words[i].length();j++){
                if(arr.contains(words[i].charAt(j)-'a'))cnt++;
                else cnt--;
            }
            if(cnt>=words[i].length())res++;
        }
        return res;
    }
    public static int countConsistentStrings1(String allowed, String[] words) {
     
        int[] res=new int[words.length];
        int sum=0,result=0;
        for(int i=0;i< words.length;i++){
            for(int j=0;j<words[i].length();j++){
                int val=words[i].charAt(j)-'a';
                sum+=val;
                
            }
            res[i]=sum;
        }
        sum=0;
        for(int i=0;i<allowed.length();i++){
            sum+=allowed.charAt(i)-'a';
        }
        for(int i=0;i<res.length;i++){
            if(sum==res[i])result++;
        }
        
        return result;
        
    }

    public static void main (String[] args) {
        String[] res = {"cc","acd","b","ba","bac","bad","ac","d"};
        Set<Integer> set = new HashSet<>();
//        ListNode temp = head;
//        while(temp!=null){
//            set.add(temp.val);
//            temp=temp.next;
//        }
set.add(-3);set.add(-1);set.add(0);set.add(0);set.add(0);set.add(3);set.add(3);

        ArrayList<Integer> ls = new ArrayList<Integer>(set);
        Collections.sort(ls);
        System.out.println(ls);
        ListNode res1=new ListNode();
        ListNode result=res1;
        for(int i:ls){
            System.out.println(i);
            ListNode t1=new ListNode(i);
            res1.next=t1;
            res1=res1.next;
        }
//        System.out.println("Result : "+countConsistentStrings2("cad",res));
//        System.out.println("abc".contains("bca"));
    }
}
