import java.util.*;

// �������� ��������� ����� ��������:
//1. ������������ ����� �*� ������� ��� ����� - ������ � � - ��������� �
//2. ������������ ����� �_� ������� ��� ����� - ������ � �  "_" - ����� ���� ������, - 3 �������
class Slovar {
    private Map<String, Map<String, List<String>>> dictionary;

    {
        dictionary = new TreeMap<>();
    }

    // ����� ���������� ����� ru, en
    public boolean addLang(String lang) {
        lang = lang.toLowerCase(); // ������������� ��������
        if (dictionary.containsKey(lang)) { //�� ��������� ��� ������������ ����
            return false;
        }
        dictionary.put(lang, new TreeMap<>());
        return true;
    }

    // ����� ������ �� ������ ����� ru, en
    public void printLang() {
        int count = 1;
        for (String lang : dictionary.keySet()) {
            System.out.println(count++ + ") " + lang);
        }
    }

    // ����� �������� ����� ru, en
    public boolean removeLang(String lang) {
        lang = lang.toLowerCase();// ������������� ��������
        if (dictionary.containsKey(lang)) {
            dictionary.remove(lang);
            return true;
        }
        return false;
    }

    public List<String> toLowerCase(List<String> list) {
        List<String> lisrArr = new ArrayList<>();
        for (String word : list) {
            lisrArr.add(word.toLowerCase());
        }
        return lisrArr;
    }

    public List<String> checkList(List<String> nowArrWord, List<String> newArrWord) {
        for (String word : newArrWord) {
            if (!nowArrWord.contains(word)) {
                nowArrWord.add(word);
            }
        }
        return nowArrWord;
    }

    public boolean addWord(String keyLang, String originalWord, List<String> arrWord) {
        originalWord = originalWord.toLowerCase();// ������������� ��������
        keyLang = keyLang.toLowerCase();// ������������� ��������
        arrWord = toLowerCase(arrWord);// ������������� ��������
        if (dictionary.containsKey(keyLang)) {
            if (dictionary.get(keyLang).containsKey(originalWord)) {
                List<String> arr = dictionary.get(keyLang).get(originalWord);
                List<String> arrNew;
                //��������� ���� �� ����� ������������� � arrWord
                arrNew = checkList(arr, arrWord);
                if (arr.size() != arrNew.size()) {
                    dictionary.get(keyLang).put(originalWord, arrNew);
                    return true;
                }
                return false;
            } else {
                dictionary.get(keyLang).put(originalWord, arrWord);
                return true;
            }
        } else {
            if (addLang(keyLang))
                return addWord(keyLang, originalWord, arrWord);
            else return false;
        }
    }

    public boolean addWord(String keyLang, String originalWord, String word) {
        originalWord = originalWord.toLowerCase();// ������������� ��������
        keyLang = keyLang.toLowerCase();// ������������� ��������
        word = word.toLowerCase();// ������������� ��������
        if (dictionary.containsKey(keyLang)) {
            if (dictionary.get(keyLang).containsKey(originalWord)) {
                if (dictionary.get(keyLang).get(originalWord).contains(word)) {
                    return false;
                } else {
                    dictionary.get(keyLang).get(originalWord).add(word);
                    return true;
                }
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                dictionary.get(keyLang).put(originalWord, list);
                return false;
            }
        } else {
            if (addLang(keyLang)) {
                boolean isadd = addWord(keyLang, originalWord, word);
                return isadd;
            } else {
                return false;
            }
        }
    }

    public void printSlovarLang(String newKey) {
        int count = 1;
        if (dictionary.containsKey(newKey)) {
            System.out.println(newKey);
            System.out.println("--------------------------------");
            for (String word : dictionary.get(newKey).keySet()) {
                System.out.print(word + " : ");
                for (String tr : dictionary.get(newKey).get(word)) {
                    System.out.print(tr + " , ");
                }
                System.out.println();
            }
        }
    }

    public void printSlovarLang() {
        int count = 1;
        if (dictionary.keySet().size() > 0) {

            for (String lang : dictionary.keySet()) {
                System.out.println(count++ + ") " + lang);
            }
        }
    }

    public String getLangByIndex(int index) {
        int count = 1;
        if (dictionary.keySet().size() >= index && index >= 0) {

            for (String lang : dictionary.keySet()) {
                if (index == count) return lang;
                count++;
                //  System.out.println(count++ + ") "+ lang);
            }
        }

        return null;
    }

    public void printSlovar() {
        int count = 1;
        for (String newKey : dictionary.keySet()) {
            System.out.println(newKey);
            System.out.println("--------------------------------");
            for (String word : dictionary.get(newKey).keySet()) {
                System.out.print(word + " : ");
                for (String tr : dictionary.get(newKey).get(word)) {
                    System.out.print(tr + " , ");
                }
                System.out.println();
            }
        }
    }

    // ����� ������ ����� �� ������ ������
    public void searchWord(String lang, String search) {
        int count = 1;
        search = search.toLowerCase();
        if (dictionary.containsKey(lang)) {
            for (String word : dictionary.get(lang).keySet()) {
                if (word.startsWith(search)) {
                    if (count == 1)
                        System.out.println("Search : " + search);
                    System.out.println(count++ + ") " + word);
                }
            }
            if (count == 1) {
                System.out.println("������ ����� ��� !!!");
            }
        }
    }

    //  ������������ ����� �*� ������� ��� ����� - ������ � � - ��������� �

