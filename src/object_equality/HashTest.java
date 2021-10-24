package object_equality;

import java.util.HashSet;
import java.util.Set;

/**
 * Reference - https://muhammadkhojaye.blogspot.in/2010/02/java-hashing.html
 *
 */
public class HashTest {
    private int mutableField;
    private final int immutableField;

    public HashTest(int mutableField, int immutableField) {
        this.mutableField = mutableField;
        this.immutableField = immutableField;
    }

    public void setMutableField(int mutableField) {
        this.mutableField = mutableField;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof HashTest) {
            return (mutableField == ((HashTest)o).mutableField)
                    && (immutableField ==  ((HashTest)o).immutableField);
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + this.mutableField;
        result = 37 * result + this.immutableField;
        return result;
    }

    public static void main(String[] args) {
        Set<HashTest> set = new HashSet<HashTest>();
        HashTest obj = new HashTest(6622458, 626304);
        set.add(obj);
        System.out.println(set.contains(obj));
        obj.setMutableField(3867602);
        System.out.println(set.contains(obj));
    }
}
