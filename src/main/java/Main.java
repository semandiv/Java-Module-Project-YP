import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numbersOfFriends;
        Calculator calc;

        System.out.println("Приветствую вас!");
        System.out.println("На сколько человек сегодня хотите разделить счёт?");

        while (true) if (scanner.hasNextInt()) {
            numbersOfFriends = scanner.nextInt();
            if (numbersOfFriends > 1) {
                System.out.println("Отлично! Делим счёт на " + numbersOfFriends + " человек!");
                calc = new Calculator(numbersOfFriends);
                calc.start();
                break;
            } else if (numbersOfFriends == 1) {
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