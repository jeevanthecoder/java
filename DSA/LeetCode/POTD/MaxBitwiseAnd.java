import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxBitwiseAnd {

    public static int longestSubarray(int[] nums) {
        int maxVal=Integer.MIN_VALUE,maxBin=Integer.MIN_VALUE;

        int max=0,prev=0,res=1,val=0;
        for(int i=0;i< nums.length;i++){
            System.out.println(val);
            if(i==0)val=nums[i];
            if(maxVal<nums[i])maxVal=nums[i];
            if(maxBin<val){
                maxBin=val;
                System.out.println("MaxBin : "+maxBin);
            }
            if(prev==nums[i] && maxVal==nums[i]){
                res++;
                System.out.println("prev : "+prev+" ,res : "+res);
                val=val&nums[i];
            }
            else{
                System.out.println("Inside else");
                if(nums[i]>maxBin)
                {
                    val = nums[i];
                    res = 1;
                }else continue;
            }

//            if(max<res)max=res;

            prev=nums[i];
        }
        return res;
    }

    public static int longestSubarray1(int[] nums) {
        int maxVal=Integer.MIN_VALUE;

        int max=0,prev=0,res=0,val=0,flag=0,maxBin=Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            if(maxVal<nums[i])maxVal=nums[i];
            if(maxBin<val)maxBin=val;
            if(prev==nums[i] && maxVal==nums[i]){
                res++;
                
                if(i==0)val=nums[i];
                else val&=nums[i];
            }
            else{
                if(max<res && val==maxVal){
                    max=res;
                }
                val=nums[i];
                res=1;
            }


            prev=nums[i];
        }
        if(max==0)return res;
        if(nums[nums.length-1]>maxBin)return 1;
        return max;
    }

    public static void main (String[] args) {
//        int[] a={395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,153490,330001,330001,330001,330001,330001,330001,330001,37284,470030,470030,470030,470030,470030,470030,156542,226743};
        int[] a={378034,378034,378034};
        System.out.println(longestSubarray1(a));
        
    }
}
