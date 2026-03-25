import java.util.Arrays;
import java.util.Scanner;

public class BaiTap65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập kích thước của mảng
        System.out.print("Nhap so luong phan tu cua mang: ");
        int n = scanner.nextInt();

        // Kiểm tra điều kiện mảng phải có ít nhất 1 phần tử
        if (n <= 0) {
            System.out.println("So luong phan tu phai lon hon 0.");
            return;
        }

        // Khởi tạo mảng với kích thước n do người dùng nhập
        int[] myArray = new int[n];

        // 2. Sử dụng vòng lặp để nhập từng phần tử
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            myArray[i] = scanner.nextInt();
        }

        System.out.println("\nMang ban dau: " + Arrays.toString(myArray));

        // 3. Sắp xếp mảng tăng dần
        Arrays.sort(myArray);
        System.out.println("Mang sau khi sap xep: " + Arrays.toString(myArray));

        // 4. Tính tổng và trung bình
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += myArray[i];
        }

        double average = (double) sum / n;

        System.out.println("Tong cac phan tu: " + sum);
        System.out.println("Gia tri trung binh: " + average);

        scanner.close();
    }
}