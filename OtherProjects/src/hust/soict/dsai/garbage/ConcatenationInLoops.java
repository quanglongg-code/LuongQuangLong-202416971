package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        final int ITERATIONS = 65536;

        // --- Test 1: String with + operator ---
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < ITERATIONS; i++) {
            s += r.nextInt(2);
        }
        long timeString = System.currentTimeMillis() - start;
        System.out.println("String (+) time: " + timeString + " ms");

        // --- Test 2: StringBuilder ---
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        long timeStringBuilder = System.currentTimeMillis() - start;
        System.out.println("StringBuilder time: " + timeStringBuilder + " ms");

        // --- Test 3: StringBuffer (thread-safe) ---
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            sbuf.append(r.nextInt(2));
        }
        s = sbuf.toString();
        long timeStringBuffer = System.currentTimeMillis() - start;
        System.out.println("StringBuffer time: " + timeStringBuffer + " ms");

        System.out.println("\nConclusion:");
        System.out.println("  String (+) creates a new object every iteration -> O(n^2) memory -> very slow.");
        System.out.println("  StringBuilder/StringBuffer reuse an internal buffer -> O(n) -> much faster.");
        System.out.println("  StringBuilder is faster than StringBuffer (no synchronization).");
    }
}
