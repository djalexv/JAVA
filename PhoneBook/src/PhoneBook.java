import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        while (true) {
            ArrayList<String[]> phoneBook = new ArrayList<String[]>();
            String[] currentLine = new String[2];
            String[] currentNameArray = getName();

            if ( currentNameArray[0] == "Stop") {
                System.out.println("Работа с программой закончена");
                break;
            }

            currentLine[0] = stringArrayToString(currentNameArray);
            currentLine[1] = getNumber();

            System.out.println(Arrays.toString(currentNameArray));
            System.out.println(stringArrayToString(currentNameArray) + " " + currentLine[1]);
            System.out.println("phoneBook.indexOf(currentLine) -> " + phoneBook.indexOf(currentLine) + " phoneBook.contains(currentLine) -> " + phoneBook.contains(currentLine));

            int currentIndex = phoneBook.indexOf(currentLine);
            if (currentIndex == -1) {
                phoneBook.add(currentLine);
                System.out.println("Человек с ФИО - \"" + currentLine[0] + "\" и телефоном \"" + currentLine[1] +
                        "\" добавлен в справочник");
            } else {
                System.out.println("Человек с таким ФИО уже есть в справочнике.\nНомер его телефона - " + currentLine[1]);
            }
            list(phoneBook);
            break;

        }
    }

    private static int nameInBook(ArrayList<String[][]> phoneBook, String[][] currentLine) {
        return phoneBook.indexOf(currentLine);
    }

    private static String getNumber() {
        String phoneNumber = "";
//        Scanner inData = new Scanner(System.in);
        Scanner inData = new Scanner("79138882509");
        boolean isCorrectNumber = false;
        while (!isCorrectNumber) {
            System.out.println("Введите номер телефона - 11 цифр. Первая 7 или 8");
            phoneNumber = cleanPhoneNumber(inData.nextLine()); //Считывает строку из System.in
//            phoneNumber = cleanPhoneNumber(phoneNumber);
            isCorrectNumber = checkPhoneNumber(phoneNumber); //checkPhoneNumberIsCorrect(phoneNumber);
            if (!isCorrectNumber) {
                System.out.println("Введите корректный номер!");
            }
        }
        inData.close();
        phoneNumber = formatPhoneNumber(phoneNumber);
        return phoneNumber;
    }

    public static String cleanPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceAll("[^0-9]", "");
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return cleanPhoneNumber(phoneNumber).length() == 11
                && (phoneNumber.charAt(0) == '7' || phoneNumber.charAt(0) == '8');
    }

    public static String formatPhoneNumber(String phoneNumber) {
        return "8" + " " + phoneNumber.substring(1, 4) + " " +
                phoneNumber.substring(4, 7) + " " + phoneNumber.substring(7, 9) + " " + phoneNumber.substring(9);
    }

    public static String[] getName() {
        String[] resNameArray = new String[3];
//        Scanner inData = new Scanner(System.in);
        Scanner inData = new Scanner("перров петр инванович");
        boolean isCorrectName = false;
        while (!isCorrectName) {
            System.out.println("Введите ФИО (3 слова) через пробелы\nДля выхода из программы нажмите \"c\"");
            String rawName = inData.nextLine(); //Считывает строку из System.in
            char firstSymbol = rawName.charAt(0);
            if (firstSymbol == 'C' || firstSymbol == 'С' || firstSymbol == 'с' || firstSymbol ==  'c') {
                for (int i = 0; i < resNameArray.length ; i++) {
                    resNameArray[i] = "Stop";
                }
                break;
            }

            String[] nameArray = firstCharUp(splitName(rawName));
//            System.out.println(Arrays.toString(nameArray));
            isCorrectName = nameArray.length == 3;
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            }else resNameArray = nameArray;
        }
        inData.close();
        return resNameArray;
    }


    public static String[] firstCharUp(String[] resStr) {
        for (int i = 0; i < resStr.length; i++) {
            char firstChar = resStr[i].charAt(0);
            resStr[i] = Character.toUpperCase(firstChar) + resStr[i].substring(1);
        }
        return resStr;
    }

    private static String[] splitName(String name) {
        return name.trim().split(" ");
    }

/*    public static boolean checkName(String name) {
        return (splitName(name).length == 3);
    }

    public static String formatName(String name) {
        return "";
    }*/


    public static String[][]  add(String[][] book, String name, String number) {
        String[][] workBook = Arrays.copyOf(book,book.length+1);
        workBook[workBook.length-1][0] = name;
        workBook[workBook.length-1][1] = number;
        return workBook;
    }

    public static void list(ArrayList<String[]> array) {
        for (int i = 0; i < array.size(); i++) {
            printRecord(array,i);
        }
    }

    private static String stringArrayToString(String[] array) {
        String resStr = "";
        for (int i = 0; i < array.length; i++) {
            resStr += (array[i] + " ");
        }
        resStr = resStr.trim();
        return resStr;
    }

    public static void printRecord(ArrayList<String[]> array, int indx) {
        if (indx>=0 && indx < array.size()) {
            System.out.println(array.get(indx).toString());
        }
    }

    private static char getChar() {
        Scanner scanner = new Scanner(System.in);
        char operation = scanner.next().charAt(0);
        scanner.close();
        return operation;
    }
}