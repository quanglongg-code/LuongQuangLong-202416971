package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("ERROR: Cart is full! Cannot add more items.");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("ERROR: Media \"" + media.getTitle() + "\" is already in the cart!");
        } else {
            itemsOrdered.add(media);
            System.out.println("Media \"" + media.getTitle() + "\" added to cart. Total items: " + itemsOrdered.size());
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" removed from cart.");
        } else {
            System.out.println("ERROR: Media \"" + media.getTitle() + "\" not found in cart.");
        }
    }

    public float totalCost() {
        float total = 0f;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title then cost.");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost then title.");
    }

    public Media searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered items:");
        for (Media m : itemsOrdered) {
            System.out.println(m.toString());
            System.out.println("--------------------------------------------------");
        }
        System.out.printf("Total cost: %.2f$\n", totalCost());
        System.out.println("**************************************************");
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void clear() {
        itemsOrdered.clear();
    }
}
