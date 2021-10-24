package DS.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CovidProbSol1 {
    public int helpaterp(int[][] hospital) {
        // code here
        int R = hospital.length;
        int C = hospital[0].length;
        int[] x = new int[]{-1,1,0,0};
        int[] y = new int[]{0,0,-1,1};


        int count=0;
        boolean[][] visited = new boolean[R][C];

        // 1. Extracted all the infected people.
        Queue<Cell> InfectedQueue = new LinkedList<Cell>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(hospital[i][j]==2){
                    InfectedQueue.add(new Cell(i,j));
                }
            }
        }

        while(!InfectedQueue.isEmpty()) {
            int size=InfectedQueue.size();
            for(int k=0;k<size;k++) {
                Cell patient=InfectedQueue.poll();
                for(int i=0;i<4;i++){
                    int r = patient.row+x[i];
                    int c = patient.col+y[i];
                    if(isSafe(R,C,r,c) && hospital[r][c]==1 && !visited[r][c]){
                        InfectedQueue.add(new Cell(patient.row+x[i],patient.col+y[i]));
                        visited[r][c]=true;
                    }
                }
            }
            count++;
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(hospital[i][j]==1 && visited[i][j]==false){
                    return -1;
                }
            }
        }

        System.out.println("Queue Size : " + InfectedQueue.size());
        return count-1;

    }
    public boolean isSafe(int R, int C, int r, int c){
        return r>=0 && r<R && c>=0 && c<C;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        CovidProbSol1 prob = new CovidProbSol1();
        System.out.println(prob.helpaterp(arr));
    }
}

class Cell{
    int row,col;
    public Cell(int row, int col){
        this.row=row;
        this.col=col;
    }
}
