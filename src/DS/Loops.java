package DS;

public class Loops {

    void checkLoop(int[][] input) {
//        System.out.println(" Row Length : " + input.length);
//        System.out.println(" Column Length : " +  input[0].length);
        int m = 2;
        for (int row = 0; row < input.length; row++) {
            for (int col = 1; col < m && col < input[col].length; col++) {
                System.out.println("R : " + row);
                System.out.println("C : " + col);
            }
        }
    }

//    void slidingWindowLoop;

    public static void main(String[] args) {
        int[][] ab = {
                {0, 1,2},
                {2, 1,2},
        };

        Loops l = new Loops();
        l.checkLoop(ab);
    }
}
