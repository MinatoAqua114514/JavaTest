package com.Lin;
import java.lang.Math;
public class Line {
    /*计算num1和num2的算式*/
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("除数不能为0");
                }
            case '√':
                return Math.sqrt(num1);
            case '^':
                return Math.pow(num1, num2);
            default:
                throw new IllegalArgumentException("无效的操作符");
        }
    }
    /* "方法"输出算式和结果 */
    public static void printCalculation(int num1, int num2, char operator) {
        if (operator == '√')
            System.out.println("sqrt (" + num1 + ")" + " = " + calculate(num1, num2, operator));
        else if (operator == '^') {
            System.out.println("pow (" + num1 + "," + num2 + ")" + "=" + calculate(num1, num2, operator));
        } else
            System.out.println(num1 + " " + operator + " " + num2 + " = " + calculate(num1, num2, operator));
    }
}