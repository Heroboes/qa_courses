package com.dio.courses.abakhtiozin.Level2;

import com.dio.courses.abakhtiozin.Task5;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by A.Bakhtiozin on 22.10.2014.
 */
public class TestsLevel2 {

    @Test(dataProvider="data provider for test1")
    public void test1Level2(int[] array, int[] expected){
        Assert.assertTrue(Arrays.equals(Task1.sortArray(array),expected));
    }

    @Test(dataProvider="data provider for test2")
    public void test2Level2(int monthN, String expected){
        Assert.assertTrue(Task2.getMonth(monthN).equals(expected), "TEST2 FAIL! Expected " + expected + " returned " + Task2.getMonth(monthN));
    }

    @Test(dataProvider="data provider for test3")
    public void test3Level3(char[] array, char[] expected){
        Assert.assertTrue(Arrays.equals(Task3.toLowerCase(array),expected));
    }

    @Test(dataProvider="data provider for test4")
    public void test4Level3(int given, int[] expected){
        int[] givenArray = Task4.getPrimeNumbers(given);
        Assert.assertTrue(Arrays.equals(givenArray,expected));
    }

    @Test(dataProvider="data provider for test5")
    public void test5Level3(String mainString, String substring, boolean expected){
        Assert.assertTrue((Task5.isSubString(mainString,substring) == expected),"Expected " + expected + " but return " + Task5.isSubString(mainString,substring));
    }



    @DataProvider(name="data provider for test1")
    public Object[][] createDataForTest1() {
        return new  int[][][] {
                {{0, 1, 2, 7, 4, 5}, {0, 1, 2, 4, 5, 7}},
                {{0, 3, 2, 4, 5, 7}, {0, 2, 3, 4, 5, 7}}
        };
    }

    @DataProvider(name="data provider for test2")
    public Object[][] createDataForTest2() {
        return new  Object[][] {
                {2, "February"},
                {3, "March"},
                {4, "April"}
        };
    }

    @DataProvider(name="data provider for test3")
    public Object[][] createDataForTest3() {
        return new  char[][][] {
                {{'a', 'Z', 'E', 'd'}, {'a', 'z', 'e', 'd'}},
                {{'H', 'I', 'n', 'P'}, {'h', 'i', 'n', 'p'}}
        };
    }

    @DataProvider(name="data provider for test4")
    public Object[][] createDataForTest4() {
        return new  Object[][] {
                {23, new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23}},
                {53, new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53}},
                {17, new int[]{2, 3, 5, 7, 11, 13, 17}}
        };
    }

    @DataProvider(name="data provider for test5")
    public Object[][] createDataForTest5() {
        return new Object[][] {
                {"abrakadabra", "adabra", true},
                {"havrahas", "deko", false}
        };
    }
}
