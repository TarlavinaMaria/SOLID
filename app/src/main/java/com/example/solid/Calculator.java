package com.example.solid;

// Класс, реализующий логику калькулятора
public class Calculator {
    public double calculate(double num1, double num2, Operation operation) throws ArithmeticException {
        switch (operation) {
            case ADD:
                return num1 + num2;
            case SUBTRACT:
                return num1 - num2;
            case MULTIPLY:
                return num1 * num2;
            case DIVIDE:
                if (num2 == 0) {
                    throw new ArithmeticException("Нельзя делить на ноль");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция");
        }
    }
}
