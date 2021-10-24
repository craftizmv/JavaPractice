package Multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList();
        integers.add(1);
        integers.add(2);
        integers.add(3);




        /*for (Integer integer : integers) {
            integers.remove(1);
        }*/

       /* Iterator<Integer> integerIterator = integers.iterator();
        while (integerIterator.hasNext()) {
            Integer in = integerIterator.next();
            System.out.println(in);

            integerIterator.remove();
        }*/

        /*for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext(); ) {
            Integer integer = iterator.next();
            System.out.println("Here" + integer);
            *//*if(integer == 1) {
                iterator.remove();
            }*//*
            integers.add(5);
        }*/


        for (int i = 0; i < integers.size(); i++) {
//            if (integers.get(i) == 1) {
                integers.add(5);
//            }
        }

        System.out.println(integers.size());

        for (Integer integer : integers) {
            System.out.println(integer);
        }


    }
}
