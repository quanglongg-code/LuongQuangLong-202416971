import javax.swing.JOptionPane;

public class PhuongTrinhBacHai226 {
    public static void main(String[] args) {

        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c:"));

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Đây là phương trình bậc nhất");
            double x = -c / b;
            JOptionPane.showMessageDialog(null, "Nghiệm x = " + x);
        } else {
            double delta = b*b - 4*a*c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2*a);
                double x2 = (-b - Math.sqrt(delta)) / (2*a);
                JOptionPane.showMessageDialog(null, "x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2*a);
                JOptionPane.showMessageDialog(null, "Nghiệm kép x = " + x);
            } else {
                JOptionPane.showMessageDialog(null, "Vô nghiệm");
            }
        }
    }
}