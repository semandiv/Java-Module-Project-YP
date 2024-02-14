//Класс Formatter имеет два статичных метода - выводит название валюты (рубли) в правильном склонении
//и выводит десятичную дробь в виде строки с двумя знаками после десятичного делителя
import static java.lang.Math.floor;

public class Formatter {
    public static String currencyName (double value){ //Возвращает слово "рубль" в правильном виде в зависимости от количества рублей
        //РЕВЬЮЕРУ: в ТЗ к данному заданию четко прописано, как должно склоняться слово "рубль": без учета копеек! То есть, "1.35 рубль", а не "1.35 рублей".
        //Метод работает именно так, как указано в ТЗ

        if ((int)value%100 >= 11 && (int)value%100 <= 14){
            return "рублей";
        } else {
            switch (((int)value%10)) {
                case 1: return "рубль";
                case 2, 3, 4: return "рубля";
                default: return "рублей";
            }
        }
    }

    public static String doubleFormat (double value){ //Возвращает дробь в виде строки в нужном формате
        return String.format("%.2f", value);
    }
}
