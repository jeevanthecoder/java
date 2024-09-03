import java.util.ArrayList;
import java.util.Collections;

public class ReverseSubArray {
    public static ArrayList<Integer> reverseSubArray(ArrayList<Integer> arr, int l,
                                                     int r) {
        // code here
        l=l-1;r=r-1;
        if(l<0 && r>=arr.size())return arr;
        ArrayList<Integer> res = new ArrayList<>();
        int ind=r-l,size= arr.size();
        if(ind==size && !arr.isEmpty()) {
            Collections.reverse(arr);
            return arr;
        }
        for(int i=l;i<=r;i++)
            res.add(arr.get(i));
        Collections.reverse(res);
        int i1=0;
        ArrayList<Integer> res1=new ArrayList<>();
        for(int i=0;i<size;i++) {


            if(i>=l && i<=r) {
                res1.add(i,res.get(i1));
                i1++;
            }else{
                res1.add(arr.get(i));
            }

        }

        return res1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(5);
        a.add(3);
        a.add(8);
        a.add(6);
        a.add(3);

        System.out.println("Original : "+a);

        System.out.println(reverseSubArray(a,2,4));
    }
}
