package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    /**
     * This swap does NOT work because Java is pass-by-value.
     * The references o1 and o2 are local copies; swapping them doesn't affect the caller.
     */
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    /**
     * This DOES change the title because we call a mutating method on the object
     * that the reference points to. The reference itself is a copy, but the object it
     * points to is the same — so mutations via setters ARE visible to the caller.
     * Then dvd is reassigned to a new object, which does NOT affect the caller's reference.
     */
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);          // mutates the real object -> caller sees this change
        dvd = new DigitalVideoDisc(oldTitle); // only reassigns the local copy -> caller unaffected
    }

    /**
     * A correct swap using a wrapper array to simulate pass-by-reference.
     * Pass an array of length 1 holding each DVD; swap the contents at index 0.
     */
    public static void swapCorrect(DigitalVideoDisc[] a, DigitalVideoDisc[] b) {
        DigitalVideoDisc tmp = a[0];
        a[0] = b[0];
        b[0] = tmp;
    }
}
