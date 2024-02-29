

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("Shirt", 19.99, 5));
        inventory.addItem(new Item("Jeans", 39.99, 3));
        inventory.addItem(new Item("Hat", 14.99, 2));
        inventory.printInventory();
        inventory.removeItem("Shirt", 2);
        inventory.printInventory();
        System.out.println("Total value of inventory: $" + inventory.calculateTotalValue());
    }
}