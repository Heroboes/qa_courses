package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 08.10.2014.
 */
//Дано число. Вывести все простые числа в диапазоне от 2 до этого числа включительно.
public class Task4 {

    private static void getPrimeNumbers(int number) {
        for (int i = 2; i <= number; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
            }
        }
    }

    /* method isPrimeNumber
    * if number has positive divisors other than 1 and itsels this number is no Prime Number. Return false*/
    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= 9; i++) {
            if (number % i == 0 && number != i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        getPrimeNumbers(157);
    }
}
