import java.util.Arrays;

public class MissingObservations {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        
        int sum=0;
        for(int i=0;i<rolls.length;i++){
            sum+=rolls[i];
        }
        int val=mean*(rolls.length+n)-sum;
        
        int[] a=new int[n];
        int prev=0,it=0;
        for(int i=0;i<a.length;){
            val-=prev;
            int r=val/n;
            
//            System.out.println(r+" "+val+"/"+n);
            if(r<=6 && r>=1){
                a[i]=r;
                prev=r;
                it++;
            }
            n--;
            i++;
                
        }
        System.out.println(it);
        
        if(it==a.length)
        return a;
        else {
            int[] num=new int[]{};
            return num;
        }
    }

    public static void main (String[] args) {
        int[] a={3,5,3};
        System.out.println(Arrays.toString(missingRolls(a,5,3)));
    }
}
