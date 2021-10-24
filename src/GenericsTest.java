import java.util.*;

public class GenericsTest {
    public static void addIntegers(List<? super Integer> list) {
        list.add(new Integer(3));
    }

    /*private <K> ArrayList<K> getUniqueArrayListFromMap(HashMap<K,ArrayList<K>> inputMap) {
        if (!inputMap.isEmpty()) {
            for (ArrayList<K> kArrayList : inputMap.values()) {
                //Here we need to filter the unique objects

            }

        }
    }*/

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        sum(list);

        List<Double> objectList = new ArrayList<>();
        sum(objectList);

        Queue<Integer> q = new LinkedList<>();

        // Adds elements {0, 1, 2, 3, 4} to queue
        for (int i=0; i<5; i++)
            q.add(i);

        // Display contents of the queue.
        System.out.println("Elements of queue-" + q);

        // To remove the head of queue.
        int removedele = q.remove();
        System.out.println("removed element-" + removedele);

        System.out.println(q);

        // To view the head of queue
        int head = q.peek();
        System.out.println("head of queue-" + head);

        // Rest all methods of collection interface,
        // Like size and contains can be used with this
        // implementation.
        int size = q.size();
        System.out.println("Size of queue-" + size);
    }

    public static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
