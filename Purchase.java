import java.util.Scanner;

public class Purchase {
    // Attributes for the Purchase class
    private int invoiceNumber;
    private double amountOfSale;
    private double amountOfSalesTax;

    // Constructor to initialize a Purchase object
    public Purchase(int invoiceNumber, double amountOfSale) {
        this.invoiceNumber = invoiceNumber;
        setAmountOfSale(amountOfSale);
    }

    // Setter method for the invoice number
    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    // Setter method for the amount of sale
    public void setAmountOfSale(double amountOfSale) {
        this.amountOfSale = amountOfSale;
        // Calculate the sales tax as 5% of the sale amount
        this.amountOfSalesTax = amountOfSale * 0.05;
    }

    // Getter method for the invoice number
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    // Getter method for the amount of sale
    public double getAmountOfSale() {
        return amountOfSale;
    }

    // Getter method for the amount of sales tax
    public double getAmountOfSalesTax() {
        return amountOfSalesTax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Purchase[] purchases = new Purchase[5];
        int count = 0;

        // Prompt user to enter purchase details (between 2 to 5 inputs)
        System.out.println("Enter purchase details:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Do you want to enter another purchase? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
            System.out.print("Enter invoice number: ");
            int invoiceNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter amount of sale: ");
            double amountOfSale = Double.parseDouble(scanner.nextLine());
            purchases[count++] = new Purchase(invoiceNumber, amountOfSale);
        }

        // Ask the user for the sorting preference
        System.out.print("Sort by (1) Invoice Number or (2) Sale Amount? ");
        int sortOption = Integer.parseInt(scanner.nextLine());

        // Perform Bubble Sort based on user's preference
        if (sortOption == 1) {
            // Sort by Invoice Number
            for (int i = 0; i < count - 1; i++) {
                for (int j = 0; j < count - 1 - i; j++) {
                    if (purchases[j].getInvoiceNumber() > purchases[j + 1].getInvoiceNumber()) {
                        // Swap purchases[j] and purchases[j + 1]
                        Purchase temp = purchases[j];
                        purchases[j] = purchases[j + 1];
                        purchases[j + 1] = temp;
                    }
                }
            }
        } else {
            // Sort by Sale Amount
            for (int i = 0; i < count - 1; i++) {
                for (int j = 0; j < count - 1 - i; j++) {
                    if (purchases[j].getAmountOfSale() > purchases[j + 1].getAmountOfSale()) {
                        // Swap purchases[j] and purchases[j + 1]
                        Purchase temp = purchases[j];
                        purchases[j] = purchases[j + 1];
                        purchases[j + 1] = temp;
                    }
                }
            }
        }

        // Display the sorted Purchase objects
        System.out.println("Sorted Purchase details:");
        for (int i = 0; i < count; i++) {
            System.out.println("Invoice Number: " + purchases[i].getInvoiceNumber() +
                               ", Amount of Sale: $" + purchases[i].getAmountOfSale() +
                               ", Amount of Sales Tax: $" + purchases[i].getAmountOfSalesTax());
        }

        scanner.close();
    }
}
