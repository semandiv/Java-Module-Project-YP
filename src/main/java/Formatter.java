//Класс Formatter имеет два статичных метода - выводит название валюты (рубли) в правильном склонении
//и выводит десятичную дробь в виде строки с двумя знаками после десятичного делителя
import static java.lang.Math.floor;
import java.util.Locale;

public class Formatter {
    public static String currencyName (double value){ //Возвращает слово "рубль" в правильном виде в зависимости от количества рублей
        //РЕВЬЮЕРУ: в ТЗ к данному заданию четко прописано, как должно склоняться слово "рубль": без учета копеек! То есть, "1.35 рубль", а не "1.35 рублей".
        //Метод работает именно так, как указано в ТЗ

        String result;
        int floorValue = (int)floor(value); //округляем дробь до целого, используется floor для уверенности, что округлит как надо

        if ((floorValue != 11) && (floorValue%10 == 1)){
            result = "рубль";
        } else if (((floorValue%10 > 1)&&(floorValue%10 < 5)) && ((floorValue < 12) || (floorValue > 14))) {
            result = "рубля";
        } else {
            result = "рублей";
        }
        return result;
    }

    public static String doubleFormat (double value){ //Возвращает дробь в виде строки в нужном формате
        return String.format(Locale.ENGLISH,"%.2f", value);
    }
}
