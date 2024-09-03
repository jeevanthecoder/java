public class SimpleTesting {
    public static int[][] emptyArray(int[][] simple){
        // To create an empty array;
        int[][] arr=new int[][]{};
        return arr;
    }
    public static void main(String[] args) {
        int[][] a=new int[1][1];
        System.out.println(emptyArray(a));
    }
}
