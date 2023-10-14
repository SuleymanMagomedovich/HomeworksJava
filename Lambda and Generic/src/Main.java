
import java.util.*;
import java.util.function.Predicate;

class Students {
    private String surname;
    private String name;
    private char sex;
    private int age;
    private double avgGrade;
    private String group;

    public Students(String surname, String name, char sex, int age, double avgGrade, String group) {
        this.surname = surname;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.avgGrade = avgGrade;
        this.group = group;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Students() {
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "surname: " + surname +
                ", name: " + name +
                ", sex: " + sex +
                ", age: " + age +
                ", avgGrade: " + avgGrade +
                ", group: " + group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return Objects.equals(surname, students.surname) && Objects.equals(name, students.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }
}

class Main {
    public static boolean checkStudentsSurname = true;
    public static boolean checkStudentsName = false;

    public static void findStudents(ArrayList<Students> arr, Predicate<Students> pr1, Predicate<Students> pr2) {
        for (Students st : arr) {
            if (pr1.test(st)) {
                checkStudentsSurname = false;
                if (pr2.test(st)) {
                    System.out.println(st.toString());
                }else checkStudentsName = true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Доска студентов: \n");
        for (int i = 0; i < dataBaseOfStudents().size(); i++) {
            System.out.println(dataBaseOfStudents().get(i).getSurname() + " " + dataBaseOfStudents().get(i).getName() + ".");
        }
        System.out.println("\nВведите фамилию и имя студента для просмотра его информации.");
        while (true) {
            System.out.println("\nФамилия: ");
            Scanner scan = new Scanner(System.in);
            String surnameStudent = scan.nextLine();
            System.out.println("Имя:");
            String nameStudent = scan.nextLine();
            findStudents(dataBaseOfStudents(), (Students student) -> {
                return student.getSurname().equalsIgnoreCase(surnameStudent);
            }, (Students student) -> {
                return student.getName().equalsIgnoreCase(nameStudent);
            });
            if(checkStudentsSurname){
                System.out.println("Не найден студент с такой фамилией");
            }
            if(checkStudentsName){
                System.out.println("Не найден студент с таким именем");
            }
        }
    }

    public static ArrayList<Students> dataBaseOfStudents() {

        Students student1 = new Students("Смирнов", "Николай", 'M', 33, 2.2, "ТМ121 – Технология машиностроения");
        Students student2 = new Students("Вырвыхвост", "Анастасия", 'F', 28, 7.7, "ПБ122, – Пожарная безопасность");
        Students student3 = new Students("Алибеков", "Ахмед", 'M', 30, 4.3, "ПБ122, – Пожарная безопасность");
        Students student4 = new Students("Аксёнов", "Инокентий", 'M', 40, 9.0, "ТМ121 – Технология машиностроения");
        Students student5 = new Students("Голикова", "Мария", 'F', 38, 6.5, "Э122д – Экономика и бухгалтерский учет");
        Students student6 = new Students("Александрова", "Анастасия", 'F', 38, 3.5, "Э122д – Экономика и бухгалтерский учет");
        Students student7 = new Students("Болободько", "Егор", 'M', 26, 2.2, "ТМ121 – Технология машиностроения");
        Students student8 = new Students("Скамья", "Сергей", 'M', 24, 4.5, "ПБ122, – Пожарная безопасность");
        Students student9 = new Students("Нестерова", "Екатерина", 'F', 29, 8.9, "ПБ122, – Пожарная безопасность");
        Students student10 = new Students("Магомедов", "Сулейман", 'M', 35, 5.0, "ТМ121 – Технология машиностроения");
        Students student11 = new Students("Исламбеков", "Хабиб", 'M', 30, 9.0, "Э122д – Экономика и бухгалтерский учет");
        Students student12 = new Students("Пушкарев", "Владислав", 'M', 44, 7.2, "ТМ121 – Технология машиностроения");
        Students student13 = new Students("Аксёнов", "Антон", 'M', 35, 9.5, "Э122д – Экономика и бухгалтерский учет");
        Students student14 = new Students("Высоцкая", "Светлана", 'F', 28, 9.2, "Э122д – Экономика и бухгалтерский учет");
        Students student15 = new Students("Голикова", "Вера", 'F', 32, 8.7, "Э122д – Экономика и бухгалтерский учет");
        Students student16 = new Students("Белый", "Григорий", 'M', 33, 3.0, "ТМ121 – Технология машиностроения");
        Students student17 = new Students("Вешнякова", "Екатерина", 'F', 29, 5.9, "Э122д – Экономика и бухгалтерский учет");
        Students student18 = new Students("Евдокимов", "Сергей", 'M', 38, 3.9, "ПБ122, – Пожарная безопасность");
        Students student19 = new Students("Гуляев", "Егор", 'M', 33, 8.2, "Э122д – Экономика и бухгалтерский учет");
        Students student20 = new Students("Гусева", "Мария", 'F', 27, 8.9, "ПБ122, – Пожарная безопасность");
        Students student21 = new Students("Зуев", "Александр", 'M', 45, 7.7, "Э122д – Экономика и бухгалтерский учет");

        ArrayList<Students> arr = new ArrayList<>();
        arr.add(student1);
        arr.add(student2);
        arr.add(student3);
        arr.add(student4);
        arr.add(student5);
        arr.add(student6);
        arr.add(student7);
        arr.add(student8);
        arr.add(student9);
        arr.add(student10);
        arr.add(student11);
        arr.add(student12);
        arr.add(student13);
        arr.add(student14);
        arr.add(student15);
        arr.add(student16);
        arr.add(student17);
        arr.add(student18);
        arr.add(student19);
        arr.add(student20);
        arr.add(student21);

        return arr;


    }


}


