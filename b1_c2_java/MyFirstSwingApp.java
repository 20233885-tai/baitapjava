import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFirstSwingApp {
    public static void main(String[] args) {

        // Tạo cửa sổ JFrame
        JFrame frame = new JFrame("My First Swing App");

        // Đặt kích thước cửa sổ: rộng 400, cao 300
        frame.setSize(400, 300);

        // Căn giữa cửa sổ trên màn hình
        frame.setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn nút X
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo JLabel hiển thị "Hello World"
        JLabel label = new JLabel("Hello World", SwingConstants.CENTER);

        // Thêm JLabel vào JFrame
        frame.add(label);

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}