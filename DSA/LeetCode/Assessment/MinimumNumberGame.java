import java.util.Arrays;

public class MinimumNumberGame {
    public static int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] res=new int[nums.length];
        int n=nums.length;
        int j=0;
        for(int i=1;i<n;i+=2){
            res[i]=nums[j++];
            res[i-1]=nums[j];
            j++;
        }
        return res;

    }
    public static void main (String[] args) {
        int[] num={5,4,2,3};
        System.out.println(Arrays.toString(numberGame(num)));
    }
}
