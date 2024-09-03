import java.util.*;


public class PermutationOfNums {

    public static void recuPermute(List<Character> ds,List<List<Character>> ans,boolean[] freq,char[] num,int k){

        if(ans.size()>=k)
            return;
            
       if(ds.size()==num.length){
           ans.add(new ArrayList<>(ds));
       }else{
           for (int i=0;i<num.length;i++){
               if(!freq[i]){
                   freq[i]=true;
                   ds.add(num[i]);
                   recuPermute(ds, ans, freq, num,k);
                   ds.remove(ds.size()-1);
                   freq[i]=false;
                   
               }
           }
       }
       

    }

    public static String getPermutation(int n, int k) {
        List<List<Character>> ans = new ArrayList<>();
        List<Character> ds = new ArrayList<>();
        boolean[] freq=new boolean[n];
        char[] num=numToChar(n);
        recuPermute(ds,ans,freq,num,k);
        String res="";
        for(Character s:ans.get(k-1)){
            res+=s;
        }
        return res;
    }
    public static char[] numToChar(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=(sum*10)+i;
        }
        String str=String.valueOf(sum);
        return str.toCharArray();
    }


    public static void main(String[] args) {

        String str="123";
        System.out.println(Arrays.toString(numToChar(3)));
//        System.out.println("Result : ");
        System.out.println(getPermutation(3,5));
//        System.out.println("Result : "+getPermutation(3,5));

    }
}
