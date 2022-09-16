package com.company;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number1 = 0;
        double number2 = 0;
        double result;
        char operator;
        System.out.println("Enter first number: ");
        try {
            number1 = Double.parseDouble(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }


        System.out.println("Enter second number: ");
        try {
            number2 = Double.parseDouble(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }


        System.out.print("\nEnter an operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);
        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                System.out.printf("Error! Enter correct operator");
                return;
        }
        System.out.print("\nThe result is equal to:\n");
        System.out.printf(number1 + " " + operator + " " + number2 + " = " + result);
    }
}
