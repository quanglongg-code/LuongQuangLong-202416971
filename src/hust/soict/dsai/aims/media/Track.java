package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Track)) return false;
        Track track = (Track) o;
        return this.length == track.length && this.title != null && this.title.equals(track.title);
    }

    @Override
    public void play() {
        if (this.length <= 0) {
            System.out.println("ERROR: This track \"" + this.title + "\" cannot be played because its length is invalid!");
        } else {
            System.out.println("Playing track: " + this.title);
            System.out.println("Track length: " + this.length);
        }
    }

    @Override
    public String toString() {
        return "Track [title=" + title + ", length=" + length + "]";
    }
}
