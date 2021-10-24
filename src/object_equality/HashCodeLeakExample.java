package object_equality;

import java.util.HashMap;
import java.util.Map;

/**
 * Example demonstrating a Hashcode leak.
 */
public class HashCodeLeakExample {
    private String id;

    public HashCodeLeakExample(String id) {
        this.id = id;
    }

    public static void main(String args[]) {
        try {
            Map<HashCodeLeakExample, String> map =
                    new HashMap<>();
            while (true) {
                map.put(new HashCodeLeakExample("id"), "any value");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
