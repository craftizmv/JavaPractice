package DS.DP;


// 2 - 1
public class StairCaseProblem {

    int ways(int nSteps){
        // Base case -  why <= 1
        if (nSteps <= 1) {return 1; }

        return ways(nSteps -1) + ways(nSteps -2);
    }

    public static void main(String[] args) {
        StairCaseProblem stairCaseProblem = new StairCaseProblem();
        int val = stairCaseProblem.ways(5);
        System.out.println(val);
    }
}
