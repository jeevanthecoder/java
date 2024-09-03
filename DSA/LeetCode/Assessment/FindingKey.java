public class FindingKey {
    public static int Key(int input1,int input2,int input3){
        int max1=0,res=0,i=0;
        while(input1>0 && input2>0 && input3>0){
max1=0;
            if(max1<input1%10)max1=input1%10;
            if(max1<input2%10)max1=input2%10;
            if(max1<input3%10)max1=input3%10;

            res=res+max1*((int)Math.pow(10,i));

            input1/=10;
            input2/=10;
            input3/=10;
i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Key(3456,4569,8756));
    }
}
