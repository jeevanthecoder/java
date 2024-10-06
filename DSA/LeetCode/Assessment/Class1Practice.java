public class Class1Practice {
    
    public static int binToDec(String str){
        int sum=0,j=0;
        for(int i=str.length()-1;i>=0;i--){
            
            if(str.charAt(i)=='1'){
                sum+=(1<<j);
            }
            j++;
        }
        return sum;
    }
    
    public static void main (String[] args) {
//        System.out.println(1<<1);
        System.out.println(binToDec("1010"));
    }
}
