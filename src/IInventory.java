public interface IInventory {
    boolean addItem(IItem item);
    IItem removeItem(String name, int quantity);
    void printInventory();

    double calculateTotalValue();
}