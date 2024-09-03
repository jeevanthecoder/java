import java.util.HashMap;
import java.util.Map;

public class RepeatedDigit {
    // Most optimal
    public static int digit1(int arr[]){
        int[] freq=new int[10];
        for(int i=0;i<arr.length;i++){
            while(arr[i]>0){
                freq[arr[i]%10]++;
                arr[i]/=10;
            }
        }
        int max=0,res=0;
        for(int i=0;i< freq.length;i++){
            if(max<freq[i]){
                max=freq[i];
                res=i;
            }
        }
        return res;
    }

    public static int digit(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            while(num>0) {
                int n=num%10;
                if (!map.containsKey(n))
                    map.put(n, 1);
                else
                    map.put(n, map.get(n) + 1);
                num/=10;
            }
        }
        int max=0,res=0;
        for(Map.Entry<Integer,Integer> entrySet:map.entrySet()){
            if(max< entrySet.getValue()){
                max= entrySet.getValue();
                res= entrySet.getKey();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a={45,12,45,8,9,45,3,4};
        System.out.println(digit1(a));
    }
}
