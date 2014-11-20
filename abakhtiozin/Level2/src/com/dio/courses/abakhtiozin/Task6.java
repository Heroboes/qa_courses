package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 13.10.2014.
 */

//Дана строка с набором операций. Написать метод, который будет рассчитывать результат
//выполнения всех операций, учитывая приоритет операций. Операции только +,-,*,/. Например:
//       получаем на вход «2+5+9*10+10/5-12», возвращаем 87.

public class Task6 {

    private static boolean isOperation(char symbol){
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/';
    }

    private static int calculate(){
        return 1;
    }


    public static void main(String[] args) {
        String expression = "2+5+9*10+10/5-12";
        char[] expressionChar = Task5.convertStringToCharArray(expression);
        int countOfOperations = 0;
        for (int i = 0; i < expressionChar.length; i++){
            if (isOperation(expressionChar[i])){
                countOfOperations++;
            }
        }

        int[] numericArray = new int[countOfOperations+1];
        char[] operationArray = new char[countOfOperations+1];




    }

}
