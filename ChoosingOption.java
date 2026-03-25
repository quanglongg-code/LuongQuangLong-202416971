import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {

        int option = JOptionPane.showConfirmDialog(
                null,
                "Bạn có muốn tiếp tục không?",
                "Xác nhận",
                JOptionPane.YES_NO_CANCEL_OPTION
        );

        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Bạn chọn YES");
        } else if (option == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Bạn chọn NO");
        } else if (option == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Bạn chọn CANCEL");
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã đóng cửa sổ");
        }

        System.exit(0);
    }
}