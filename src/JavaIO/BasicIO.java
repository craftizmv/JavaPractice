package JavaIO;

import java.io.IOException;

public class BasicIO {

    public static void main(String[] args) {
        //Utility function to input basic int char
        getChar();
    }

    private static void getChar() {
        System.out.println("Enter a charecter !");
        try {
            char c = (char) System.in.read();
            System.out.println("Read char " + c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
