package HackerRank;

/**
 * Problem
 *
 *   New Students are arriving at college. Initially the students don't know each other, and each
 *   has a circle of friends limited to themselves. As the semester progresses, groups of friends
 *   form.
 *
 *   As they arrive, each students gets an ID number, 1 to n.
 *
 *   You will be given three arrays, each aligned by index.
 *   The first array will contain a 'queryType' which will be either 'Friend' or 'Total'.
 *   The next two arrays, 'students1' and 'students2', will each contain a Student ID.
 *
 *   If the query type is 'Friends' the two students become friends.
 *
 *   If the query type is 'Total', you must report the sum of the sizes of the groups of friends
 *   for the two students.
 *
 *   For example, if you have n=4 students numbered 1-4 and you receive the following queries:
 *
 *     Friend 1 2
 *     Friend 2 3
 *     Total  1 4
 *
 *   Students will start as discrete group {1},{2},{3} and {4}. Students 1 and 2 become friends
 *   as do 2 and 3. The new groups are {1,2}, {2,3} and {4} wihich simplies to {1,2,3} and {4}.
 *   We then total the number of friends for student 1 = 3 and student 4 = 1 for a total =4.
 *   Notice that student 3 is part of student1's circle of friends indirectly through student 2.
 *
 * Functional Description
 *
 *   Complete the function getTheGroups in the editor below. The function must return an array
 *   of integers where the value at each index j denotes the answer for the jth query of type Total.
 *
 *   getThe Groups has the following parameter(s):
 *   - n: the number of students, integer
 *   - queryType [queryType[1],...queryTpe[q]]: an array of query type strings
 *   - student1 [student1[1],...student1[q]]: an array of student integer ID's
 *   - student2 [student2[1],...student2[q]]: an array of student integer ID's
 *
 * Constraints
 *
 *   1 <= n <= 10 pow 5
 *   1 <= q <= 10 pow 5
 *   1 <= students1[i] <= n
 *   1 <= students2[i] <= n
 *   queryType[i] is a member of {Friend, Total}
 *
 * Input Format
 *
 *   Input from stdin will be processed as follows and passed to the function.
 *
 *   - The first line contains an integer n, the number of students.
 *   - The next line contains an integer q, the number of queries.
 *   - Each of the next q lines contains a string queryType[i] where 1 <= i <= q.
 *   - The next line contains an integer q, the number of students.
 *   - Each of the next q lines contains a string students1[i] where 1 <= i <= q.
 *   - The next line contains an integer q, the number of students.
 *   - Each of the next q lines contains a string students2[i] where 1 <= i <= q.
 *
 * Sample Input
 *
 *   3            - the number of students
 *   2            - the number of queries
 *   Friend       - queryType[1]
 *   Total        - queryType[2]
 *   2            - the number of queries
 *   1            - student1[1]
 *   2            - student1[2]
 *   2            - then number of queries
 *   2            - student2[1]
 *   3            - student2[2]
 *
 * Sample Output
 *
 *   3
 *
 * Explanation
 *
 *   There are n = 3 students labelled with IDs {1,2,3}.
 *   We perform q = 2 queries:
 *   Query 1 - "Friend 1 2" - Students 1 and two become friends
 *   Query 2 - "Total 2 3" - Find the total number of students in students 2 and 3's collective groups.
 *                           Student 2 is in a group with two friends (i.e. {1,2}).
 *                           Student 3 is in a group with one friend (i.e. {3})
 *                           So store 2 + 1 = 3 in index 0 of the return array.
 *   After performing all the queries, we return the array [3] as our answer.
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getTheGroups' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY queryType
     *  3. INTEGER_ARRAY students1
     *  4. INTEGER_ARRAY students2
     */

    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        // Write your code here

        // Initialise student groups
        List<ArrayList> studentGroups = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> studentSet = new ArrayList<>();
            // Initially there is one student per studentSet.
            studentSet.add(i);
            studentGroups.add(studentSet);
        }

        // Initialise group totals
        List<Integer> groupTotals = new ArrayList<>();

        // Process queries
        for (int q = 0; q < queryType.size(); q++) {

            // Process Friend queries
            if (queryType.get(q).equals("Friend")) {

                // Print query request
                System.out.println(q + ". Friend " + students1.get(q) + " " + students2.get(q));

                // Keep track of groups being changed
                int addToIndex = 0;
                int removeFromIndex = 0;

                // Find studentGroup containing student1, then add student2
                System.out.println("StudentGroups after additions");
                for (int i = 0; i < studentGroups.size(); i++) {
                    ArrayList<Integer> studentSet = studentGroups.get(i);
                    if (studentSet.contains(students1.get(q))) {
                        studentSet.add(students2.get(q));
                        addToIndex = i;
//						System.out.println("addToIndex: " + addToIndex);
                    }
                    System.out.println("StudentGroup " +i+ ": " + studentGroups.get(i));
                }

                // Find studentGroup which already has student2 in it
                System.out.println("StudentGroups after combining and removing");
                for (int i = 0; i < studentGroups.size(); i++) {
                    ArrayList<Integer> studentSet = studentGroups.get(i);
                    if (studentSet.contains(students2.get(q))
                            && !studentSet.contains(students1.get(q))) {
                        removeFromIndex = i;
//						System.out.println("removeFromIndex: " + removeFromIndex);
                    }
                }

                // Get the new and old StudentGroups
                ArrayList<Integer> addToStudentSet = studentGroups.get(addToIndex);
                ArrayList<Integer> removeFromStudentSet = studentGroups.get(removeFromIndex);

                // Add students to new group
                for (int i = 0; i < removeFromStudentSet.size(); i++) {
                    // Adding add the friends of student2.get(q) except at roll index q.
                    if (removeFromStudentSet.get(i) != students2.get(q)) {
                        addToStudentSet.add(removeFromStudentSet.get(i));
                    }
                }

                // Remove students from old group
                while (!removeFromStudentSet.isEmpty()) {
                    removeFromStudentSet.remove(0);
                }

                // Remove old group
                if (removeFromStudentSet.isEmpty()) {
                    studentGroups.remove(removeFromIndex);
                }

                // Print studentGroups to confirm processing
                for (int i = 0; i < studentGroups.size(); i++) {
                    System.out.println("StudentGroup " +i+ ": " + studentGroups.get(i));
                }

            }


            // Process Total queries
            if (queryType.get(q).equals("Total")) {

                // Print query request
                System.out.println(q + ". Total " + students1.get(q) + " " + students2.get(q));

                // Find studentGroup containing students1[i]
                int size1 = 0;
                int size2 = 0;
                for (int j = 0; j < studentGroups.size(); j++) {
                    System.out.println("StudentGroup " +j+ ": " + studentGroups.get(j));

//					List<ArrayList> studentSet = studentGroups.get(j);
                    ArrayList<Integer> studentSet = studentGroups.get(j);

                    if (studentSet.contains(students1.get(q))) {
                        size1 = studentGroups.get(j).size();
                        System.out.println("StudentGroup size is: "  + studentGroups.get(j).size());
                    }

                    if (studentSet.contains(students2.get(q))) {
                        size2 = studentGroups.get(j).size();
                        System.out.println("StudentGroup size is: "  + studentGroups.get(j).size());
                    }

                }
                int groupTotal = size1 + size2;
                System.out.println("Request " + q + " Total: " + groupTotal);
                groupTotals.add(size1 + size2);
            }

        }

        return groupTotals;
    }

}


