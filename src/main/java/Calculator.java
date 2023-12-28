import java.util.ArrayList;

public class Calculator {
    private int numberOfPersons;

    private ArrayList<Product> productList = new ArrayList<Product>();

    private double totalCost = 0.0;

    Calculator(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
        this.totalCost += product.getPrice();
        System.out.println("Товар успешно добавлен");
    }

    public void calculateCost() {
        double costPerGuest = this.totalCost / (double) numberOfPersons;
        printProductList();
        System.out.println(String.format("Общая стоимость товаров: %.2f %s",
                this.totalCost,
                Formatter.getCorrectCaseOfRuble((int) this.totalCost)));

        System.out.println(String.format("Каждый гость должен заплатить: %.2f %s",
                costPerGuest,
                Formatter.getCorrectCaseOfRuble((int) this.totalCost)));
    }

    private void printProductList() {
        System.out.println("Добавленные товары:");
        for (int i = 0; i < productList.size(); i++) {
            printProduct(productList.get(i));
        }
    }
    private void printProduct(Product product) {
        String template = "%s %.2f %s";
        System.out.println(String.format(template, product.getName(), product.getPrice(),
                Formatter.getCorrectCaseOfRuble((int) product.getPrice())));
    }
}
