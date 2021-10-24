package ReferenceTest;


class Test {
    int x;
}

public class ReferenceTest {

    public static void main(String[] args) {
        Test test = new Test();
        test.x = 2;
        testRefMethod(test);
        System.out.println("After : " + test.x);
    }

    private static void testRefMethod(Test test) {
        System.out.println("Before : " + test.x);
        test.x = 3;
//        System.out.println("After" + test.x);
    }
}
