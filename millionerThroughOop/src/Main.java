import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static boolean checkOfUseFifty = true;
    public static boolean checkOfUseHallHelp = true;
    public static boolean checkUseCallOfFrienf = true;

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Добро пожаловать в игру \"Кто хочет стать миллионером\".");

        while (true) {
            System.out.println("Нажмите клавишу: 1 -> Запустить игру.\n" +
                    "                 2 -> Правила.");
            try {
                Scanner scan = new Scanner(System.in);
                switch (scan.nextInt()) {
                    case 1 -> game();
                    case 2 -> rules();
                }
            } catch (InputMismatchException ime) {
                System.out.println("Вы вводите буквы!");
            }
        }
    }


    public static void game() {

        int countForNextObject = 0;
        if (countForNextObject == 0) {
            countForNextObject++;

            Millionaire question1 = new Millionaire(new String[]{arrOfQuestion(0)},
                    new String[]{"Около 500", "Чуть более 1000", "Более 8000", "Не более 100"}, 3, "10 000");
            question1.callMethods();
        }

        if (countForNextObject == 1) {
            countForNextObject++;
            Millionaire question2 = new Millionaire(new String[]{arrOfQuestion(1)},
                    new String[]{"Фортран", "Планкалкюль", "Ада", "Паскаль"}, 2, "100 000");
            question2.callMethods();
        }
        if (countForNextObject == 2) {
            countForNextObject++;
            Millionaire question3 = new Millionaire(new String[]{arrOfQuestion(2)},
                    new String[]{"Для работ по искусственному интеллекту", "Для управления бытовыми приборами",
                            "Для реализации компьютерной модели вселенной", "Для управления роботами"}, 1, "250 000");
            question3.callMethods();
        }
        if (countForNextObject == 3) {
            countForNextObject++;
            Millionaire question4 = new Millionaire(new String[]{arrOfQuestion(3)},
                    new String[]{"Фортран и Паскаль ", "Ruby и Python",
                            "C++ и Java", "Php и HTML"}, 3, "500 000");
            question4.callMethods();
        }
        if (countForNextObject == 4) {
            countForNextObject++;
            Millionaire question5 = new Millionaire(new String[]{arrOfQuestion(4)},
                    new String[]{"C", "C#", "C++", "Java"}, 1, "1 000 000");
            question5.callMethods();
            System.exit(0);
        }
    }

    public static String arrOfQuestion(int index) {

        String[] questions = new String[5];
        questions[0] = "Вопрос 1: Сколько на данный момент существует языков программирования?";
        questions[1] = "Вопрос 2: Как называется первый в мире высокоуровневый язык программирования?";
        questions[2] = "Вопрос 3: Для чего Джоном Маккарти был создан язык программирования Лисп?";
        questions[3] = "Вопрос 4: К синтаксису каких языков программирования наиболее близок синтаксис C#?";
        questions[4] = "Вопрос 5: С какого языка началась традиция использования фразы «Hello, world!» " +
                "в самой первой программе при изучении нового языка программирования?";
        return questions[index];
    }

    public static void rules() {

        System.out.println("Правила игры:\n" +
                "В игре задается пять вопросов. На каждый правильно отвеченный вопрос вы получите сумму денег:" +
                "\n1 - вопрос 10 000р" +
                "\n2 - вопрос 100 000р" +
                "\n3 - вопрос 250 000р " +
                "\n4 - вопрос 500 000р " +
                "\n5 - вопрос 1 000 000р\n");
        System.out.println("У вас будет возможность использовать подсказки. Нажатием определенной кнопки вы вызываете подсказки:\n" +
                "5 -> \"50/50\",\n" +
                "6 -> \"Помощь зала\",\n" +
                "7 -> \"Звонок другу\".\n" +
                "А так же можно использовать их всех в одном вопросе!\n");
        System.out.println("Нажмите 0 для выхода в главное меню!");
        while (true) {
            try {
                Scanner scan = new Scanner(System.in);
                if (scan.nextInt() == 0) {
                    break;
                } else System.out.println("Нажмите 0 для выхода!");

            } catch (InputMismatchException ime) {
                System.out.println("dsdjnfksndfkvj");
            }
        }
    }


}

class Millionaire {

    private String[] question;
    private String[] answersOption;
    private int correctAnswer;
    private String winningMoney;

    public void setCorrectAnswer(int correctAnswer) {
        if (correctAnswer > 0 && correctAnswer <= 4) {
            this.correctAnswer = correctAnswer;
        } else {
            System.out.println("Вы указали не правильное значение в аргументе объекта (Для correctAnswer)");
        }
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getQuestion() {
        return question;
    }

    public String[] getAnswer() {
        return answersOption;
    }

    public Millionaire(String[] question, String[] answer, int correctAnswer, String winningMoney) {
        this.question = question;
        this.answersOption = answer;
        this.setCorrectAnswer(correctAnswer);
        this.winningMoney = winningMoney;
    }

    public void printAnswerOptions() {
        for (int i = 0; i < getAnswer().length; i++) {
            System.out.println((1 + i) + ") " + getAnswer()[i]);
        }
    }

    public void printAnswer() {
        while (true) {
            try {
                Scanner scan1 = new Scanner(System.in);
                int index = scan1.nextInt();
                if (index >= 1 && index <= 4) {
                    if (getCorrectAnswer() == index) {
                        System.out.println("Да это правильный ответ, у вас " + winningMoney + " рублей.\n");
                        break;
                    } else {
                        System.out.println("Это не правильный ответ. Вы проиграли!");
                        System.exit(0);
                    }
                } else if (index == 5) {
                    fifty(correctAnswer);
                } else if (index == 6) {
                    hallHelp();
                } else if (index == 7) {
                    callToFriend();

                } else System.out.println("Нету такого варианта ответа");

            } catch (InputMismatchException ime) {
                System.out.println("Вы вводите буквы!");
            }
        }

    }

    public void callMethods() {
        System.out.println(Arrays.toString(this.getQuestion()));
        this.printAnswerOptions();
        this.printAnswer();

    }

    public void fifty(int correctAnswer) {
        if (Main.checkOfUseFifty) {
            System.out.println("Вы использовали подсказку \"50/50\".");
            System.out.println("Варианты ответa: \n" + correctAnswer + ".\n"
                    + random(correctAnswer) + ".");
        } else System.out.println("Подсказка 50/50 уже использована!");
        Main.checkOfUseFifty = false;
    }

    public void hallHelp() {
        if (Main.checkOfUseHallHelp) {
            System.out.println("Вы воспользовались подсказкой \"Помощь зала\".");
            System.out.println("Зал подсказывает вариант ответа: " + random(correctAnswer));
        } else
            System.out.println("Подсказка \"Помощь зала\" уже использована!");
        Main.checkOfUseHallHelp = false;
    }

    public void callToFriend() {
        if (Main.checkUseCallOfFrienf) {
            System.out.println("Вы воспользовались подсказкой \"звонок другу\".");
            System.out.println("Друг подсказывает вариант ответа: " + random(correctAnswer));
        } else
            System.out.println("Подсказка \"Звонок другу\" уже использована!");
        Main.checkUseCallOfFrienf = false;
    }

    public int random(int correctAnswer) {
        Random rand = new Random();
        int number = 0;
        while (true) {
            number = rand.nextInt(1, 5);
            if (correctAnswer == number) {
                continue;
            } else break;
        }
        return number;
    }

}
