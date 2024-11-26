package lab02;

public class Cart {
	private DigitalVideoDisc[] items;
    private int qtyOrdered;
    private static final int MAX_CAPACITY = 10;

    public Cart() {
        this.items = new DigitalVideoDisc[MAX_CAPACITY];
        this.qtyOrdered = 0;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_CAPACITY) {
            items[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
            if (qtyOrdered == MAX_CAPACITY) {
                System.out.println("The cart is almost full.");
            }
        } else {
            System.out.println("Cannot add more discs. The cart is full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i].getTitle().equals(disc.getTitle())) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += items[i].getCost();
        }
        return total;
    }
}