public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int queryTypeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queryType = IntStream.range(0, queryTypeCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int students1Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> students1 = IntStream.range(0, students1Count).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$","");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int students2Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> students2 = IntStream.range(0, students2Count).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$","");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.getTheGroups(n, queryType, students1, students2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}


//Testcase 3
//
// Input
//  5
//  3
//  Friend
//  Friend
//  Total
//  3
//  4
//  2
//  2
//  3
//  1
//  4
//  3
//
// Expected Output
//  4
//
// Actual Output
//
// 0. Friend 4 1
// StudentGroups after additions
// StudentGroup 0: [1]
// StudentGroup 1: [2]
// StudentGroup 2: [3]
// StudentGroup 3: [4, 1]
// StudentGroup 4: [5]
// StudentGroups after combining and removing
// StudentGroup 0: [2]
// StudentGroup 1: [3]
// StudentGroup 2: [4, 1]
// StudentGroup 3: [5]
// 1. Friend 2 4
// StudentGroups after additions
// StudentGroup 0: [2, 4]
// StudentGroup 1: [3]
// StudentGroup 2: [4, 1]
// StudentGroup 3: [5]
// StudentGroups after combining and removing
// StudentGroup 0: [2, 4, 1]
// StudentGroup 1: [3]
// StudentGroup 2: [5]
// 2. Total 2 3
// StudentGroup 0: [2, 4, 1]
// StudentGroup size is: 3
// StudentGroup 1: [3]
// StudentGroup size is: 1
// StudentGroup 2: [5]
// ARequest 2 Total: 4

