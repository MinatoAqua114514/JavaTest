package com.Lin;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.text.*;
import java.io.*;

public class Test_IO {
    public static void main(String[] args) {
        /*生成两个范围在0-9的随机数*/
        Random random = new Random();
        int num1 = random.nextInt(10); // 生成0到9之间的随机数
        int num2 = random.nextInt(10); // 生成0到9之间的随机数
        char[] operators = {'+', '-', '*', '/', '√', '^'}; //'+', '-', '*', '/', '√', '^',6种操作符
        List<String> resultList = new ArrayList<>();
        String calculationResult;
        for (char operator : operators) {
            /*输出6行算式结果*/
            Line.printCalculation(num1, num2, operator);
            /*将6组算式的输出结果add到List中*/
            if (operator == '√')
                calculationResult = "sqrt (" + num1 + ")" + " = " + Line.calculate(num1, num2, operator);
            else if (operator == '^') {
                calculationResult = "pow (" + num1 + "," + num2 + ")" + " = " + Line.calculate(num1, num2, operator);
            } else
                calculationResult = num1 + " " + operator + " " + num2 + " = " + Line.calculate(num1, num2, operator);
            resultList.add(calculationResult);
            num1 = (int) (random.nextDouble() * 10);// 生成新的随机数
            num2 = (int) (random.nextDouble() * 10);// 生成新的随机数
        }
        /*输出当前时间*/
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
        String currentDate = ft.format(dNow);
        System.out.println("当前时间为: " + currentDate);
        /*将当前时间字符串add到List中*/
        resultList.add(currentDate);
        System.out.println("\n以下为遍历结果：");
        /*遍历List*/
        for (String result : resultList) {
            System.out.println(result);
        }
        //使用Java I/O 进行文件写入，将每一行输出到output.txt中
        try {
            FileWriter writer = new FileWriter("output.txt");
            for (String result : resultList) {
                writer.write(result + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}