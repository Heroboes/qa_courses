package com.dio.courses.abakhtiozin;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by A.Bakhtiozin on 22.10.2014.
 */
public class ExampleTestNG {

    @BeforeClass
    public void start(){
        System.out.println("Start testNG tests");
    }

    @Test
    public void level1Test11(){
        int[] array = {2,5,6,7,11,13};
        int[] expected = {5,7,11,13};

        Assert.assertTrue(Arrays.equals(Level1.printElementsWhereModulo(array, 2, 1), expected));
    }
    @Test
    public void level1Test12(){
        int[] array = {2,5,6,7,11,13};
        int[] expected = {5, 2, 7, 6, 13, 11};
        Assert.assertTrue(Arrays.equals(Level1.swapAdjacentElements(array), expected));
    }
    @Test
    public void level1Test13(){
        int[] array = {2,5,6,7,0,13};
        int[] expected = {2, 5, 6, 7, 0};
        Assert.assertTrue(Arrays.equals(Level1.printAllElementsBeforeZero(array), expected));
    }
    @Test
    public void level1Test14(){
        int[] array = {2,5,6,7,0,13};
        int expected = 8;
        Assert.assertTrue(Level1.getSumOfMinAndMaxElement(array) == expected);
    }
    @Test
    public void level1Test15(){
        int[] array = {2,5,6,7,0,13};
        int expected = 91;
        int mult = 6;
        Assert.assertTrue(Level1.getProdOfArrayElementsBiggerThan(array,mult) == expected);
    }
    @Test
    public void level1Test16(){
        int[] array = {2,5,-10,-17,0,9};
        int[] expected = {2, 5, 0, 0, 0, 9};
        Assert.assertTrue(Arrays.equals(Level1.changeElementsWhereAbsValueBiggerThanMax(array),expected));
    }
    @Test
    public void level1Test17(){
        int[] array = {2,5,-10, 17,0,9};
        //переделал сам медот на boolean, если отрицательные то false, если положительные то true
        Assert.assertTrue(Level1.printBiggestAbsProductionOfElements(array),"expected true, but return false, means that production of negative elements bigger then positive");
    }
    @Test
    public void level1Test18(){
        int[] array = {2, 5, 10, 17, 17, 9};
        int[] expected = {2, 5, 10, 0, 17, 9};
        Assert.assertTrue(Arrays.equals(Level1.changeFirstMaxElementByZero(array),expected));
    }
    @Test
    public void level1Test19(){
        int[] array = {42, 25, 10, 17, 17, 95};
        int[] expected = {25, 95};
        Assert.assertTrue(Arrays.equals(Level1.createArrayOfElementsThatEndOn(array,5),expected));
    }
}
