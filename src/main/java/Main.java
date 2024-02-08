import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        Calculator calc;

        System.out.println("Приветствую вас!");
        System.out.println("На сколько человек сегодня хотите разделить счёт?");

        //Проверяем, что введено правильное значение числа друзей
        while (true) if (scanner.hasNextInt()) {
            int numbersOfFriends = scanner.nextInt();

            //если число друзей верного формата, запускаем калькулятор и весь процесс
            if (numbersOfFriends > 1) {
                System.out.println("Отлично! Делим счёт на " + numbersOfFriends + " человек!");
                calc = new Calculator(numbersOfFriends, scanner);
                calc.start();
                break;
            } else if (numbersOfFriends == 1) {//если указал число 1, то выдаем соответствующее уведомление и завершаем программу
                System.out.println("Вам не нужно делить счёт, вы оплачиваете его полностью сами.");
                break;
            } else {
                System.out.println("Количество друзей не может быть меньше или равным 0. Укажите положительное целое число:");
                scanner.nextLine();
            }
        } else {
            System.out.println("Введенное значение не является целым числом. Повторите ввод:");
            scanner.nextLine();
        }

        scanner.close();
    }
}