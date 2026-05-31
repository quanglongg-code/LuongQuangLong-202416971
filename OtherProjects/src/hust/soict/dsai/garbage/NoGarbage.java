package hust.soict.dsai.garbage;

/**
 * NoGarbage demonstrates efficient string construction using StringBuilder.
 * Contrast with GarbageCreator which uses + and floods the heap with short-lived objects.
 */
public class NoGarbage {

    public static void main(String[] args) {
        final int N = 100_000;

        // Bad approach: allocates N intermediate Strings
        long start = System.currentTimeMillis();
        String bad = "";
        for (int i = 0; i < N; i++) {
            bad += "x";
        }
        System.out.println("Bad (+=) time: " + (System.currentTimeMillis() - start) + " ms, length=" + bad.length());

        // Good approach: reuses internal char array
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("x");
        }
        String good = sb.toString();
        System.out.println("Good (StringBuilder) time: " + (System.currentTimeMillis() - start) + " ms, length=" + good.length());

        System.out.println("\nRule of thumb:");
        System.out.println("  Single-thread concatenation in loops  -> StringBuilder");
        System.out.println("  Multi-thread shared concatenation     -> StringBuffer");
        System.out.println("  Simple one-liner concat               -> String (compiler optimises it)");
    }
}
