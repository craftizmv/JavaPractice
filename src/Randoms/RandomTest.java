package Randoms;

public class RandomTest {


    void sum(int a, String b) {
        return;
    }

    void sum(String b, int a) {
        return;
    }

    public static class StaticInnerClass {
        public static int member = 1337;
    }

    public class InnerClass {
        // public static int member = 1337; // Error
        public int member = 1338;
    }

    public static void main(String[] args) {
        /*int a = 10;
        int b = a;
        a = 5;*/

        /*Integer x = null;

        if (x == 1) {
            System.out.println("Value of x is ");
        }*/


        int innerMember = RandomTest.StaticInnerClass.member; // OK

        System.out.println(innerMember);

        RandomTest randomTest = new RandomTest();
        InnerClass innerClass = randomTest.new InnerClass();

        int innerClassMem = innerClass.member;

        System.out.println(innerClassMem);
    }


    public static class Random {
        static int x = 1;
    }
}
