public class SumOfString {
    public static int getLucky(String s, int k) {
        int sum=0;String str="";
        for(int i=0;i<s.length();i++){
            int s1=(s.charAt(i)-97+1);
            str+=String.valueOf(s1);
            
        }
        System.out.println(str);
        for(char c:str.toCharArray()){
            sum+=Integer.parseInt(String.valueOf(c));
        }
        if(k==1)return sum;
        while(k>1){
            int num=sum;
            sum=0;
            while(num>0){
                sum+=num%10;
                System.out.println(num%10);
                num/=10;
            }
            k--;
        }
        return sum;
    }
    public static void main (String[] args) {
        System.out.println(getLucky("vbyytoijnbgtyrjlsc",2));
    }
}
