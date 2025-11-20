package JavaStuff;
import java.util.Scanner;

public class RestaurantOrderSystem {

    
    static String[] menuItems = {
        "Burger", "Pizza", "Pasta", "Salad", "Fries",
        "Soda", "Steak", "Soup", "Ice Cream", "Coffee"
    };
    static double[] prices = {
        8.99, 12.49, 10.99, 7.49, 4.99,
        2.49, 18.99, 6.99, 3.99, 2.99
    };
    static int[] quantities = new int[10]; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== RESTAURANT MENU =====");
            System.out.println("1. Add item to order");
            System.out.println("2. Remove item from order");
            System.out.println("3. View current order");
            System.out.println("4. Calculate total cost");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addItem(sc);
                    break;
                case 2:
                    removeItem(sc);
                    break;
                case 3:
                    viewOrder();
                    break;
                case 4:
                    calculateTotal();
                    break;
                case 5:
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
    
    
    public static void addItem(Scanner sc) {
        int item;
        do {
            showMenu();
            System.out.print("Enter item number to add (0 to return to main menu): ");
            item = sc.nextInt() - 1;
            if (item == -1) break; 
            if (item >= 0 && item < menuItems.length) {
                quantities[item]++;
                System.out.println(menuItems[item] + " Added! Quantity: " + quantities[item] + "\n");
            } else {
                System.out.println("Invalid item number!\n");
            }
        } while (item != -1);
    }

    public static void removeItem(Scanner sc) {
        int item;
        do {
            showMenu();
            System.out.print("Enter item number to remove (0 to return to main menu): ");
            item = sc.nextInt() - 1;
            if (item == -1) break; 
            if (item >= 0 && item < menuItems.length) {
                if (quantities[item] > 0) {
                    quantities[item]--;
                    System.out.println(menuItems[item] + " Removed! Quantity: " + quantities[item] + "\n");
                } else {
                    System.out.println("You do not have that in your order!\n");
                }
            } else {
                System.out.println("Invalid item number!\n");
            }
        } while (item != -1);
    }
    
    public static void viewOrder() {
    	System.out.println("Current Order:");
    	boolean hasItems = false;
    	for (int i = 0;i < menuItems.length;i++) {
    		if (quantities[i] > 0) {
    			System.out.printf("%-15s x%d  $%.2f\n", menuItems[i], quantities[i], prices[i]);
    			hasItems = true;
    		}
    	}
    	if (!hasItems) {
    		System.out.print("\nNo items in your order yet!");
    	}
    }
    
    public static void calculateTotal() {
    	double total = 0;
    	for (int i = 0;i < menuItems.length; i++) {
    		total += prices[i] * quantities[i];
    	}
    	System.out.printf("\nTotal cost: $%.2f\n", total);
    }
    
    public static void showMenu() {
        System.out.println("\n===== MENU ITEMS =====");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%d. %-15s $%.2f\n", i + 1, menuItems[i], prices[i]);
        }
    }
}
