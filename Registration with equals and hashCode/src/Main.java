import java.util.Objects;
import java.util.Scanner;

class User {
    private String login;
    private String password;
    private String name;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getInfo() {
        String pass = "";
        for (int i = 0; i < password.length(); i++) {
            pass += "*";
        }
        return this.name + "  ( " + this.login + " " + pass + " ) ";
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}


public class Main {

    static public boolean checkEquals(User[] users, User user) {
        for (int i = 0; i < users.length; i++) {

            if (users[i].equals(user)) {
//                users[users.length-1] = null;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String action;
        String name = null;
        String login = null;
        String password = null;
        String repeadPassword = null;
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        User[] users = new User[100];

        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("1 - Sign in");
            System.out.println("2 - Registration");
            System.out.println("3 - Print Users");
            System.out.println("4 - Exit");
            action = scanner.nextLine();

            if (action.equals("1")) {

                System.out.println("Sign in");
                scanner = new Scanner(System.in);
                boolean checkInput = true;
                while (checkInput) {
                    System.out.println("Enter Login : ");
                    login = scanner.nextLine();
                    System.out.println("Enter Password : ");
                    password = scanner.nextLine();
                    if (login.trim().isEmpty() || password.trim().isEmpty()) {
                        System.out.println("Поля не должны быть пустыми!");
                    } else checkInput = false;
                }

                boolean isSignIn = false;
                int user = 0;
                for (int i = 0; i < index; i++) {

                    if (users[i].getPassword().equals(password) &&
                            users[i].getLogin().equals(login)) {
                        System.out.println("Здравствуйте " + users[i].getName() + ". Dobro pojolovat v proqramu.");
                        isSignIn = true;
                        user = i;
                        break;
                    }

                }
                if (isSignIn == false || index == 0) {
                    System.out.println("Не правильно введен логин или пароль!");
                }


                while (isSignIn) {
                    scanner = new Scanner(System.in);
                    System.out.println("1 - Change login");
                    System.out.println("2 - Change password");
                    System.out.println("3 - Change name");
                    System.out.println("4 - Back");
                    System.out.println("5 - Exit");
                    String change = scanner.nextLine();

                    boolean cheking = true;
                    String changeLogin = null;

                    if (change.equals("1")) {
                        while (cheking) {
                            System.out.println("Введите новый логин:");
                            changeLogin = scanner.nextLine();
                            if (changeLogin.equals(users[user].getLogin())) {
                                System.out.println("Логин должен отличаться от прежнего.");
                            } else if (changeLogin.trim().isEmpty()) {
                                System.out.println("Поле не должно быть пустым!");
                            } else cheking = false;
                        }
                        System.out.print("Вы изменили логин \"" + users[user].getLogin() + "\" ");
                        users[user].setLogin(changeLogin);
                        System.out.println("на \"" + users[user].getLogin() + "\".");

                    } else if (change.equals("2")) {
                        String changePassword = null;
                        while (cheking) {
                            System.out.println("Введите новый пароль:");
                            changePassword = scanner.nextLine();
                            if (changePassword.equals(users[user].getPassword())) {
                                System.out.println("Пароли должны быть разными!");
                            } else if (changePassword.trim().isEmpty()) {
                                System.out.println("Поле не должно быть пустым!");
                            } else cheking = false;
                        }
                        System.out.print("Вы изменили пароль \"" + users[user].getPassword() + "\" ");
                        users[user].setPassword(changePassword);
                        System.out.println("на \"" + users[user].getPassword() + "\".");

                    } else if (change.equals("3")) {
                        String changeName = null;
                        while (cheking) {
                            System.out.println("Введите новое имя:");
                            changeName = scanner.nextLine();
                            if (changeName.equals(users[user].getName())) {
                                System.out.println("Имя должно отличаться от прежнего.");
                            } else if (changeName.trim().isEmpty()) {
                                System.out.println("Поле не должно быть пустым!");
                            } else cheking = false;
                        }
                        System.out.print("Вы изменили имя \"" + users[user].getName() + "\" ");
                        users[user].setName(changeName);
                        System.out.println("на \"" + users[user].getName() + "\".");

                    } else if (change.equals("4")) {
                        break;

                    } else if (change.equals("5")) {
                        System.out.println("Вы точно хотите выйти?\n" +
                                "1 -> ДА.\n" +
                                "2 -> НЕТ.");
                        while (cheking) {
                            switch (scanner.nextLine()) {
                                case "1":
                                    System.exit(0);
                                    break;
                                case "2":
                                    cheking = false;
                                    break;
                                default:
                                    System.out.println("Вы ввели не верно!");
                            }
                        }


                    } else {
                        System.out.println("Error enter number");
                    }
                }
            } else if (action.equals("2")) {
                boolean checkingEmpty = true;
                while (checkingEmpty) {
                    System.out.println("Registration");
                    scanner = new Scanner(System.in);
                    System.out.println("Enter Login : ");
                    login = scanner.nextLine();
                    System.out.println("Enter Name : ");
                    name = scanner.nextLine();
                    System.out.println("Enter Password : ");
                    password = scanner.nextLine();
                    System.out.println("Enter Repeat Password : ");
                    repeadPassword = scanner.nextLine();
                    if (login.trim().isEmpty() || name.trim().isEmpty() || password.trim().isEmpty() || repeadPassword.trim().isEmpty()) {
                        System.out.println("Поля не могут быть пустыми");
                    }
                    checkingEmpty = false;
                }
                if (repeadPassword.equals(password)) {
                    User user = new User(login, password, name);
                    users[index] = user;
                    index++;
                    if (checkEquals(users, user)) {
                        System.out.println("Такой логин уже имеется");
                    } else System.out.println("Успешная регистрация");

//    static public boolean checkEquals(User[] users, User user) {
//        for (int i = 0; i < users.length; i++) {
//            if (users[i].equals(user)) {
//                return true;
//            }
//        }
//          return false;
//    }


//                    for (int i = 0; i < index; i++) {
//                        if (users[i].equals(users[i + 1])) {
//                            System.out.println("Такой пользователь уже имеется");
//                            users[i + 1] = null;
//                        } else System.out.println("Успешная регистрация");
//                        break;
//                    }

                } else System.out.println("Пароли не совпадают.");


            } else if (action.equals("4")) {
                System.out.println("Bye bye");
                break;
            } else if (action.equals("3")) {
                if (index > 0) {
                    System.out.println("Print Users");
                    for (int i = 0; i < index; i++) {
                        if (users[i] == null) {
                            break;
                        } else System.out.println(users[i].getInfo());
                    }
                } else {
                    System.out.println("Users empty");
                }

            } else {
                System.out.println("Error enter number");
            }
        }
    }
}


//import java.util.Objects;
//
//public class Main {
//    public static void main(String[] args){
////String v = new String("BA");
////        String a = v;
////        String b = "BA";
////        String u = "GAdwjdn";
////
////        if(a==v){
////            System.out.println("YES");
////        }else System.out.println("NO");
////        System.out.println(v.hashCode() + " " + a.hashCode() + " " + b.hashCode() + " " + u.hashCode());
//
//
//    Test test = new Test(34,"Suleyman");
//    Test test1 = new Test(80,"Muhukl");
//    Test test2 = new Test(34,"Suleyman");
//     if(test.equals(test2)){
//         System.out.println("YES");
//     }else System.out.println("NO");
//        System.out.println("1: " + test .hashCode() + " \n2: " + test1.hashCode() + " \n3: " + test2.hashCode());
//
//
//
//    }
//}
//class Test{
//    int age;
//    String name;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Test test)) return false;
//        return age == test.age && Objects.equals(name, test.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(age, name);
//    }
//
//    public Test(int age, String name) {
//        this.age = age;
//        this.name = name;
//
//
//
//
//
//
//
//
//
//    }
//}