import java.util.LinkedList;
import java.util.Queue;

public class DetectIntersection {
    public static void main (String[] args) {
        Object a = new Object();
        Queue<Object> checking = new LinkedList<>();
        checking.add(a);
        System.out.println(checking.contains(a));
    }
}
