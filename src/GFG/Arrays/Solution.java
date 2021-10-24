package GFG.Arrays;

public class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);

            System.out.println("Num : "+ num);
            System.out.println("Current subarray : "+ currentSubarray);
            System.out.println("Max subarray : "+ maxSubarray);
        }

        return maxSubarray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{-1, 2, -3, 5, -4, 7, -10, 9, -5,-3, -4}));
    }
}

