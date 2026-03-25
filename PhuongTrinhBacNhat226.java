import javax.swing.JOptionPane;

public class PhuongTrinhBacNhat226 {
    public static void main(String[] args) {

        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));

        if (a == 0) {
            if (b == 0)
                JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm");
            else
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Nghiệm x = " + x);
        }

        System.exit(0);
    }
}