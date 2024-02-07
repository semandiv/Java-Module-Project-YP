import static java.lang.Math.floor;

import java.util.Locale;

public class Formatter {
    public static String currencyName (double value){
        String result;
        int floorValue = (int)floor(value);

        if ((floorValue != 11) && (floorValue%10 == 1)){
            result = "рубль";
        } else if (((floorValue%10 > 1)&&(floorValue%10 < 5)) && ((floorValue < 12) || (floorValue > 14))) {
            result = "рубля";
        } else {
            result = "рублей";
        }
        return result;
    }

    public static String doubleFormat (double value){
        return String.format(Locale.ENGLISH,"%.2f", value);
    }
}
