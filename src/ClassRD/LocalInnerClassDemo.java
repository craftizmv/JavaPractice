package ClassRD;

/**
 * Demos class inside a method class called Local Inner class.
 */
public class LocalInnerClassDemo {

    private int data = 30;

    private void display() {


        class Local {
            private void msg() {
                System.out.println(" Data : " + data);
            }
        }

        Local local = new Local();
        local.msg();


    }

    public static void main(String[] args) {
        LocalInnerClassDemo localInnerClassDemo = new LocalInnerClassDemo();
        localInnerClassDemo.display();
    }

}
