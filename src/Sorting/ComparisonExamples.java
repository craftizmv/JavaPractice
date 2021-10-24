package Sorting;


import object_equality.Employee;

import java.util.Iterator;
import java.util.List;

/**
 * Checking the sorting related code logic from
 * https://www.baeldung.com/java-check-if-list-sorted
 */
public class ComparisonExamples {

    /**
     * Checks whether the provided list is sorted or not
     * Here SORTED WE MEAN SORTED IN ASC by default.
     *
     * @param listOfString
     * @return
     */
    public static boolean isSorted(List<String> listOfString) {

        if (listOfString.isEmpty() || listOfString.size() == 1) {
            return true;
        }

        Iterator<String> iterator = listOfString.iterator();
        String curr, prev = iterator.next();

        while (iterator.hasNext()) {
            curr = iterator.next();

            //This indicate second element being less than the first element.
            if (prev.compareTo(curr) > 0) {
                return false;
            }

            prev = curr;
        }

        return true;
    }

    //For classes which do not implement comparable we have to compare them using a custom Comparator
    //like below

    /*public static boolean isSorted(List<Employee>) {

    }*/


}


