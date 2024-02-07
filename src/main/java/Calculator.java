import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    private final int numberOfFriends;
    private final ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);

    Calculator(int count) {
        numberOfFriends = count;
    }

    public void start() {
        String name;
        double price;

        do {
            System.out.println("Введите название товара:");
            //scanner.nextLine();
            name = scanner.next();

            while (true) {
                System.out.println("Введите стоимость товара (рубли.копейки, цифрами):");
                //scanner.nextLine();
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    if (price > 0.0) {
                        break;
                    } else {
                        System.out.println("Стоимость товара не может быть отрицательной.");
                        scanner.nextLine();
                    }
                } else {
                    System.out.println("Это не число. Введите корректное значение - рубли.копейки, цифрами. Например, 2.5");
                    scanner.nextLine();
                }
            }

            Product newProduct = new Product(name, price);
            products.add(newProduct);
            System.out.println("Новый товар "
                    + newProduct.productName
                    + " стоимостью "
                    + Formatter.doubleFormat(newProduct.productPrice)
                    + " "
                    + Formatter.currencyName(newProduct.productPrice) + " успешно добавлен.");
            System.out.println("Общая стоимость добавленных товаров: "+Formatter.doubleFormat(sumOrder(products)) +" "+ Formatter.currencyName(sumOrder(products)));

            System.out.println("Хотите добавить еще один товар?");
        } while (!scanner.next().trim().equalsIgnoreCase("завершить"));

        printProductsList(products);
        System.out.println("Общая сумма чека составляет "+Formatter.doubleFormat(sumOrder(products)) +" "+ Formatter.currencyName(sumOrder(products)));
        System.out.println("Каждый ваш друг должен заплатить "
                +Formatter.doubleFormat(getAmountForFriend(numberOfFriends,products))
                + " "+ Formatter.currencyName(getAmountForFriend(numberOfFriends,products)));
    }

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

    private double getAmountForFriend(int numbers, ArrayList<Product> products){
        if (sumOrder(products) > 0.0) {
            return sumOrder(products) / numbers;
        } else {
            System.out.println("Ваш счёт пуст, делить нечего.");
            return 0.0;
        }
    }

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
