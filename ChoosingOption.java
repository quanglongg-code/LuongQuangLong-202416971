import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {

        int option = JOptionPane.showConfirmDialog(
                null,
                "Ban co muon tiep tuc khong?",
                "Lua chon",
                JOptionPane.YES_NO_CANCEL_OPTION
        );

        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Ban chon YES");
        } else if (option == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Ban chon NO");
        } else {
            JOptionPane.showMessageDialog(null, "Ban chon CANCEL");
        }
    }
}