    public void printWordSearch(String lang, String newWord) {
        int count = 1;
        String[] arr = newWord.split("[*]");
        String startChar = arr[0];
        String endChar = arr[1];
        lang = lang.toLowerCase();
        startChar = startChar.toLowerCase();
        endChar = endChar.toLowerCase();
        if (dictionary.containsKey(lang)) {
            for (String word : dictionary.get(lang).keySet()) {
                if (word.startsWith(startChar) && word.endsWith(endChar)) {
                    if (count == 1)
                        System.out.println("������ : " + startChar + " �����: " + endChar);
                    System.out.print(count++ + ") " + word + " ");
                    for (String tr : dictionary.get(lang).get(word)) {
                        System.out.print(tr + " ");
                    }
                    System.out.println();
                }
                if (count == 1) {
                    System.out.println("������ ����� ��� !!!");
                }
            }
        }
    }

    public void printWordSize(String lang, String newWord) {
        int count = 1;
        String[] arr = newWord.split("[_]");
        String startChar = arr[0];
        String endChar = arr[1];
        lang = lang.toLowerCase();
        startChar = startChar.toLowerCase();
        endChar = endChar.toLowerCase();
        if (dictionary.containsKey(lang)) {
            for (String word : dictionary.get(lang).keySet()) {
                if (word.startsWith(startChar) && word.endsWith(endChar) && word.length() == 3) {
                    if (count == 1)
                        System.out.println("������: " + startChar + " �����: " + endChar);
                    System.out.print(count++ + ") " + word + " ");

                    for (String tr : dictionary.get(lang).get(word)) {
                        System.out.print(tr + " ");
                    }
                    System.out.println();
                }

            }
            if (count == 1) {
                System.out.println("������ ����� ��� !!!");
            }
        }
    }

    public void printWordArr(String lang, String newWord) {
        for (String str : dictionary.get(lang).keySet()) {
            if (checkWordChar(str, newWord)) {
                System.out.println(str);
            }
        }
    }

    public boolean checkWordChar(String word, String search) {

//        boolean flag = false;
//        if (word.length() == search.length()) {
//            for (int i = 0; i < search.length(); i++) {
//                if (word.charAt(i) == search.charAt(i) || search.charAt(i) == '_') {
//                    flag = true;
//                } else {
//                    flag = false;
//                    break;
//                }
//            }
//        }
//        return flag;

        if (word.length() == search.length()) {
            for (int i = 0; i < search.length(); i++) {
                if (word.charAt(i) != search.charAt(i)) {
                    if (search.charAt(i) != '_')
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    public List<String> splitMethod(String inputFromUser){
        String[] list;
        List<String> newList = new ArrayList<>();
        list = inputFromUser.split(",");
        for (int i = 0; i < list.length; i++) {
            newList.add(list[i]);
        }
        return newList;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("�������!");
        String action;
        Scanner scanner = new Scanner(System.in);
        Slovar slovar = new Slovar();
        slovar.addWord("en", "cat", "�����");
        slovar.addWord("en", "cot", "���");
        slovar.addWord("en", "cit", "���");
        slovar.addWord("en", "coat", "������");
        slovar.addWord("en", "dog", "������");

        slovar.printWordArr("en", "__t");

        do {
            System.out.println("1 -> �������� ���������");
            System.out.println("2 -> �������� �����");
            System.out.println("3 -> �������� ��������� ����");
            System.out.println("4 -> ���������� ���������");
            System.out.println("5 -> ���������� �������");
            System.out.println("6 -> �������� ���������");
            System.out.println("7 -> ����� �����");
            System.out.println("8 -> �����");

            action = scanner.nextLine();
            if (action.equals("1")) {
                System.out.println("������� ��c������");
                String addLang = scanner.nextLine();
                slovar.addLang(addLang);
                slovar.printLang();

            } else if (action.equals("2")) {
                System.out.println("������� ��������� ");
                String addLang = scanner.nextLine();
                System.out.println("������� �����");
                String addWord = scanner.nextLine();
                System.out.println("������� ������� ");
                String addTranslate = scanner.nextLine();
                if (addLang.trim().isEmpty() || addWord.trim().isEmpty() || addTranslate.trim().isEmpty()) {
                    System.out.println("���� �� ������ ���� �������! \n");
                } else {
                    slovar.addWord(addLang, addWord, addTranslate);
                    slovar.printSlovarLang(addLang);
                }


            } else if (action.equals("3")) {
                System.out.println("������� ���������");
                String addLang = scanner.nextLine();
                System.out.println("������� �����");
                String addWord = scanner.nextLine();
                System.out.println("������� ������� ����� �������!");
                String addTranslate = scanner.nextLine();
                slovar.addWord(addLang, addWord, slovar.splitMethod(addTranslate));
                slovar.printSlovarLang(addLang);

            } else if (action.equals("4")) {
                System.out.println("���������: ");
                slovar.printLang();

            } else if (action.equals("5")) {
                System.out.println("������� ��������� ��� ����������� ����� �������.");
                String input = scanner.nextLine();
                slovar.printSlovarLang(input);

            } else if (action.equals("6")) {
                System.out.println("������� ��������� ��� � ��������.");
                String inputForRemoveLang = scanner.nextLine();
                if (slovar.removeLang(inputForRemoveLang)) {
                    System.out.println("������� � ���������� (" + inputForRemoveLang + ") ��� ������.");
                } else
                    System.out.println("������� � ���������� (" + inputForRemoveLang + ") �� ��� ������, ��� ��� ����� ��������� � ������� �� �������!");


            } else if (action.equals("7")) {
                System.out.println("7");
            } else if (action.equals("8")) {
                System.out.println("Buy buy");
                break;
            } else {
                System.out.println("�� ���������� �����, ������� �� (1 - 8)");
            }



        } while (true);


    }
}
