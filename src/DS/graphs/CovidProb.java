package DS.graphs;

public class CovidProb{

    // class Node {
    //     int x;
    //     int y;
    //     int value;
    //     boolean isVisited;
    // }

    int time = 0;

    public int helpaterp(int[][] hospital) {
        // code here
        // start with 0,0 and navigate to all the directions.

        for (int i = 0; i < hospital.length; ++i) {
            for(int j = 0; j < hospital[i].length; ++j) {
                System.out.print(hospital[i][j]);
            }
            System.out.println();
        }

        int columnSize = hospital.length;
        int rowSize = 0;
        if (columnSize > 0) {
            rowSize = hospital[0].length;
        }

        System.out.println(" Col Size : " + columnSize);
        System.out.println(" Row Size : " + rowSize);

        boolean isTimeIncreased = false;
        boolean hasUnInfected = false;

        for(int i=0;i<columnSize;i++) {
            for(int j=0; j <rowSize;j++){

                if (hospital[i][j] != 2) {
                    continue;
                }

                // x+ y
                System.out.println("i : " + i + "j : " + j);
                if (isIndexValid(i+1, j, columnSize, rowSize) && hospital[i+1][j] == 1) {
                    hospital[i+1][j] = 2;
                    if (!isTimeIncreased) {
                        time++;
                        isTimeIncreased = true;
                    }
                    hasUnInfected = true;
                }

                // x- y
                if (isIndexValid(i-1, j, columnSize, rowSize) && hospital[i-1][j] == 1){
                    hospital[i-1][j] = 2;
                    if (!isTimeIncreased) {
                        time++;
                        isTimeIncreased = true;
                    }

                    hasUnInfected = true;
                }

                // x y+
                if (isIndexValid(i, j+1, columnSize, rowSize) && hospital[i][j+1] == 1){
                    hospital[i][j+1] = 2;
                    if (!isTimeIncreased) {
                        time++;
                        isTimeIncreased = true;
                    }

                    hasUnInfected = true;
                }

                // x y-
                if (isIndexValid(i, j-1, columnSize, rowSize) && hospital[i][j-1] == 1) {
                    hospital[i][j-1] = 2;
                    if (!isTimeIncreased) {
                        time++;
                        isTimeIncreased = true;
                    }

                    hasUnInfected = true;
                }

            }
        }

        if (hasUnInfected == true) {
            System.out.println("GOING FOR RECUR!!");
            helpaterp(hospital);
        }
        return time;
    }

    public boolean isIndexValid(int y, int x, int colSize, int rowSize) {
        System.out.println(" Col Size : " + colSize);
        System.out.println(" Row Size : " + rowSize);
        if (x < 0 || y <0 || colSize < 0 || rowSize < 0){
            System.out.println(" Not Valid 1");
            return false;
        }
        if (x < rowSize && y < colSize) {
            System.out.println(" x : " + x + " y: " + y);
            System.out.println(" rS : " + rowSize + " cS: " + colSize);
            System.out.println(" Yeah Valid");
            return true;
        }

        System.out.println(" Not Valid -2");
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        CovidProb prob = new CovidProb();
        System.out.println(prob.helpaterp(arr));
    }
}
