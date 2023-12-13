import java.util.Scanner;

class ECommerce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Grand Sale!");

        System.out.println("Enter product name:");
        String productName = scanner.nextLine();

        System.out.println("Enter the company it belongs to:");
        String company = scanner.nextLine();

        System.out.println("Enter the quantity:");
        int quantity = scanner.nextInt();

        System.out.println("Do you have an HDFC credit card? (Yes/No)");
        boolean hasHDFCCreditCard = scanner.next().equalsIgnoreCase("Yes");

        System.out.println("Are you an RGUKT student? (Yes/No)");
        boolean isRGUKTStudent = scanner.next().equalsIgnoreCase("Yes");

        System.out.println("Enter the total purchase amount:");
        double totalAmount = scanner.nextDouble();

        double amazonDiscount = calculateAmazonDiscount(hasHDFCCreditCard, totalAmount);
        double flipkartDiscount = calculateFlipkartDiscount(isRGUKTStudent, totalAmount);

        System.out.println("\nSummary:");

        System.out.println("Product: " + productName);
        System.out.println("Company: " + company);
        System.out.println("Quantity: " + quantity);

        System.out.println("\nCost Comparison:");

        System.out.println("Amazon Total Cost: " + calculateTotalCost(totalAmount, amazonDiscount));
        System.out.println("Flipkart Total Cost: " + calculateTotalCost(totalAmount, flipkartDiscount));

        System.out.println("\nRecommendation:");
        suggestBestPlace(amazonDiscount, flipkartDiscount);

        scanner.close();
    }

    private static double calculateAmazonDiscount(boolean hasHDFCCreditCard, double totalAmount) {
        double discount = 0.0;
        if (hasHDFCCreditCard) {
            discount += 0.10; // 10% discount for HDFC credit card holders
        }
        if (totalAmount > 50000) {
            discount += 0.15; // 15% discount on purchase above 50,000
        }
        return discount;
    }

    private static double calculateFlipkartDiscount(boolean isRGUKTStudent, double totalAmount) {
        double discount = 0.0;
        if (isRGUKTStudent) {
            discount += 0.30; // 30% discount for RGUKT students
        }
        if (totalAmount > 30000) {
            discount += 0.05; // 5% discount on purchase above 30,000
        }
        return discount;
    }

    private static double calculateTotalCost(double totalAmount, double discount) {
        return totalAmount - (totalAmount * discount);
    }

    private static void suggestBestPlace(double amazonDiscount, double flipkartDiscount) {
        if (amazonDiscount > flipkartDiscount) {
            System.out.println("Suggestion: Buy from Amazon for a better discount!");
        } else if (flipkartDiscount > amazonDiscount) {
            System.out.println("Suggestion: Buy from Flipkart for a better discount!");
        } else {
            System.out.println("Suggestion: Both Amazon and Flipkart offer similar discounts. Choose either!");
        }
    }
}

