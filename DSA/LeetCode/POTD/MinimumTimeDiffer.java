import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDiffer {

    public static int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> arr = new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i< timePoints.size()-1;i++){
            String s = timePoints.get(i);
            String s1 = timePoints.get(i+1);
            int j=0,sum=0,flag=0;
            System.out.println(s.charAt(0)+s.charAt(1)+s.charAt(3)+s.charAt(4));
            int hr1=Integer.valueOf(s.charAt(0));
            int hr2=Integer.valueOf(s.charAt(1));
            int min1=Integer.valueOf(s.charAt(3));
            int min2=Integer.valueOf(s.charAt(4));
            System.out.println(hr1+hr2+min1+min2);
            hr2=(hr2*10)+hr1;
            min2=(min2*10)+min1;


            int hr11=(s1.charAt(0)-48);
            int hr21=(s1.charAt(1)-48);
            int min11=(s1.charAt(3)-48);
            int min21=(s1.charAt(4)-48);
            hr21=(hr21*10)+hr11;
            min21=(min21*10)+min11;

            System.out.println("Hour1 : "+hr2+", Min1 :"+min2);
            Duration duration = Duration.between(LocalTime.of(hr2,min2,00),LocalTime.of(hr21,min21,00));

            if(duration.toMinutes()<min)min= (int) duration.toMinutes();
        }
//        Collections.sort(arr);
//        int min=Integer.MAX_VALUE;
//        for(int i=0;i<arr.size()-1;i++){
//            System.out.println("i+1 : "+arr.get(i+1)+" , i : "+arr.get(i));
//            int val=arr.get(i+1)-arr.get(i);
//            
//            if(val<min)min=val;
//        }

        return min;
    }

    public static int findMinDifference1(List<String> timePoints) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i< timePoints.size();i++){
            String s = timePoints.get(i);
            int j=0,sum=0;
            while(j<s.length()){
                if(s.charAt(j)!=':'){
                    
                    System.out.print((Integer.valueOf(s.charAt(j))-48));
                    sum=sum*10+((Integer.valueOf(s.charAt(j))-48));
                }
                j++;
            }
            
            System.out.println();
            if(sum==0000)
                arr.add(2400);
            else
            arr.add(sum);
        }
        Collections.sort(arr);
        int min=Integer.MAX_VALUE,hr1=0;
        for(int i=0;i<arr.size()-1;i++){
            System.out.println(arr.get(i)+" "+arr.get(i+1));
            if(arr.get(i+1)/100 == 00)
                hr1=24;
            hr1=arr.get(i+1)/100;
            Duration duration = Duration.between(LocalTime.of(hr1,arr.get(i+1)%100,00),LocalTime.of(arr.get(i)/100,arr.get(i)%100,00));    
            int val= (int) duration.toMinutes();
            
            val=Math.abs(val);
            System.out.println("val : "+val);
            if(val==1439)val=1;
            if(val<min)min=val;
        }
//        if(arr.get(0)==0000){
//            Duration duration = Duration.between(LocalTime.of(arr.get(arr.size()-1)/100,arr.get(arr.size()-1)%100,00),LocalTime.of(00,00,00));
//            int val= (int) duration.toMinutes();
//            if(val<min)min=val;
//        }

        return min;
    }

    public static void main (String[] args) {
        String[] arr = {};
        List<String> a = new ArrayList<>();
//        a.add("01:01");
//        a.add("01:39");
        a.add("22:00");
        a.add("00:00");
//        System.out.println(22%100);
        System.out.println(findMinDifference3(a));
    }

    public static int findMinDifference2(List<String> timePoints) {
        int f1=0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i< timePoints.size();i++){
            String s = timePoints.get(i);
            int j=0,sum=0,sum1=0,flag=0;
            while(j<s.length()){
                if(s.charAt(j)==':')flag=1;
                if(s.charAt(j)!=':'){
                    if(f1==1){
                        sum1=sum1*10+((Integer.valueOf(s.charAt(j))-48));
                    }
                    sum=sum*10+((Integer.valueOf(s.charAt(j))-48));
                }
                if(flag==1 && sum==0){
                    f1=1;
                    sum=24;
                    flag=0;
                }
                j++;
            }

            if(f1==1){
                arr.add(sum1);f1=0;
            }
            arr.add(sum);
        }
        Collections.sort(arr);
        int i=0,res=Integer.MAX_VALUE;
        while(i< arr.size()-1){
            int hr=0;

            hr=arr.get(i)/100- arr.get(i+1)/100;
            int min=arr.get(i)%100- arr.get(i+1)%100;

            int val=(hr*60)+min;
            val=Math.abs(val);
            if(res>val)res=val;
            i++;
        }

        return res;
    }

    public static int findMinDifference3(List<String> timePoints) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<timePoints.size();i++){
            String[] time=timePoints.get(i).split(":");
            int hr=Integer.valueOf(time[0])*60;
            int min=Integer.valueOf(time[1]);
            
            arr.add(hr+min);
        }
        Collections.sort(arr);
        System.out.println(arr);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.size()-1;i++){
            int dif1=arr.get(i)- arr.get(i+1);
            
            dif1=Math.abs(dif1);
            System.out.println("dif1 : "+dif1);
            if(dif1<min)min=dif1;
        }
        int val= (24*60)-arr.get(arr.size()-1)+ arr.get(0);
        val=Math.abs(val);
        if(val<min)min=val;
        
        return min;
    }    
}
