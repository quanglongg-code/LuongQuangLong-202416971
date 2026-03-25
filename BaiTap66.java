import java.util.Scanner;

public class BaiTap66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập kích thước ma trận
        System.out.print("Nhap so hang cua ma tran: ");
        int rows = scanner.nextInt();
        System.out.print("Nhap so cot cua ma tran: ");
        int cols = scanner.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];

        // 2. Nhập dữ liệu cho ma trận thứ nhất
        System.out.println("Nhap cac phan tu cho ma tran thu nhat:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Ma tran 1 [%d][%d]: ", i, j);
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // 3. Nhập dữ liệu cho ma trận thứ hai
        System.out.println("Nhap cac phan tu cho ma tran thu hai:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Ma tran 2 [%d][%d]: ", i, j);
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // 4. Thực hiện phép cộng hai ma trận
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // 5. Hiển thị kết quả
        System.out.println("\nKet qua cong hai ma tran la:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sumMatrix[i][j] + "\t");
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }

        scanner.close();
    }
}