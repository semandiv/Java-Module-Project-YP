//Calculator описывает объект калькулятора, который запрашивает и сохраняет объекты Product
//от пользователя и выводит список и сумму товаров

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private final int numberOfFriends; //количество друзей, на которых делим счет
    private final Scanner scanner; //объект Scanner инициализируется в конструкторе, чтобы не плодить лишние объекты в памяти.
    private final ArrayList<Product> products = new ArrayList<>();

    Calculator(int count, Scanner scanner) {
        this.numberOfFriends = count; //получаем количество друзей
        this.scanner = scanner; //получаем ссылку на уже существующий объект Scanner
    }

    public void start() { //основной метод класса, собирает данные и выводит результат
        String name; //название товара
        double price; //цена товара

        //пока пользователь не введет слово "завершить", собираем данные о товарах
        do {
            scanner.nextLine(); //добавлено для обнуления сканера, если предыдущий ввод был с ошибкой
            System.out.println("Введите название товара:");
            name = scanner.next(); //ввод строки не требует проверки (теоретически можно заморочиться, но выходит за рамки ТЗ)

            //тут запрашиваем цену товара и ждем ввода корректного значения
            while (true) {
                scanner.nextLine(); //добавлено для обнуления сканера, если предыдущий ввод был с ошибкой
                System.out.println("Введите стоимость товара (рубли.копейки, цифрами, через точку):");
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    if (price > 0.0) {
                        break;
                    } else {
                        System.out.println("Стоимость товара не может быть отрицательной или равной нулю.");
                    }
                } else {
                    System.out.println("Это не число. Введите корректное значение - рубли.копейки, цифрами. Например, 2.5");
                }
            }

            products.add(new Product(name,price)); //добавляем товар в коллекцию
            System.out.println("Новый товар "
                    + name
                    + " стоимостью "
                    + Formatter.doubleFormat(price)
                    + " "
                    + Formatter.currencyName(price) + " успешно добавлен.");
            System.out.println("Общая стоимость добавленных товаров: "+Formatter.doubleFormat(sumOrder(products)) +" "+ Formatter.currencyName(sumOrder(products)));

            System.out.println("Хотите добавить еще один товар?");
        } while (!scanner.next().trim().equalsIgnoreCase("завершить"));

        //выводим итоги всей работы калькулятора, if добавил скорее для порядка, так как к этому моменту не вижу варианта, что коллекция пуста
        if (products.size() > 0){
            printProductsList(products);
            System.out.println("Общая сумма чека составляет "+Formatter.doubleFormat(sumOrder(products)) +" "+ Formatter.currencyName(sumOrder(products)));
            System.out.println("Каждый ваш друг должен заплатить "
                    +Formatter.doubleFormat(getAmountForFriend(numberOfFriends,products))
                    + " "+ Formatter.currencyName(getAmountForFriend(numberOfFriends,products)));
        } else {
            System.out.println("По неизвестной причине ваш список товаров пуст.\nЗапустите приложение повторно и внесите в список товары и их цену.");
        }

    }

    //Метод суммирует стоимость всех товаров
    private double sumOrder(ArrayList<Product> products){
        double result = 0.0;
        if (products.size() > 0) {
            for (Product currentProduct : products) {
                result = result + currentProduct.productPrice;
            }
        } else {
            System.out.println("Ваш счёт пуст, суммировать нечего.");
        }
        return result;
    }

    //Метод выводит сумму, которую должен заплатить каждый участник вечеринки
    private double getAmountForFriend(int numbers, ArrayList<Product> products){
        if (sumOrder(products) > 0.0) {
            return sumOrder(products) / numbers;
        } else {
            System.out.println("У вас нулевой счёт, делить нечего.");
            return 0.0;
        }
    }

    //Метод выводит список всех сохраненных продуктов и их стоимость построчно
    private void printProductsList(ArrayList<Product> products){
        if (products.size() > 0) {
            System.out.println("Добавленные товары:");
            for (Product currentProduct: products) {
                System.out.println(currentProduct.productName
                        + " стоимостью "
                        +Formatter.doubleFormat(currentProduct.productPrice)
                        +" "
                        +Formatter.currencyName(currentProduct.productPrice));
            }
        }
    }
}
