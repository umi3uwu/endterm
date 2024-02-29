import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Print Inventory");
            System.out.println("4. Calculate Total Value");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    if (inventory.addItem(new Item(name, price, quantity))) {
                        System.out.println("Item added successfully!");
                    } else {
                        System.out.println("Inventory is full!");
                    }
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeName = scanner.nextLine();
                    System.out.print("Enter quantity to remove: ");
                    int removeQuantity = scanner.nextInt();
                    scanner.nextLine();

                IItem removedItem = inventory.removeItem(removeName, removeQuantity);

                    if (removedItem != null) {
                        System.out.println("Item removed successfully: " + removedItem);
                    } else {
                        System.out.println("Item not found or insufficient quantity!");
                    }
                    break;
                case 3:
                    inventory.printInventory();
                    break;
                case 4:
                    System.out.println("Total value of inventory: $" + inventory.calculateTotalValue());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}