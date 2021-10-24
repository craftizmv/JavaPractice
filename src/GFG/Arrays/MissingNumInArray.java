package GFG.Arrays;

import java.util.ArrayList;

public class MissingNumInArray {

    int MissingNumber(int array[], int n) {
        // Your Code Here
        int sum = 0;
        for(int i=0;i < array.length;i++){
            sum += array[i];
        }

        System.out.println("Sum" + sum);

        int shouldBeSum = n*(n+1)/2;

        System.out.println("shouldBeSum" + shouldBeSum);

        return shouldBeSum - sum;
    }

    int getMissingNo(int a[], int n)
    {
        int total = 1;
        for (int i = 2; i <= (n + 1); i++)
        {
            total += i;
            total -= a[i - 2];
        }
        return total;
    }

    public static void main(String[] args) {
        int input[] = {1,2,3,5};

        MissingNumInArray test = new MissingNumInArray();
        int op = test.MissingNumber(input,5);
        System.out.println(op);

        int op1 = test.getMissingNo(input,5);
        System.out.println(op1);

    }
}
