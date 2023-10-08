import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            try {
                System.out.print("Введите выражение: ");
                Scanner scan = new Scanner(System.in);
                String virajenie = scan.nextLine();
                String[] arrNumber;

                if (virajenie.contains("-")) {
                    arrNumber = virajenie.split("-");
                    System.out.println(Integer.parseInt(arrNumber[0]) - Integer.parseInt(arrNumber[1]));
                } else if (virajenie.contains("+")) {
                    arrNumber = virajenie.split("\\+");
                    System.out.println(Integer.parseInt(arrNumber[0]) + Integer.parseInt(arrNumber[1]));
                } else if (virajenie.contains("*")) {
                    arrNumber = virajenie.split("\\*");
                    System.out.println(Integer.parseInt(arrNumber[0]) * Integer.parseInt(arrNumber[1]));
                } else if (virajenie.contains("/")) {
                    arrNumber = virajenie.split("/");
                    System.out.println(Integer.parseInt(arrNumber[0]) / Integer.parseInt(arrNumber[1]));
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Ввод должен осуществляться только цифрами!");
            }
        }

    }

}