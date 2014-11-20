package com.dio.courses.abakhtiozin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AA on 03.10.2014.
 */
public class Level1 {


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};

//        /* Task 6 BEGIN */
//        int[] ArrayOfEvenNumbers = getArrayOfEvenNumbers(array);
//        if (ArrayOfEvenNumbers.length > 0) {
//            for (int elements : ArrayOfEvenNumbers) {
//                System.out.println(elements);
//            }
//        } else {
//            System.out.println("There is no even numbers in this array");
//        }
//        /* Task 6 END */

                /* Task 7 BEGIN */
//        changeAllElemOfArrayBiggerThen(array,2);
                /* Task 7 END */

                /* Task 8 BEGIN */
//        getCountOfZeroPlusAndNegativeNum(array);
                /* Task 8 END */

                /* Task 9 BEGIN */
//        changeMaxAndMinNumOfArray(array);
                /* Task 9 END */

                /* Task 10 BEGIN */
//        printElementsWherePositionBiggerThanValue(array);
                /* Task 10 END */

                /* Task 11 BEGIN */
//        printElementsWhereModulo(array,2,0);
                /* Task 11 END */

                /* Task 12 BEGIN */
//        swapAdjacentElements(array);
                /* Task 12 END */

                /* Task 13 BEGIN */
//        printAllElementsBeforeZero(array);
                /* Task 13 END */

                /* Task 14 BEGIN */
//        System.out.println(getSumOfMinAndMaxElement(array));
                /* Task 14 END */

                  /* Task 15 BEGIN */
//        getProdOfArrayElementsBiggerThan(array,8);
                  /* Task 15 END */

                  /* Task 16 BEGIN */
//        int[] arrayOfEvenNumbers = changeElementsWhereAbsValueBiggerThanMax(array);
//        for (int elements : arrayOfEvenNumbers) {
//            System.out.println(elements);
//        }
                  /* Task 16 END */

                    /* Task 17 BEGIN */
//        printBiggestAbsProductionOfElements(array);
                  /* Task 17 END */

                /* Task 18 BEGIN */
//        changeFirstMaxElementByZero(array);
                /* Task 18 END */

        /* Task 19 BEGIN */
