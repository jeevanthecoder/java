public class DivideWithoutDivision {
    public static void main(String[] args) {
        System.out.println(divide(-10,3));
    }
    public static int divide(int dividend, int divisor) {

        if(divisor==1)return dividend;
        long N=dividend,D=divisor,cnt=0,ans=0;
        long n=N<0?(-1*N):N;
        long d=D<0?(-1*D):D;

        boolean sign = true;//+ve
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0) )sign=false;//-ve


        while(n>=d){
            cnt=0;
            while(n>=(d<<(cnt+1)))
                cnt++;
            if(cnt>=31){

                return (int) (sign?Integer.MAX_VALUE:(-1*Integer.MAX_VALUE));
            }
            ans+=(1<<cnt);

            n=n-(d*(1<<cnt));

        }

        return (int) (sign?ans:(-1*ans));

    }
}
