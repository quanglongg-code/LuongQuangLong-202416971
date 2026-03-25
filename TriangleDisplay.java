import java.util.Scanner;

public class TriangleDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Nhập độ cao của tam giác

        for (int i = 1; i <= n; i++) {
            // Vòng lặp in khoảng trắng để căn giữa tam giác
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Vòng lặp in số lượng dấu sao (*)
            // Số dấu sao ở mỗi dòng là 2*i - 1
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            // Xuống dòng sau khi in xong một hàng
            System.out.println();
        }

        scanner.close();
    }
}