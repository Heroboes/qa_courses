package com.dio.courses.abakhtiozin;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by A.Bakhtiozin on 22.10.2014.
 */
public class JUnitTestExample {
    @Test
    public void level1Test1(){
        int givenA = 4;
        int givenB = 7;
        Assert.assertTrue("The minimum of 2 numbers " + givenA + " and " + givenB + " should be " + givenA, Level1.findMinimumOfTwoNumbers(givenA, givenB) == givenA);
    }
    @Test
    public void level1Test2(){
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int multiplier = 2;
        int expected = 12;
        Assert.assertTrue(Level1.findSumOfElementsMultiplesOfNumber(array, multiplier) == expected);
    }
    @Test
    public void level1Test3(){
        int[] givenArray = {1, 0, 3, 0, 5, 0, 7};
        int[] expectedArray = {1,3,5};
        Assert.assertTrue(Arrays.equals(Level1.createArrayOfZeroElements(givenArray),expectedArray));
    }
    @Test
    public void level1Test4(){
        int[] array = {1, -2, 3, 4, 5, 6, 7};
        boolean expected = true;
        Assert.assertTrue(Level1.isTheFirstElementOfArrayPositive(array) == expected);
    }
    @Test
    public void level1Test5(){
        int[] array = {1, 2, 3, 4};
        boolean expected = true;
        Assert.assertTrue(Level1.isArraySorted(array) == expected);
    }
    @Test
    public void level1Test6(){
        int[] array = {1, 3, 4, 5, 6, 7};
        int[] expected = {4, 6};
        Assert.assertTrue(Arrays.equals(Level1.getArrayOfEvenNumbers(array),expected));
    }
    @Test
    public void level1Test7(){
        int[] array = {1, -2, 3, 4, 5, 6, 7};
        int[] expected = {1, -2, 3, 3, 3, 3, 3};
        Assert.assertTrue(Arrays.equals(Level1.changeAllElemOfArrayBiggerThen(array, 3),expected));
    }
    @Test
    public void level1Test8(){
        int[] array = {1, -2, 3, 0, -5, 0, 7};
        int[] expected = {3, 2, 2};
        Assert.assertTrue(Arrays.equals(Level1.getCountOfZeroPlusAndNegativeNum(array),expected));
    }
    @Test
    public void level1Test9(){
        int[] array = {1, -2, 3, 4, 5, 6, 7};
        int[] expected = {1, 7, 3, 4, 5, 6, -2};
        Assert.assertTrue(Arrays.equals(Level1.changeMaxAndMinNumOfArray(array),expected));
    }
    @Test
    public void level1Test10(){
        int[] array = {1, 2, 3, 1, 5, 0, 7};
        int[] expected = {1,0};
        Assert.assertTrue(Arrays.equals(Level1.printElementsWherePositionBiggerThanValue(array),expected));
    }
}
