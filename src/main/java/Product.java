//Класс Product описывает один товар с названием и стоимостью
public class Product {
    String productName; //название товара
    double productPrice; //стоимость товара в виде десятичного значения

    Product (String name, double price) {
       this.productName = name.trim(); //обрезаем лишние пробелы и инициализируем название продукта
       this.productPrice = price; //инициализируем цену продукта (без округления!)
    }
}
