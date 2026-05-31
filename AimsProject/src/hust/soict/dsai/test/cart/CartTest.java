package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.print();

        // Test overload: add two DVDs at once
        System.out.println("\n--- Test addDigitalVideoDisc(dvd1, dvd2) overload ---");
        Cart cart2 = new Cart();
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 15.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 22.50f);
        cart2.addDigitalVideoDisc(dvd4, dvd5);
        cart2.print();

        // Test overload: add array of DVDs
        System.out.println("\n--- Test addDigitalVideoDisc(array) overload ---");
        Cart cart3 = new Cart();
        DigitalVideoDisc[] dvdArray = {
            new DigitalVideoDisc("Avengers", "Action", 29.99f),
            new DigitalVideoDisc("Titanic", "Drama", "James Cameron", 195, 18.00f)
        };
        cart3.addDigitalVideoDisc(dvdArray);
        cart3.print();

        // Test search by ID
        System.out.println("\n--- Test searchById ---");
        cart.searchById(dvd1.getId());
        cart.searchById(9999); // Not found

        // Test search by title
        System.out.println("\n--- Test searchByTitle ---");
        cart.searchByTitle("lion");
        cart.searchByTitle("star");
        cart.searchByTitle("batman"); // Not found

        // Test remove
        System.out.println("\n--- Test removeDigitalVideoDisc ---");
        cart.removeDigitalVideoDisc(dvd2);
        cart.print();
    }
}
