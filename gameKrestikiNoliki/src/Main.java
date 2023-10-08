
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static char[] arr = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}; // Массив для игры!
    public static char[] example = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}; // Массив для образца!
    public static int count1 = 0; // Счетчик для ничьи.
    public static boolean position = true; // переменная для перескока на игрока.
    public static int count2 = 0; // счетчик для выбора Х или 0.

    public static void main(String[] args) {
        System.out.println("** Добро пожаловать в игру крестики нолики **\n" +
                "Нажмите: 1 -> Для запуска игры.\n" +
                "         2 -> Что бы открыть правила.");

        choiceOfMode();
    }

    public static void choiceOfMode() {

        Scanner scan = new Scanner(System.in);
        try {
            int mode = scan.nextInt();

            if (mode <= 0 || mode >= 3) {
                System.out.println("Введите: 1 -> Для начало игры.\n" +
                        "         2 -> Что бы ознакомиться с правилами!");
                choiceOfMode();

//                                                        Выбор фигуры для первого хода!

            } else if (mode == 1) {
                while (count2 == 0) {
                    System.out.println("\'Х\' или \'0\' будет начинать первым?\n" +
                            "Нажмите 1 -> Х\n" +
                            "        2 -> 0");
                    count2++;
                    int vvod = scan.nextInt();
                    if(vvod <= 0 || vvod >= 3) {
                        System.out.println("Нажмите  1 -> что бы играть за \'X\'\n" +
                                           "         2 -> что бы играть за \'0\'");

                    }else if (vvod == 1) {
                        mode1();
                    }else if (vvod == 2) {
                        position = false;
                        mode1();
                    }
                }mode1();

            } else rules();
        } catch (InputMismatchException ime) {
            System.out.println("Вы ввели что то не то! Нажмите: 1 -> Начать играть.\n" +
                    "                                2 -> Ознакомиться с правилами.");
            choiceOfMode();
        }
    }

    public static void mode1() {
        int count = 0;
        int k = 0;
//                                                                    Сетка!
        for (int j = 0, g = 0; j <= 2; j++) {
            for (int i = 1; i <= 32; i++) {
                if (i == 3 || i == 8 || i == 13) {
                    System.out.print(arr[k]);
                    k++;
                }
                if (i == 18 || i == 23 || i == 28) {
                    System.out.print(example[g]);
                    g++;
                }
                if (i % 5 == 0 && i != 30) {
                    System.out.print("|");
                } else System.out.print(" ");
            }
            if (count < 2)
                System.out.print("\n ––––––––––––––– | –––––––––––––––\n");
            count++;
        }

        System.out.println("\n");
//                                                                Методы победы!
        player1Winner();
        player2Winner();

//                                                                Ничья!
        if (count1 == arr.length) {
            System.out.println("Ничья.\n Конец игры!");
            System.exit(0);
        }

//                                                                Перескок на игрока!
        if (position == true) {
            player1();
        }
        if (position == false) {
            player2();
        }
    }

    //                                                           Player 1
    public static void player1() { // Х
        Scanner scan = new Scanner(System.in);

        switch (count1) {
            case 0 -> System.out.println("Выберите на какое место хотите поставить Х");
        }
        System.out.println("Ход игрока Х");
        int placeX = scan.nextInt();
        if (placeX < 1 || placeX > 9) {
            System.out.println("Не правильно указано место! Пожалуйста укажите место от 1 до 9");
            player1();
        }
        if (arr[placeX - 1] != ' ') {
            System.out.println("Это место занято!");
            player1();
        }
        switch (placeX) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9 -> arr[placeX - 1] = 'X';
        }
        count1++;
        position = false;
        mode1();
    }

    //                                                            Player 2
    public static void player2() { // 0
        System.out.println("Ход игрока 0");

        switch (count1) {
            case 1 -> System.out.println("Выберите на какое место хотите поставить 0");
        }
        Scanner scan = new Scanner(System.in);
        int place0 = scan.nextInt();
        if (place0 < 1 || place0 > 9) {                       //разобраться с условием от 0 до 8!
            System.out.println("Не правильно указано место! Пожалуйста укажите место от 1 до 9");
            player2();
        }
        if (arr[place0 - 1] != ' ') {
            System.out.println("Это место занято!");
            player2();
        }
        switch (place0) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9 -> arr[place0 - 1] = '0';
        }
        count1++;
        position = true;
        mode1();
    }

    public static void player1Winner() {
        if (arr[0] == 'X' && arr[1] == 'X' && arr[2] == 'X' ||
                arr[3] == 'X' && arr[4] == 'X' && arr[5] == 'X' ||
                arr[6] == 'X' && arr[7] == 'X' && arr[8] == 'X' ||
                arr[0] == 'X' && arr[3] == 'X' && arr[6] == 'X' ||
                arr[1] == 'X' && arr[4] == 'X' && arr[7] == 'X' ||
                arr[2] == 'X' && arr[5] == 'X' && arr[8] == 'X' ||
                arr[0] == 'X' && arr[4] == 'X' && arr[8] == 'X' ||
                arr[6] == 'X' && arr[4] == 'X' && arr[2] == 'X') {
            System.out.println("Победил игрок Х.");
            System.exit(0);
        }
    }

    public static void player2Winner() {
        if (arr[0] == '0' && arr[1] == '0' && arr[2] == '0' ||
                arr[3] == '0' && arr[4] == '0' && arr[5] == '0' ||
                arr[6] == '0' && arr[7] == '0' && arr[8] == '0' ||
                arr[0] == '0' && arr[3] == '0' && arr[6] == '0' ||
                arr[1] == '0' && arr[4] == '0' && arr[7] == '0' ||
                arr[2] == '0' && arr[5] == '0' && arr[8] == '0' ||
                arr[0] == '0' && arr[4] == '0' && arr[8] == '0' ||
                arr[6] == '0' && arr[4] == '0' && arr[2] == '0') {
            System.out.println("Победил игрок 0.");
            System.exit(0);
        }
    }

    public static void rules() {
        System.out.println(" _______________________________________________________________________________________________\n" +
                "|                                  Правила игры \"Крестики нолики\".                              |\n" +
                "| В эту игру может играть 2 игрока.                                                             |\n" +
                "| Начало игры начинается с выбора игроками позиции 'X' или '0' для первого хода.                |\n" +
                "| В консоли будет выведено две сетки: Левая - игровая, правая - образец.                        |\n" +
                "| Нажатиями определенных цифр с клавиатуры заполняются пустые места в игровой сетке.            |\n" +
                "| Для определения места воспользуйтесь образцом!                                                |\n" +
                "| Побеждает тот кто первее выставит одно из направлений (вертикаль, горизонталь, диагональ)     |\n" +
                "| крестиком или ноликом.                                                                        |\n" +
                " –––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 для того что бы начать играть! ");

        while (true) {
            int input = scanner.nextInt();
            if (input != 1) {
                System.out.println("Введите 1.");
            } else mode1();
        }
    }

}
