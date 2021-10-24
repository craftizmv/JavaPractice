package JavaIO;

import java.util.Locale;

public class FileUtils {
    public static void main(String[] args) {
        long test = (1024 << 10);

        String errorMessage = String.format(Locale.US, "%s(%d)", "", -1);
        System.out.println(errorMessage);

        System.out.println(test);
    }

    static void convertToBinary(int no){
        int container[] = new int[100];
        int i = 0;
        while (no > 0){
            container[i] = no%2;
            i++;
            no = no/2;
        }
        for (int j = i -1 ; j >= 0 ; j--){
            System.out.print(container[j]);
        }
    }
}
