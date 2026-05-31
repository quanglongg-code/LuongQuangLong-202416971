package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Demonstrates the garbage-creation problem when using + to build strings from large data.
 * Each += creates a new String object, leaving the old one as garbage for GC to collect.
 * For a large file this can cause: high GC pressure, long pauses, or OutOfMemoryError.
 *
 * Run with a large file to observe the slow-down / hang.
 */
public class GarbageCreator {

    /**
     * BAD: reads bytes from a file using String + operator.
     * Creates enormous amounts of short-lived String objects (garbage).
     */
    public static String readFileWithGarbage(String filename) throws IOException {
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();

        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;   // new String object every iteration!
        }

        long endTime = System.currentTimeMillis();
        System.out.println("readFileWithGarbage time: " + (endTime - startTime) + " ms");
        return outputString;
    }

    /**
     * GOOD: uses StringBuffer to avoid garbage creation.
     */
    public static String readFileNoGarbage(String filename) throws IOException {
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();

        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("readFileNoGarbage (StringBuilder) time: " + (endTime - startTime) + " ms");
        return outputStringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        // Use any existing file on the system for demo; here we use a moderate-size one.
        String filename = "src/hust/soict/dsai/garbage/GarbageCreator.java"; // read itself

        System.out.println("=== Garbage Creator Demo ===");
        try {
            String result1 = readFileWithGarbage(filename);
            System.out.println("Chars read (garbage): " + result1.length());
        } catch (IOException e) {
            System.out.println("File not found, skipping garbage demo.");
        }

        try {
            String result2 = readFileNoGarbage(filename);
            System.out.println("Chars read (no garbage): " + result2.length());
        } catch (IOException e) {
            System.out.println("File not found, skipping no-garbage demo.");
        }
    }
}
