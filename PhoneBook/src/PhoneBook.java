import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner inData = new Scanner(System.in);
        boolean isCorrectName = false;
//        System.out.println(inData.delimiter().toString());
        while (!isCorrectName) {
            System.out.println("Введите ФИО через пробелы");
            String rawName = inData.nextLine(); //Считывает строку из System.in
            String[] nameArray = firstCharUp(splitName(rawName));
            System.out.println(Arrays.toString(nameArray));

            if (nameArray.length == 3) {
                isCorrectName = true;
            }
/*
            if (!isCorrectName) {
                System.out.println("Введите корректное имя!");
            } else {
                System.out.println(formatName(rawName));
            }
*/
        }
    }

    public static String[] firstCharUp(String[] resStr) {
        String result = "";
        for (int i = 0; i < resStr.length; i++) {
            char firstChar = resStr[i].charAt(0);
            resStr[i] = Character.toUpperCase(firstChar) + resStr[i].substring(1);
        }
        return resStr;
    }

    private static String[] splitName(String name) {
        return name.trim().split(" ");
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return true;
    }

    public static boolean checkName(String name) {
        return (splitName(name).length == 3);
    }

    public static String formatName(String name) {
        return "";
    }

    public static String formatPhoneNumber(String number) {
        return "";
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}