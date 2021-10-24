package JavaIO.Streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreams {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("/Users/mayank/JavaPractice/src/JavaIO/Streams/input.txt");
            fileOutputStream = new FileOutputStream("output.txt");

            int c;

            try {
                while ((c= fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            } catch (IOException e) {
                System.out.println("IO Exception occurred 1");
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not found ");
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.out.println("IO Exception occurred 2");
                    e.printStackTrace();
                }
            }

            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println("IO Exception occurred 3");
                    e.printStackTrace();
                }
            }
        }

    }

}
