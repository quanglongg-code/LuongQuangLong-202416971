package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, cost, 0, director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, String director, String artist, float cost) {
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    @Override
    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD!");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" added to CD.");
        }
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is not in the CD!");
        } else {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" removed from CD.");
        }
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        if (tracks.isEmpty()) {
            System.out.println("No tracks in this CD.");
            return;
        }
        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - Title: ").append(getTitle())
          .append("\n       Category: ").append(getCategory())
          .append("\n       Artist: ").append(artist)
          .append("\n       Director: ").append(getDirector())
          .append("\n       Length: ").append(getLength())
          .append("\n       Cost: ").append(getCost());
        if (!tracks.isEmpty()) {
            sb.append("\n       Tracks:");
            for (Track t : tracks) {
                sb.append("\n         - ").append(t.toString());
            }
        }
        return sb.toString();
    }
}
