package com.dio.courses.abakhtiozin.Level2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by AA on 08.10.2014.
 */

//Get month name by his number
// .
public class Task2 {

    public static String getMonth(int monthNubmer) {
        if (monthNubmer > 12 || monthNubmer < 1) {
            month = "no such month!";
        } else month = listOfMonth[monthNubmer - 1];
        return month;
    }

    private static String month;

    private static String[] listOfMonth = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    public static void main(String[] args) {
        System.out.print(getMonth(1));

    }
}
