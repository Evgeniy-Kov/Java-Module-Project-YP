import java.util.Scanner;

public class IntegerParser {
    int getNumberFromInput() {
        Scanner scn = new Scanner(System.in);
        int numberOfPerson;
        while (true) {
            System.out.println("Введите количество гостей, на которых необходимо разделить счет: ");
            String input = scn.nextLine().trim();
            try {
                numberOfPerson = Integer.parseInt(input);

                if (numberOfPerson > 1) {
                    break;
                } else {
                    printErrorMessage();
                }

            } catch (NumberFormatException exception) {
                printErrorMessage();
            }

        }
        return numberOfPerson;
    }

    void printErrorMessage() {
        System.out.println("Вы ввели неверное значение.\nКоличество гостей должно быть больше 1" +
                " и меньше 2147483648");
    }
}
