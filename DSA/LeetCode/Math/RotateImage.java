import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] arr){
        int m=arr.length,n=arr[0].length;
        int[][] temp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[j][n-i-1]=arr[i][j];
            }

        }

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                arr[i][j]=temp[i][j];

    }
public static void print(int[][] a){
        int m=a.length,n=a[0].length;
    System.out.print("[");
        for(int i=0;i<m;i++){

            if(i+1==m)
                System.out.print(Arrays.toString(a[i])+"]");
            else
                System.out.print(Arrays.toString(a[i])+" , ");
        }
}
    public static void main(String[] args) {
        int[][] a={
                {5,3,2,1},
                {11,6,4,5},
                {15,8,9,10},
                {14,12,13,16}
        };
        System.out.println("Original : \n");
        print(a);
        System.out.println("Solution : \n");
        rotate(a);
    }
}
