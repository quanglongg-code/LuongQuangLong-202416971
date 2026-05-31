package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" already exists in the store!");
        } else {
            itemsInStore.add(media);
            System.out.println("Media \"" + media.getTitle() + "\" added to store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" removed from store.");
        } else {
            System.out.println("ERROR: Media \"" + media.getTitle() + "\" not found in store.");
        }
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).getTitle()
                    + " - " + itemsInStore.get(i).getCost() + "$");
        }
        System.out.println("***************************************************");
    }
}
