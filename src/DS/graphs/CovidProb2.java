package DS.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CovidProb2{
    Queue<int[]> q=new LinkedList<>();
    int un=0;
    public void helper(int[][] hos,int i,int j){
        if(i<0||j<0||j>=hos[0].length||i>=hos.length||hos[i][j]!=1)
            return;
        hos[i][j]=2;
        q.add(new int[]{i,j});
        un--;
    }
    public int helpaterp(int[][] hos) {
        // code here
        int time=0;
        for(int i=0;i<hos.length;i++){
            for(int j=0;j<hos[0].length;j++){
                if(hos[i][j]==1)
                    un++;
                if(hos[i][j]==2)
                    q.add(new int[] {i,j});
            }
        }
        if(un==0) return 0;
        while(!q.isEmpty()){
            time++;
            int tmp=q.size();
            while(tmp-- > 0){
                int[] pt=q.poll();
                helper(hos,pt[0]+1,pt[1]);
                helper(hos,pt[0]-1,pt[1]);
                helper(hos,pt[0],pt[1]+1);
                helper(hos,pt[0],pt[1]-1);
            }
        }
        return (un==0)?time-1:-1;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        CovidProb2 prob = new CovidProb2();
        System.out.println(prob.helpaterp(arr));
    }
}
