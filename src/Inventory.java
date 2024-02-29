public class Inventory implements IInventory {

    private static final int MAX_ITEMS = 100;
    private final IItem[] items;
    private int numItems;

    public Inventory() {
        this.items = new IItem[MAX_ITEMS];
        this.numItems = 0;
    }

    @Override
    public boolean addItem(IItem item) {
        if (numItems >= MAX_ITEMS) {
            return false;
        }
        items[numItems++] = item;
        return true;
    }

    @Override
    public IItem removeItem(String name, int quantity) {
        int index = findItemIndex(name);
        if (index == -1 || items[index].getQuantity() < quantity) {
            return null;
        }

        IItem removedItem = items[index];
        items[index] = items[numItems - 1];
        items[numItems - 1] = null;
        numItems--;
        removeItemQuantity(name, quantity);
        return removedItem;
    }

    private int findItemIndex(String name) {
        for (int i = 0; i < numItems; i++) {
            if (items[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void removeItemQuantity(String name, int quantity) {
        int index = findItemIndex(name);
        if (index != -1) {
            items[index].setQuantity(items[index].getQuantity() - quantity);
        }
    }

    @Override
    public void printInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < numItems; i++) {
            System.out.println(items[i]);
        }
    }

    @Override
    public double calculateTotalValue() {
        double totalValue = 0;
        for (int i = 0; i < numItems; i++) {
            totalValue += items[i].getPrice() * items[i].getQuantity();
        }
        return totalValue;
    }
}
