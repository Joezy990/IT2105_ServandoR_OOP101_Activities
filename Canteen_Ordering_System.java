import java.util.Scanner;

public class Canteen_Ordering_System {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String[] items = {"", "Burger", "Shawarma", "Pizza", "French Fries", "Siomai Rice"};
        Double[] prices = {0.00, 80.00, 170.00, 100.00, 35.00, 55.00};

        int totaQuantity = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;
        char orderAgain;
        char isStudent;

        System.out.println("====== M E N U ======");
        for (int i = 1; i <= 5; i++) {
            System.out.printf("%d. %-10s - $%.2f%n", i, items[i], prices[i]);
        }
        System.out.println();

        do {
            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantityNumber = input.nextInt();

            if (itemNumber < 1 || itemNumber > 5 || quantityNumber < 1 || quantityNumber > 10) {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
                do {
                    System.out.print("Do you want to order again? (Y/N): ");
                    orderAgain = input.next().toUpperCase().charAt(0);
                    if (orderAgain != 'N' && orderAgain != 'Y') {
                        System.out.print("Invalid Input, Try again");
                    }
                    System.out.println();
                } while (orderAgain != 'N' && orderAgain != 'Y');
                continue;
            }

            do {
                System.out.print("Are you a student? (Y/N): ");
                isStudent = input.next().toUpperCase().charAt(0);
                if (isStudent != 'N' && isStudent != 'Y') {
                    System.out.print("Invalid Input, Try again");
                }
                System.out.println();
            } while (isStudent != 'N' && isStudent != 'Y');
            double subTotal = prices[itemNumber] * quantityNumber;
            double discountRate = 0.0;

            if (isStudent == 'Y' && subTotal >= 500) {
                discountRate = 0.15;
            }
            else if (isStudent == 'Y') {
                discountRate = 0.10;
            }
            else if (subTotal >= 500) {
                discountRate = 0.05;
            }

            double discount = subTotal * discountRate;
            double totalOrder = subTotal - discount;

            System.out.println();
            System.out.printf("Subtotal: $%.2f%n", subTotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order Total: $%.2f%n", totalOrder);
            System.out.println();

            totaQuantity += quantityNumber;
            totalBeforeDiscount += subTotal;
            totalDiscount += discount;

            do {
                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = input.next().toUpperCase().charAt(0);
                if (orderAgain != 'N' && orderAgain != 'Y') {
                    System.out.print("Invalid Input, Try again");
                }
                System.out.println();
            } while (orderAgain != 'N' && orderAgain != 'Y');

        } while (orderAgain != 'N');

        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totaQuantity);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", totalBeforeDiscount - totalDiscount);
        System.out.println();
        System.out.print("Thank you for ordering!");

        input.close();
    }

}