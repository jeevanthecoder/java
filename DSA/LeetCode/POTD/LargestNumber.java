import java.util.Arrays;

public class LargestNumber {

    public static String largestNumber(int[] nums) {

        int sum=0;
        String[] arr = new String[nums.length];
        for(int i=0;i< nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
//        System.out.println(Arrays.toString(arr));
        StringBuilder str= new StringBuilder();
        for(int i=0;i<arr.length;i++){
            str.append(arr[i]);
        }
        
        return str.toString();

    }

    public static void main (String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println(largestNumber(arr));
        
    }
    
    
    
}
