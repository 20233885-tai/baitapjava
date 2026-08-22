import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Welcome {
    public static void main(String[] args) {

        // Tạo JFrame với tiêu đề "Welcome"
        JFrame frame = new JFrame("Welcome");

        // Đặt kích thước cửa sổ
        frame.setSize(400, 300);

        // Căn giữa màn hình
        frame.setLocationRelativeTo(null);

        // Hiển thị cửa sổ
        frame.setVisible(true);

        // Hiển thị thông báo chào mừng
        JOptionPane.showMessageDialog(
            frame,
            "Welcome to Java Swing",
            "Welcome",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Đóng ứng dụng khi người dùng nhấn OK
        frame.dispose();
        System.exit(0);
    }
}