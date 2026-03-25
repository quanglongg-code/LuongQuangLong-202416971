import java.util.Scanner;

public class BaiTap64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = -1;
        int month = -1;

        while (true) {
            // Nhập và kiểm tra năm
            System.out.print("Enter year (e.g., 2026): ");
            String yearInput = scanner.nextLine().trim();
            if (yearInput.matches("\\d+") && yearInput.length() >= 1) {
                year = Integer.parseInt(yearInput);
                if (year < 0) {
                    System.out.println("Invalid year. Please enter a non-negative number.");
                    continue;
                }
            } else {
                System.out.println("Invalid year format. Please try again.");
                continue;
            }

            // Nhập và kiểm tra tháng
            System.out.print("Enter month (Name, Abbreviation, 3 letters, or Number): ");
            String monthInput = scanner.nextLine().trim();
            month = parseMonth(monthInput);

            if (month == -1) {
                System.out.println("Invalid month. Please try again.");
                continue;
            }

            // Nếu cả năm và tháng đều hợp lệ thì thoát vòng lặp
            break;
        }

        // Tính số ngày
        int days = getDaysInMonth(month, year);
        System.out.println("Number of days: " + days);
        scanner.close();
    }

    // Hàm chuyển đổi các kiểu nhập tháng về dạng số (1-12)
    public static int parseMonth(String input) {
        input = input.toLowerCase();
        if (input.equals("january") || input.equals("jan.") || input.equals("jan") || input.equals("1")) return 1;
        if (input.equals("february") || input.equals("feb.") || input.equals("feb") || input.equals("2")) return 2;
        if (input.equals("march") || input.equals("mar.") || input.equals("mar") || input.equals("3")) return 3;
        if (input.equals("april") || input.equals("apr.") || input.equals("apr") || input.equals("4")) return 4;
        if (input.equals("may") || input.equals("5")) return 5;
        if (input.equals("june") || input.equals("jun") || input.equals("6")) return 6;
        if (input.equals("july") || input.equals("jul") || input.equals("7")) return 7;
        if (input.equals("august") || input.equals("aug.") || input.equals("aug") || input.equals("8")) return 8;
        if (input.equals("september") || input.equals("sept.") || input.equals("sep") || input.equals("9")) return 9;
        if (input.equals("october") || input.equals("oct.") || input.equals("oct") || input.equals("10")) return 10;
        if (input.equals("november") || input.equals("nov.") || input.equals("nov") || input.equals("11")) return 11;
        if (input.equals("december") || input.equals("dec.") || input.equals("dec") || input.equals("12")) return 12;
        return -1;
    }

    // Hàm kiểm tra năm nhuận 
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    // Hàm lấy số ngày trong tháng 
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }
}