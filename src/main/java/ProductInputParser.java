import java.util.Scanner;

public class ProductInputParser {
    private String name;
    private double price;

    private boolean isPriceCorrect;
    public void getProductFromInput(Calculator calculator) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            isPriceCorrect = false;
            price = 0.00;
            printRequestProductMessage();
            String input = scn.nextLine().trim();
            int wordsCount = input.split(" +").length;
            if (wordsCount > 1) {
                setNameFromString(input);
                setPriceFromString(input);
                if (isPriceCorrect) {
                    calculator.addProduct(new Product(this.name, this.price));
                    if (!addAnotherProductQuestion()) {
                        break;
                    }
                }

            } else {
                printErrorMessage();
            }
        }

    }

    private void setNameFromString(String inputString) {
        this.name = inputString.substring(0 ,inputString.lastIndexOf(' '));

    }

    private void setPriceFromString(String inputString) {
        String priceString = inputString.substring(inputString.lastIndexOf(' ') + 1);
        try {
            this.price = Double.parseDouble(priceString);
            this.isPriceCorrect = checkPrice(priceString);
        } catch (NumberFormatException exception) {
            printErrorMessage();
        }
    }
    private boolean checkPrice(String price) {
        if (this.price <= 0) {
            printErrorMessage();
            return false;
        }
        int priceScale = price.substring(price.lastIndexOf('.') + 1).length();
        if (priceScale > 2) {
            printErrorMessage();
            return false;
        }
        return true;
    }


    private boolean addAnotherProductQuestion() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Вы хотите добавить еще один товар?\n" +
                "Для рассчета стоимости введите команду \"Завершить\"");
        String answer = scn.nextLine().trim();
        String finishWord = "Завершить";
        return !answer.equalsIgnoreCase(finishWord);
    }

    private void printRequestProductMessage() {
        System.out.println("Введите название товара и цену через пробел.\n" +
                "Например: Хлеб 10.45 или Салат \"Цезарь\" 15.15");
    }

    private void printErrorMessage() {
        System.out.println("Вы ввели неверное значение.");
    }
}