//        int[] arrayOfEvenNumbers = createArrayOfElementsThatEndOn(array, 1);
//        for (int elements : arrayOfEvenNumbers) {
//            System.out.println(elements);
//        }
        /* Task 19 END */

    }


    //1. Given two numbers. Find the min of them.
    public static int findMinimumOfTwoNumbers(int firstNumber, int secondNumber) {
        int min = firstNumber;
        if (min > secondNumber) {
            min = secondNumber;
        }
        return min;
    }

    //2. Given an int array. Find the sum of the elements that are multiples of a given number K.
    public static int findSumOfElementsMultiplesOfNumber(int[] array, int multiplier) {
        int sum = 0;
        for (int element : array) {
            if (element % multiplier == 0) {
                sum += element;
            }
        }
        return sum;
    }

    //3. Given integer array with zero elements. Create array with position of this elements.
    public static int[] createArrayOfZeroElements(int[] array) {
        //find zero number in Given Array and fill in new zeroList
        List<Integer> zeroList = new ArrayList<Integer>();
        for (Integer i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeroList.add(i);
            }
        }
        //create zeroArray with size of zeroList
        int[] zeroArray = new int[zeroList.size()];
        int i = 0;
        for (int value : zeroList) {
            zeroArray[i++] = value;
        }
        return zeroArray;
    }


    //    4. Given integer array with negative and positive elements. Find out which element negative or positive encountered first.
    public static boolean isTheFirstElementOfArrayPositive(int[] array) {
        for (int element : array) {
            if (element != 0) {
                return element > 0;
            }
        }
        return false;
    }

    // возможно имелось ввиду чаще, а не раньше?
    public static boolean isPositiveElementsMoreThenNegative(int[] array) {
        int positive = 0;
        int negative = 0;
        for (int element : array) {
            if (element != 0) {
                if (element > 0) {
                    positive++;
                } else {
                    negative++;
                }
            }
        }
        return positive > negative;
    }

    // 5. Given integer array. Find out is it sorted in ascending order.
    public static boolean isArraySorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }


    //    6. Given integer array. Create array of even numbers. If there are no even numbers, print message about it.
    public static int[] getArrayOfEvenNumbers(int[] array) {
        List<Integer> listOfEvenNumber = new ArrayList<Integer>();
        for (int elementOfArray : array) {
            if (elementOfArray != 0 && elementOfArray % 2 == 0) {
                listOfEvenNumber.add(elementOfArray);
            }
        }
        int[] zeroArray = new int[listOfEvenNumber.size()];
        int i = 0;
        for (int value : listOfEvenNumber) {
            zeroArray[i++] = value;
        }

        return zeroArray;
    }

    //7. Given integer array. Change all elements which bigger than Z, by this number. Count the number of replacements.
    public static int[] changeAllElemOfArrayBiggerThen(int[] arrayToChange, int changer) {
        int counter = 0;
        for (int i = 0; i < arrayToChange.length; i++) {
            if (arrayToChange[i] > changer) {
                arrayToChange[i] = changer;
                counter++;
            }
        }
        System.out.println("count of changed numbers: " + counter);
        return arrayToChange;
    }


    //8 Given integer array. Count the number of positive, negative and zero elements.
    public static int[] getCountOfZeroPlusAndNegativeNum(int[] array) {
        int positive = 0;
        int negative = 0;
        int zero = 0;
        int[] result = new int[3];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                positive++;
            }
            if (array[i] < 0) {
                negative++;
            }
            if (array[i] == 0) {
                zero++;
            }
        }
        result[0] = positive;
        result[1] = negative;
        result[2] = zero;
        return result;
    }


    //9. Given integer array. Swap the biggest with the smallest element.
    public static int[] changeMaxAndMinNumOfArray(int[] array) {
        int max = array[0];
        int min = array[0];
        int numberOfMax = 0;
        int numberOfMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                numberOfMax = i;
            }
            if (min > array[i]) {
                min = array[i];
                numberOfMin = i;
            }
        }
        array[numberOfMax] = array[numberOfMin] + array[numberOfMax];
        array[numberOfMin] = array[numberOfMax] - array[numberOfMin];
        array[numberOfMax] = array[numberOfMax] - array[numberOfMin];

       return array;
    }


    //10. Given integer array. Print only those numbers where condition arr[i] <= i  is true.
    public static int[] printElementsWherePositionBiggerThanValue(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
           if (array[i] <= i) {
               count++;
//                System.out.print(array[i] + " ");
            }
        }
        int[] result = new int[count];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= i) {
                result[count++] = array[i];
            }
        }
        return result;
    }


    //11. Given integer array. Print those elements which the remainder of the division by M is equal to L.
    public static void printElementsWhereModulo(int[] array, int m, int l) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % m == l) {
                System.out.print(array[i] + " ");
            }
        }
    }

    //    12.Given integer array. Swap adjacent elements (a [0], and a [1] and [2] and [3], ...)
    public static void swapAdjacentElements(int[] array) {
        int i = 0;
        while (i < array.length - 1) {
            array[i] = array[i + 1] + array[i];
            array[i + 1] = array[i] - array[i + 1];
            array[i] = array[i] - array[i + 1];
            i += 2;
        }
        for (int element : array) {
            System.out.print(element + " ");
        }
    }


    //    13. Given integer array with one zero element. Print all elements before zero.

    public static void printAllElementsBeforeZero(int[] array) {
        int i = 0;
        do {
            System.out.print(array[i] + " ");
            i++;
        } while (array[i - 1] != 0);
    }

    //    14.Given Integer array. Find mаx(а[0], а[2], ..., а[2к]) + min(а[1], а[3], ..., а[2к-1]).
    public static int getSumOfMinAndMaxElement(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                if (i % 2 == 0) {
                    if (max < array[i]) {
                        max = array[i];
                    }
                }
                if (i % 2 != 0) {
                    if (min > array[i]) {
                        min = array[i];
                    }
                }
            }
        }
        return max + min;
    }


    //15. Given positive integer array. Find out production only those numbers that bigger than M. If there are no such elements, print message.

    public static void getProdOfArrayElementsBiggerThan(int[] arrayToChange, int changer) {
        int prod = 1;
        int counter = 0;
        for (int element : arrayToChange) {
            if (element != 0 && element > changer) {
                prod *= element;
                counter++;
            }
        }
        if (counter == 0 ){
            System.out.print("there is no such elements in array bigger than " + changer);
        } else {
            System.out.print("Production of numbers biggier than M =  " + prod);
        }
    }

    //    16.Дан массив положительных и отрицательных чисел. Заменить нулями те числа, величина которых
    //    по модулю больше максимального числа (|a[i]| > max{ a[0], a[1], ..., a[n]})
    public static int[] changeElementsWhereAbsValueBiggerThanMax(int[] arrayToChange) {
        int max = arrayToChange[0];
        for (int i = 0; i < arrayToChange.length; i++) {
            if (max < arrayToChange[i]) {
                max = arrayToChange[i];
            }
            if (Math.abs(arrayToChange[i]) > max) {
                arrayToChange[i] = 0;
            }
        }
        return arrayToChange;
    }

//    17.Дан массив чисел с положительными и отрицательными элементы. Вычислить произведение
//    отрицательных элементов P1 и произведение положительных элементов Р2. Сравнить модуль Р2 с
//    модулем Р1 и указать, какое из произведений по модулю больше.

    public static void printBiggestAbsProductionOfElements(int[] array) {
        int p1 = 1;
        int p2 = 1;
        for (int i = 0; i < array.length; i++) {

            if (array[i] > 0) {
                p1 *= array[i];
            }
            if (array[i] < 0) {
                p2 *= array[i];
            }
        }
        if (Math.abs(p1) > Math.abs(p2)) {
            System.out.println("Production of abs positive elements of array bigger than negative one");
        } else {
            System.out.println("Production of abs negative elements of array bigger than positive one");
        }
    }


    //    18.Дан массив чисел. Среди них есть равные. Найти первый максимальный элемент массива и
//    заменить его нулем.
    public static int[] changeFirstMaxElementByZero(int[] arrayToChange) {
        int max = arrayToChange[0];
        int counter = 1;
        for (int i = 0; i < arrayToChange.length; i++) {
            if (max < arrayToChange[i]) {
                max = arrayToChange[i];
                counter = i;
            }
        }
        arrayToChange[counter] = 0;
        return arrayToChange;
    }

    /*
19. Дан массив чисел. Образовать новый массив, элементами которого будут элементы исходного,
оканчивающиеся на цифру k.*/
    public static int[] createArrayOfElementsThatEndOn(int[] array, int k) {
        List<Integer> zeroList = new ArrayList<Integer>();
        for (int element : array) {
            String stringElement = Integer.toString(element);
            String lastNumb = stringElement.substring(stringElement.length() - 1);
            if (lastNumb.equals(Integer.toString(k))) {
                zeroList.add(element);
            }
        }
        int[] zeroArray = new int[zeroList.size()];
        int i = 0;
        for (int value : zeroList) {
            zeroArray[i++] = value;
        }
        return zeroArray;
    }

}
