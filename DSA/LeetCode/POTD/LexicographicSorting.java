import java.util.*;

public class LexicographicSorting {
    public List<Integer> lexicalOrder(int n) {

        return new ArrayList<>();
    }
    public static void main (String[] args) {
//        int[] arr = {1,2,3,4,5,6,10,11,12,13};
        int n=13,ind=4;
        long k=1;
        List<Long> res = new ArrayList<>();
        for(int i=1;i<=n;i++){
            res.add(k);
            if(k*10 <= n)
                k*=10;
            else{
                while(k%10 == 9 || k>=n){
                    k/=10;
                }
                k++;
            }
        }
        int upper=-1,lower=-1;
        int[] res2 = new int[]{upper,lower};
        System.out.println(Integer.MAX_VALUE>Math.pow(10,9));
        System.out.println(res.get(ind-1));
        
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
//        ans.add(new ArrayList<>(){3});
    }
}
