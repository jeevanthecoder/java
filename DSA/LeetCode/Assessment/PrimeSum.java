public class PrimeSum {
    public static int primeSum(int num){
        int sum=0;
        while(num>0){

            if(primeCheck(num%10)){
                System.out.println("Prime : "+num%10);
                sum+=num%10;
                System.out.println(sum);
            }
            num/=10;
            if(num<=0 && sum>9){
                num=sum;
                sum=0;
            }
        }
        return sum;
    }
    public static boolean primeCheck(int num){
        boolean flag=true;
        if(num==1)flag=false;
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        System.out.println(primeSum(1234575));
    }
}
