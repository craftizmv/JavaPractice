package DS;

public class GFG {

    static class Test {

        int data = 50;


        void modify(int val){
            data = data + val;
        }

        void modifyNew() {
            data = data+100;
        }

    }

    public static void main(String args[])
    {
        /*String str = "1\n2\n3";
        String[] arrOfStr = str.split("\n");

        for (String a : arrOfStr)
            System.out.println(a);*/

        Test t = new Test();
        t.modifyNew();

        System.out.println(t.data);

    }
}
