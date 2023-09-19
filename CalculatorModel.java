package lesson_5.homework5.task01;

//Класс реализующий бизнес модель
public class CalculatorModel {
    // Функция для выполнения сложения аргументов
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    // Функция для выполнения вычетания аргументов
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Функция для выполнения умножения аргументов
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Функция для выполнения деления аргументов
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}