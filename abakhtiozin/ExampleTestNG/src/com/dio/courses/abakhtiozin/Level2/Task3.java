package com.dio.courses.abakhtiozin.Level2;

/**
 * Created by AA on 08.10.2014.
 */

//Given chat array. Print array where all upper case chars changed on lower case chars.
// Example: given {‘a’, ‘Z’, ‘E’, ‘d’}, print {‘a’, ‘z’, ‘e’, ‘d’}.

public class Task3 {

    public static char[] toLowerCase(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if ((int) array[i] > 64 && (int) array[i] < 91) {
                array[i] = (char) ((int) array[i] + 32);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        char[] given = {'a', 'Z', 'E', 'd'};
        given = toLowerCase(given);
        for (char c : given) {
            System.out.print(c + " ");
        }
    }
}
