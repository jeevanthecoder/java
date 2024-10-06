public class SomeNumber {
    public static boolean num(int[] num){
        int left=0,right=0,i=0,j=num.length-1,flag=0;
        int prevL=0,prevR=0;
        while(i<=j){
            
                left+=num[i];
                i++;
            
                right+=num[j];
                j--;
            
            
            if(right==left) {
                break;
            }
            else if(right>left){
                right-=prevR;
                j++;
            }else if(left>right){
                left-=prevL;
                i--;
            }
            
            prevR=num[j];
            prevL=num[i];
        }
        for(int k=i+1;k<=(j-1);k++){
            if(num[k]!=right){
                flag=1;
                break;
            }
        }
        
        if(flag==1)
            return false;
        else return true;
        
        
    }

    public static void main (String[] args) {
        int[] num={7,4,1,11,4,3,2,7,2,2};
        System.out.println(num(num));
    }
}
