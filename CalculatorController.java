package lesson_5.homework5.task01;

import java.util.LinkedList;
import java.util.Scanner;
/**
 * Класс пресентер для связи вьюшки и модели
 */
public class CalculatorController {
    /**
     * Поле для привязки бизнес модели к пресентеру
     */
    private CalculatorModel model;
    /**
     * Поле для привязки вьюера к пресентеру
     */
    private CalculatorView view;
    /**
     * Локальный линкед лист для сохранения истории последних операций
     */
    private LinkedList<String> log;
    /**
     * Логическая переменная для определения возможности доступа к вычеслениям на основании выобора соответствующего варианта в менью
     */
    public Boolean innerflag = false;
    /**
     * Логическая переменная для выхода из цикла вайл в майн, после соответствующего выбора варианта менью
     */
    public Boolean exitflag = true;

    /**
     * Конструктор Класса требующий привязки виью и модели
     * @param newModel аргумент класса CalculatorModel
     * @param newView аргумент класса CalculatorView
     */
    public CalculatorController(CalculatorModel newModel, CalculatorView newView) {
        model = newModel;
        view = newView;
        this.log = new LinkedList<String>();
    }

    /**
     * Функция реализующая математические вычесления и передачу информации в лог
     * @param sc аргумент сканер
     */
    public void calculate(Scanner sc) {
        double result;
        System.out.println("Введите первое число ");
        double num1 = sc.nextDouble();
        System.out.println(
                "Введите математический оператор \n[+] СлоЖить \n[-] Вычесть \n[*] Умно;ить\n[/] Разделить ");
        char operator = sc.next().charAt(0);
        System.out.println("Введите второе число ");
        double num2 = sc.nextDouble();

        try {
            switch (operator) {
                case '+':
                    result = model.add(num1, num2);
                    logingCalculations(num1, num2, operator, result);
                    break;
                case '-':
                    result = model.subtract(num1, num2);
                    logingCalculations(num1, num2, operator, result);
                    break;
                case '*':
                    result = model.multiply(num1, num2);
                    logingCalculations(num1, num2, operator, result);
                    break;
                case '/':
                    result = model.divide(num1, num2);
                    logingCalculations(num1, num2, operator, result);
                    break;
                default:
                    view.printError("Неверная операция");
                    return;
            }
            view.printResult(result);
            checkLogLenght(log);
            view.printStoryLog(log);

        } catch (ArithmeticException e) {
            view.printError(e.getMessage());
        }
    }

    /**
     * Функция ограничивающая длинну лога
     * @param list Лог
     */
    void checkLogLenght(LinkedList<String> list) {
        if (list.size() > 3) {
            list.removeFirst();
        }
    }

    /**
     * Функция для передачи данных вычесления в лог
     * @param num1 первое число
     * @param num2 второе число
     * @param operator математический оператор
     * @param result результат вычеслений
     */
    void logingCalculations(double num1, double num2, char operator, double result) {
        log.add('[' + Double.toString(num1) + " " + operator + " " + Double.toString(num2) + " = "
                + Double.toString(result) + ']');
    }

    /**
     * Функция реализующая выбор опций в меню
     * @param arg п.п. менью к которому ну;но обратится
     * @return возвращает логические переменные в зависимости от выбранного кейса.
     */
    boolean userChoise(int arg) {
        switch (arg) {
            case 1:
                return innerflag = true;
            case 2:
                view.printStoryLog(log);
                return innerflag = false;
            case 3:
                return exitflag = innerflag = false;
            default:
                return exitflag = false;
        }
    }

}