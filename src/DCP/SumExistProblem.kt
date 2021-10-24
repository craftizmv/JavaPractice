package DCP

import java.util.*
import kotlin.collections.HashSet

/**
 * Problem : Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 *
 */
class SumExistProblem {

    /**
     * Find whether there exist value at two indices which sum up to a given number.
     *
     * Method : Brute Force
     *
     * Complexity : n * n (As we are using 2 loops.)
     */
    fun findTwoSumIndices_1(sum: Int, givenNumberArray: Array<Int>): Boolean {

        for (i in givenNumberArray.indices) {
            val numberLookingFor = sum - givenNumberArray[i]

            println(" i is $i and Number looking for is : $numberLookingFor")

            for (j in i until (givenNumberArray.lastIndex + 1)) {

                println(" Value of j is : $j and Value at Jth Loc is : " + givenNumberArray[j])

                if (givenNumberArray[j] == numberLookingFor) {
                    return true
                }

            }
        }

        return false
    }


    /**
     * Find whether there exist value at two indices which sum up to a given number
     *
     * Method : Storing the visited values in some set.
     */
    fun findTwoSumIndices_2(sum: Int, givenNumberArray: Array<Int>): Boolean {
        var result = false

        // Creating Hashset to store the visited values.
        val hashset = HashSet<Int>()

        for (i in givenNumberArray.indices) {
            val numberLookingFor = sum - givenNumberArray[i]
            if (hashset.contains(numberLookingFor)) {
                result = true;
                break
            } else {
                hashset.add(givenNumberArray[i])
            }
        }

        return result
    }


    /**
     * Find indices where two indices sum up to a given number
     *
     * Method : Using pre-sorting the number list
     */
    fun findTwoSumIndices_3(sum: Int, givenNumberArray: Array<Int>): Boolean {
        val result = false
        val sortedArr = Arrays.sort(givenNumberArray)



        return result
    }


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val sumExistProblem = SumExistProblem()

//            val findtwosumindices1 = sumExistProblem.findTwoSumIndices_1(18, arrayOf(10, 15, 3, 7))
//            println(" Result findtwosumindices1 : $findtwosumindices1")

            val findTwoSumIndices2 = sumExistProblem.findTwoSumIndices_2(31, arrayOf(16, 15, 3, 7))
            println(" Result findtwosumindices1 : $findTwoSumIndices2")

        }

    }


}
