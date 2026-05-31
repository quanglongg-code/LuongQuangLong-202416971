package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author \"" + authorName + "\" is already in the book's author list!");
        } else {
            authors.add(authorName);
            System.out.println("Author \"" + authorName + "\" added.");
        }
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author \"" + authorName + "\" is not in the book's author list!");
        } else {
            authors.remove(authorName);
            System.out.println("Author \"" + authorName + "\" removed.");
        }
    }

    @Override
    public String toString() {
        return "Book - Title: " + getTitle()
                + "\n        Category: " + getCategory()
                + "\n        Authors: " + authors.toString()
                + "\n        Cost: " + getCost();
    }
}
