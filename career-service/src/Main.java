import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        List<int[]> list = Collections.singletonList(data);
        System.out.println("列表中的元素数量是：" + list.size());
        System.out.println(list.get(0).getClass());
    }
}