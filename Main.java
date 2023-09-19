package lesson_5.homework5.task01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создан обьект сканер для получения данных от пользователя
        Scanner tDobleScanner = new Scanner(System.in);
        // Создан обьект модели для получения данных от пользователя
        CalculatorModel model = new CalculatorModel();
        // Создан обьект вьюшки для получения данных от пользователя
        CalculatorView view = new CalculatorView();
        // Создан обьект пресентера
        CalculatorController controller = new CalculatorController(model, view);

        while (controller.exitflag) {
            view.printMenu();
            Integer choice = tDobleScanner.nextInt();
            controller.userChoise(choice);
            if (controller.innerflag) {
                controller.calculate(tDobleScanner);
            }
        }
        tDobleScanner.close();
    }
}