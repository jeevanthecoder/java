import java.util.ArrayList;
import java.util.Arrays;

public class Series {
    
    public static void series(int n){
        
        int i=0,j=1;
        //n+=1;
        int[] arr = new int[n];
int k=0;       
        while(j<n){
       if(i==1 || i==2)
           k=i;
       else
            k=arr[i];
            while(k>0 && j<n){
                arr[j]=i;
                k--;
                j++;
            }
            i++;
        }
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void main (String[] args) {
//        series(30);

        int size=45;
        int arr[]= new int[size];
        arr[0]=1;
        int pn=2;

        int start=1;
        int end=start+2;

        while(end<=size && pn<size)
        {
            

            for(;start<end;start++){
                arr[start]=pn;
            }
            pn++;
            end=start+arr[pn-1];
		    /*System.out.println(start);
		    System.out.println(end);
		    for(;start<end;start++)
		    arr[start]=pn;*/

            if(end>size){
                end=size;
            }
//            System.out.println("start : "+start+" end : "+end);
        }
        /*--------------------------------------------------*/
        for(int i=0;i<size;i++)
            System.out.print(arr[i]+" ");


    }
}
