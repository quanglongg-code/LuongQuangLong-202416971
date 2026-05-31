package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS];
    private int nbItems = 0;

    public void addDVD(DigitalVideoDisc disc) {
        if (nbItems < MAX_ITEMS) {
            itemsInStore[nbItems] = disc;
            nbItems++;
            System.out.println("Added to store: " + disc.getTitle());
        } else {
            System.out.println("Store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < nbItems; i++) {
            if (itemsInStore[i] == disc) {
                for (int j = i; j < nbItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[nbItems - 1] = null;
                nbItems--;
                System.out.println("Removed from store: " + disc.getTitle());
                return;
            }
        }
        System.out.println("DVD not found in store.");
    }

    public void print() {
        System.out.println("==========STORE==========");
        for (int i = 0; i < nbItems; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("Total items: " + nbItems);
        System.out.println("=========================");
    }

    public int getNbItems() { return nbItems; }
}
