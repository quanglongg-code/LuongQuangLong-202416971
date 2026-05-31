package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {

    static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    // ---- View Store ----
    static void viewStore(Store store, Cart cart) {
        store.print();
        storeMenu();
        int choice = readInt();
        while (choice != 0) {
            switch (choice) {
                case 1: // See media details
                    System.out.print("Enter the title of the media: ");
                    String title1 = scanner.nextLine().trim();
                    Media found1 = store.searchByTitle(title1);
                    if (found1 == null) {
                        System.out.println("No media found with title: " + title1);
                    } else {
                        System.out.println(found1.toString());
                        mediaDetailsMenu();
                        int dc = readInt();
                        if (dc == 1) {
                            cart.addMedia(found1);
                        } else if (dc == 2) {
                            if (found1 instanceof Playable) {
                                ((Playable) found1).play();
                            } else {
                                System.out.println("This media type cannot be played.");
                            }
                        }
                    }
                    break;
                case 2: // Add media to cart
                    System.out.print("Enter the title of the media to add to cart: ");
                    String title2 = scanner.nextLine().trim();
                    Media found2 = store.searchByTitle(title2);
                    if (found2 == null) {
                        System.out.println("No media found with title: " + title2);
                    } else {
                        cart.addMedia(found2);
                    }
                    break;
                case 3: // Play media
                    System.out.print("Enter the title of the media to play: ");
                    String title3 = scanner.nextLine().trim();
                    Media found3 = store.searchByTitle(title3);
                    if (found3 == null) {
                        System.out.println("No media found with title: " + title3);
                    } else if (found3 instanceof Playable) {
                        ((Playable) found3).play();
                    } else {
                        System.out.println("This media type cannot be played.");
                    }
                    break;
                case 4: // See current cart
                    cart.print();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            store.print();
            storeMenu();
            choice = readInt();
        }
    }

    // ---- Update Store ----
    static void updateStore(Store store) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int choice = readInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    System.out.println("Choose media type: 1. DVD  2. Book  3. CD");
                    int type = readInt();
                    if (type == 1) {
                        System.out.print("Title: "); String t = scanner.nextLine().trim();
                        System.out.print("Category: "); String cat = scanner.nextLine().trim();
                        System.out.print("Director: "); String dir = scanner.nextLine().trim();
                        System.out.print("Length: "); int len = readInt();
                        System.out.print("Cost: "); float cost = readFloat();
                        store.addMedia(new DigitalVideoDisc(t, cat, dir, len, cost));
                    } else if (type == 2) {
                        System.out.print("Title: "); String t = scanner.nextLine().trim();
                        System.out.print("Category: "); String cat = scanner.nextLine().trim();
                        System.out.print("Cost: "); float cost = readFloat();
                        Book book = new Book(t, cat, cost);
                        System.out.print("How many authors? "); int n = readInt();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Author " + (i+1) + ": ");
                            book.addAuthor(scanner.nextLine().trim());
                        }
                        store.addMedia(book);
                    } else if (type == 3) {
                        System.out.print("Title: "); String t = scanner.nextLine().trim();
                        System.out.print("Category: "); String cat = scanner.nextLine().trim();
                        System.out.print("Artist: "); String artist = scanner.nextLine().trim();
                        System.out.print("Director: "); String dir = scanner.nextLine().trim();
                        System.out.print("Cost: "); float cost = readFloat();
                        CompactDisc cd = new CompactDisc(t, cat, dir, artist, cost);
                        System.out.print("How many tracks? "); int n = readInt();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Track " + (i+1) + " title: "); String tt = scanner.nextLine().trim();
                            System.out.print("Track " + (i+1) + " length: "); int tl = readInt();
                            cd.addTrack(new Track(tt, tl));
                        }
                        store.addMedia(cd);
                    }
                    break;
                case 2:
                    System.out.print("Enter the title of the media to remove: ");
                    String title = scanner.nextLine().trim();
                    Media m = store.searchByTitle(title);
                    if (m == null) System.out.println("Media not found.");
                    else store.removeMedia(m);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove a media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            choice = readInt();
        }
    }

    // ---- See Cart ----
    static void seeCart(Store store, Cart cart) {
        cart.print();
        cartMenu();
        int choice = readInt();
        while (choice != 0) {
            switch (choice) {
                case 1: // Filter
                    System.out.println("Filter by: 1. ID  2. Title");
                    int fc = readInt();
                    if (fc == 1) {
                        System.out.print("Enter ID: ");
                        int id = readInt();
                        Media m = cart.searchById(id);
                        if (m == null) System.out.println("Not found.");
                        else System.out.println(m.toString());
                    } else if (fc == 2) {
                        System.out.print("Enter title: ");
                        String t = scanner.nextLine().trim();
                        Media m = cart.searchByTitle(t);
                        if (m == null) System.out.println("Not found.");
                        else System.out.println(m.toString());
                    }
                    break;
                case 2: // Sort
                    System.out.println("Sort by: 1. Title  2. Cost");
                    int sc = readInt();
                    if (sc == 1) cart.sortByTitleCost();
                    else if (sc == 2) cart.sortByCostTitle();
                    break;
                case 3: // Remove
                    System.out.print("Enter the title of the media to remove: ");
                    String t3 = scanner.nextLine().trim();
                    Media m3 = cart.searchByTitle(t3);
                    if (m3 == null) System.out.println("Media not found in cart.");
                    else cart.removeMedia(m3);
                    break;
                case 4: // Play
                    System.out.print("Enter the title of the media to play: ");
                    String t4 = scanner.nextLine().trim();
                    Media m4 = cart.searchByTitle(t4);
                    if (m4 == null) System.out.println("Media not found in cart.");
                    else if (m4 instanceof Playable) ((Playable) m4).play();
                    else System.out.println("This media type cannot be played.");
                    break;
                case 5: // Place order
                    System.out.println("An order has been placed. Thank you!");
                    cart.clear();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
            cart.print();
            cartMenu();
            choice = readInt();
        }
    }

    // ---- Helpers ----
    static int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    static float readFloat() {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Float.parseFloat(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    public static void main(String[] args) {
        // Seed some data
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 9.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski", 136, 7.99f);

        Book book1 = new Book("Clean Code", "Programming", 29.99f);
        book1.addAuthor("Robert C. Martin");
        Book book2 = new Book("Effective Java", "Programming", 34.99f);
        book2.addAuthor("Joshua Bloch");

        CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 19.99f);
        cd1.addTrack(new Track("Come Together", 259));
        cd1.addTrack(new Track("Something", 182));
        cd1.addTrack(new Track("Here Comes the Sun", 185));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);

        // Polymorphism demo (Section 11)
        System.out.println("=== Polymorphism Demo ===");
        java.util.List<Media> mediae = new java.util.ArrayList<Media>();
        mediae.add(cd1);
        mediae.add(dvd1);
        mediae.add(book1);
        for (Media m : mediae) {
            System.out.println(m.toString());
            System.out.println();
        }
        System.out.println("=========================\n");

        // Main menu loop
        showMenu();
        int choice = readInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    viewStore(store, cart);
                    break;
                case 2:
                    updateStore(store);
                    break;
                case 3:
                    seeCart(store, cart);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            showMenu();
            choice = readInt();
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}
