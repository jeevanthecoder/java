import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ZIGZAGPRECTICE {
    public static String convert(String s, int numRows) {

        int n=0,flag=0;
        if(numRows==1)
            return s;
        
        List<Character>[] lists= new List[numRows];
        for(int i=0;i<numRows;i++)
            lists[i]=new ArrayList<>();
        
        for(char c:s.toCharArray()){
            lists[n].add(c);
            if(n==0)flag=0;
            if(n==numRows-1)flag=1;
            if(flag==0)n++;
            else if(flag==1)n--;
        }
        StringBuilder str= new StringBuilder();
        for(int i=0;i< lists.length;i++){
            for(char c:lists[i]){
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main (String[] args) {
        System.out.println(convert("PAYPALISHIRIN",3));
    }
    
}
