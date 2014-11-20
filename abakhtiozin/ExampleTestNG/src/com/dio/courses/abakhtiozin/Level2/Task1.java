package com.dio.courses.abakhtiozin.Level2;

/**
 * Created by AA on 08.10.2014.
 */
//Given integer array. Sort in ascending order.

public class Task1 {

    private static int[] sortArrayASC(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                array[i] = array[i + 1] + array[i];
                array[i + 1] = array[i] - array[i + 1];
                array[i] = array[i] - array[i + 1];
            }
        }
        return array;
    }

    private static boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] sortArray(int[] array){
        if (!isArraySorted(array)) {
            array = sortArrayASC(array);
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array = {0, 1, 2, 7, 4, 5};
        if (!isArraySorted(array)) {
            array = sortArrayASC(array);
        }
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
