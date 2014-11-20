package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 10.10.2014.
 */
/*Дано две строки. Определить является ли вторая строка подстрокой в строке. Для написания
метода НЕ ИСПОЛЬЗОВАТЬ стандартные методы по работе с подстрокой Java. Пример: “abcdef” и
“bcd”, метод должен ввернуть true.*/

    /*
    Given 2 Strings. Find out if the second String is substring of first String.
    Do not use any String methods that work with substrings.
     For example: First string: "abcdef", second string "bcd", method should return true.
     */

public class Task5 {

    public static void main(String[] args) {
        String mainString = "abrakadabra";
        String secondString = "adabra";
        System.out.println(isSubString(mainString,secondString));

    }
    private static char[] convertStringToCharArray(String stringToConvert){
        char[] charArray = new char[stringToConvert.length()];
        for (int i = 0; i< stringToConvert.length();i++){
            charArray[i] = stringToConvert.charAt(i);
        }
        return charArray;
    }
    public static boolean isSubString(String mainString, String subString){
        char[] charArray = convertStringToCharArray(subString);
        for (int i = 0; i< mainString.length();i++){
            if (mainString.charAt(i) == charArray[0]){
                for (int j = 1; j < subString.length(); j++) {
                    if (j+i < mainString.length()){
                        if (mainString.charAt(i+j) != charArray[j]){
                            break;
                        }
                        if (j == subString.length()-1){
                            return true;
                        }
                    }

                }

            }
        }
        return false;
    }
}
