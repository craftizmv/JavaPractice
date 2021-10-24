package GFG.Arrays;

import java.util.ArrayList;

public class SubArrayNSquare {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0; i< n; i++) {
            int eS = s;
            result.clear();
            result.add(i+1);
            for(int j=i; j< n; j++) {
                int value = arr[j];
                eS = eS - value;
                if (eS == 0) {
                    result.add(j+1);
                    return result;
                } else if (eS < 0) {
                    break;
                }
            }
        }

        result.clear();
        result.add(-1);

        return result;
    }

    public static void main(String[] args) {
        withNSquare();
    }

    static void withNSquare() {
        int[] inputArr = new int[]{1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> result  = subarraySum(inputArr,10,15);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }


}
