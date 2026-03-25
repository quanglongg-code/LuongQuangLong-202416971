import javax.swing.JOptionPane;

public class Vidu61 {
    public static void main(String[] args) {

        String[] options = {"I do", "I don't"};

        int choice = JOptionPane.showOptionDialog(
                null,
                "Bạn có đồng ý không?",
                "Lựa chọn",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == 0) {
            JOptionPane.showMessageDialog(null, "Bạn chọn: I do");
        } else if (choice == 1) {
            JOptionPane.showMessageDialog(null, "Bạn chọn: I don't");
        }

        System.exit(0);
    }
}