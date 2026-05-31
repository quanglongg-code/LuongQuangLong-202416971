package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title) {
        super();
        this.setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost, 0, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("ERROR: DVD \"" + this.getTitle() + "\" cannot be played because its length is invalid!");
        } else {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
    }

    @Override
    public String toString() {
        return "DVD - Title: " + getTitle()
                + "\n       Category: " + getCategory()
                + "\n       Director: " + getDirector()
                + "\n       Length: " + getLength()
                + "\n       Cost: " + getCost();
    }
}
