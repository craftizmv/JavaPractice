package Interface_Related;

public class TestStaticImpl {
    private static String x;

    static {
        x = "mayank verma";
    }


    public enum AppStateBeforeRestart {
        FOREGROUND("Foreground"),
        BACKGROUND("Background"),
        USER_INTERACTING("User interacting"),
        DAYDREAM_MODE("Daydreaming");

        private String state;

        AppStateBeforeRestart(String appState) {
            state = appState;
        }

        public String getAppState() {
            return state;
        }
    }

    public static void main(String[] args) {
        System.out.println(" value is : " + x);

        System.out.println(" Result : " + solve(6));

        System.out.println( "Temp : " + AppStateBeforeRestart.FOREGROUND);
    }


    static int solve(int n)
    {
        // base case
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;

        return solve(n-1) + solve(n-3) + solve(n-5);
    }
}
