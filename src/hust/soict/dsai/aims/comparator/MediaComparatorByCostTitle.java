package hust.soict.dsai.aims.comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int cmp = Float.compare(m2.getCost(), m1.getCost()); // decreasing cost
        if (cmp != 0) return cmp;
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
