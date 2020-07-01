import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        String[] currentNameArray = getName();
        System.out.println(Arrays.toString(currentNameArray));
        String currentNumber = getNumber();
        System.out.println(stringArrayToString(currentNameArray)+ " " + currentNumber);


    }

    private static String getNumber() {
        String phoneNumber = "";
        Scanner inData = new Scanner(System.in);
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
        return "+7" + " " + phoneNumber.substring(1, 4) + " " +
                phoneNumber.substring(4, 7) + " " + phoneNumber.substring(7, 9) + " " + phoneNumber.substring(9);
    }

    public static String[] getName() {
        String[] nameArray = new String[3];
//        Scanner inData = new Scanner(System.in);
        Scanner inData = new Scanner("перров петр инванович");
        boolean isCorrectName = false;
        while (!isCorrectName) {
            System.out.println("Введите ФИО (3 слова) через пробелы");
            String rawName = inData.nextLine(); //Считывает строку из System.in
            nameArray = firstCharUp(splitName(rawName));
//            System.out.println(Arrays.toString(nameArray));
            isCorrectName = nameArray.length == 3;
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            }
        }
        inData.close();
        return nameArray;
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

    public static boolean checkName(String name) {
        return (splitName(name).length == 3);
    }

    public static String formatName(String name) {
        return "";
    }


    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }

    private static String stringArrayToString(String [] array) {
        String resStr = "";
        for (int i = 0; i < array.length; i++) {
            resStr += (array[i] + " ");
        }
        resStr = resStr.trim();
        return resStr;
    }
}