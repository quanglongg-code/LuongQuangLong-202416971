import javax.swing.JOptionPane;

public class Double_numbers {
    public static void main(String[] args) {

        String str1 = JOptionPane.showInputDialog("Nhập số thứ 1:");
        double num1 = Double.parseDouble(str1);

        String str2 = JOptionPane.showInputDialog("Nhâp số thứ 2:");
        double num2 = Double.parseDouble(str2);

        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;

        String result = "Tong: " + sum + "\n"
                      + "Hieu: " + diff + "\n"
                      + "Tich: " + prod + "\n";

        if (num2 != 0) {
            double div = num1 / num2;
            result += "Thuong: " + div;
        } else {
            result += "Khong the chia cho 0!";
        }

        JOptionPane.showMessageDialog(null, result);
    }
}