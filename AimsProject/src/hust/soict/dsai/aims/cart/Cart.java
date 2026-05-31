package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Original method: add one DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added: " + disc.getTitle());
        } else {
            System.out.println("The cart is full. Cannot add more items.");
        }
    }

    // Overload 1: add an array of DVDs (Section 2.1)
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (disc != null) {
                addDigitalVideoDisc(disc);
            }
        }
    }

    // Overload 2: varargs - arbitrary number of DVDs (Section 2.1)
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        // Varargs allows calling addDigitalVideoDisc(dvd1, dvd2, dvd3, ...)
        // Compared to array: varargs is more flexible at call site; array is better when the list already exists.
        for (DigitalVideoDisc disc : dvds) {
            if (disc != null) {
                addDigitalVideoDisc(disc);
            }
        }
    }

    // Overload 3: two DVDs (Section 2.2)
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // Remove a DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                // Shift remaining items
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Removed: " + disc.getTitle());
                return;
            }
        }
        System.out.println("Disc not found in cart.");
    }

    // Print cart (Section 6)
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
            totalCost += itemsOrdered[i].getCost();
        }
        System.out.printf("Total cost: %.2f $%n", totalCost);
        System.out.println("***************************************************");
    }

    // Search by ID (Section 6)
    public DigitalVideoDisc searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found: " + itemsOrdered[i].toString());
                return itemsOrdered[i];
            }
        }
        System.out.println("No disc with id=" + id + " was found in the cart.");
        return null;
    }

    // Search by title (Section 6)
    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("Search results for \"" + title + "\":");
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("  - " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No match found.");
        }
    }

    public int getQtyOrdered() { return qtyOrdered; }
}
