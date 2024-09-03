import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int size=candies.length,max=0;
        List<Boolean> freq = new ArrayList<>();
        for(int i=0;i<size;i++){
            if(candies[i]>max)
                max=candies[i];
        }
        for(int i=0;i<size;i++){
            if(candies[i]+extraCandies >max)
                freq.add(true);
            else 
                freq.add(false);
        }
        return freq;
    }
    public static void main (String[] args) {
        
    }
}
