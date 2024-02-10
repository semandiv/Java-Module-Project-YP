import java.util.Scanner;

public class Friends {

    public static int enterFriends(Scanner scanner){
        System.out.println("Приветствую вас!");
        System.out.println("На сколько человек сегодня хотите разделить счёт?");
        int numbersOfFriends;
        //Проверяем, что введено правильное значение числа друзей
        while (true) if (scanner.hasNextInt()) {
            //если число друзей верного формата, запускаем калькулятор и весь процесс
            numbersOfFriends = scanner.nextInt();
            if (numbersOfFriends > 1) {
                System.out.println("Отлично! Делим счёт на " + numbersOfFriends + " друзей!");
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
        return numbersOfFriends;
    }
}
