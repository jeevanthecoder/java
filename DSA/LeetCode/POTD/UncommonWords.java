import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UncommonWords {
    public static String[] uncommonFromSentences(String s1, String s2) {
        
            Map<String,Integer> map = new HashMap<>();
            String[] arr1=s1.split(" ");
            String[] arr2=s2.split(" ");
            
            for(int i=0;i<arr1.length;i++){
                if(!map.containsKey(arr1[i]))
                    map.put(arr1[i],1);
                else 
                    map.put(arr1[i],map.get(arr1[i])+1);
            }
            for(int i=0;i<arr2.length;i++){
                if(!map.containsKey(arr1[i]))
                    map.put(arr1[i],1);
                else
                    map.put(arr1[i],map.get(arr1[i])+1);
            }
            StringBuilder str = new StringBuilder();int k=0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue()==1){
                    str.append(entry.getValue().toString()+" ");
                    k++;
                }
            }
            String[] res= str.toString().split(" ");
            
        if(k==0){
            String[] res1=new String[]{};
            return res1;
        }
        System.out.println(Arrays.toString(res));
            return res;

    }

    public static void main (String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("fd kss fd","fd fd kss")));
    }
    
}
