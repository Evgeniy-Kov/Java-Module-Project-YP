public class Main {
    public static void main(String[] args) {

        IntegerParser integerParser = new IntegerParser();
        int numberOfPerson = integerParser.getNumberFromInput();

        Calculator calculator = new Calculator(numberOfPerson);
        ProductInputParser productInputParser = new ProductInputParser();
        productInputParser.getProductFromInput(calculator);
        calculator.calculateCost();

    }
}