import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counterOfFriends = Friends.enterFriends(scanner);
        if (counterOfFriends > 1){
            Calculator calc = new Calculator(counterOfFriends,scanner);
            calc.start();
        }
        scanner.close();
    }
}