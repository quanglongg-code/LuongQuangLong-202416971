package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    // Class (static) variable - shared across all instances
    private static int nbDigitalVideoDiscs = 0;

    // Instance variables
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructors
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    public static int getNbDigitalVideoDiscs() { return nbDigitalVideoDiscs; }

    // Setter for title (used in TestPassingParameter exercise)
    public void setTitle(String title) { this.title = title; }

    // Check if this disc matches a given title (case-insensitive substring match)
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public String toString() {
        return "DVD - " + title
                + " - " + (category != null ? category : "N/A")
                + " - " + (director != null ? director : "N/A")
                + " - " + length + " min"
                + ": " + cost + " $";
    }
}
