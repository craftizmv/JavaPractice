import sun.rmi.runtime.Log;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class StringTest {

    public static void main(String[] args) {
        /*String version1 = "2.1.1";
        String version2 = "2.2.2";

        int lastIndex = version1.lastIndexOf(".");

        System.out.println( " Last Index is : " + lastIndex);
        version1 = version1.substring(0, lastIndex);
        version2 = version2.substring(0, version2.lastIndexOf("."));

        System.out.println(" Version1 is : " + version1 + " Version2 is : " + version2);

        if(!version1.equals(version2)) {
            System.out.println("Not Equal");
        }*/


        for (int i = 0; i < 5; i++) {
            boolean test = false;
            if (test) ;
            break;
        }

        Test test = Test.AIRTV_ADAPTER;

        switch (test) {
            case NONE:
                System.out.println("Test 1");
                break;
            case AIRTV_ADAPTER:
                System.out.println("Test 2");
                break;
            case AIRTV_CLASSIC:
                System.out.println("Test 3");
                break;
        }

    }

    enum Test {
        NONE, AIRTV_ADAPTER, AIRTV_CLASSIC;
    }
}
