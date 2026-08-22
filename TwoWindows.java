import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TwoWindows {
    public static void main(String[] args) {

        // Tạo JFrame chính
        JFrame mainFrame = new JFrame("Main Window");

        // Kích thước JFrame chính: 400x300
        mainFrame.setSize(400, 300);

        // Căn giữa màn hình
        mainFrame.setLocationRelativeTo(null);

        // Đóng chương trình khi nhấn X
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo nút Open Child Window
        JButton button = new JButton("Open Child Window");

        // Thêm nút vào JFrame chính
        mainFrame.add(button);

        // Xử lý sự kiện khi nhấn nút
        button.addActionListener(e -> {

            // Tạo JFrame thứ hai
            JFrame childFrame = new JFrame("Child Window");

            // Kích thước JFrame thứ hai: 200x200
            childFrame.setSize(200, 200);

            // Tạo JLabel và căn giữa
            JLabel label = new JLabel(
                "Child Window",
                SwingConstants.CENTER
            );

            // Thêm JLabel vào JFrame thứ hai
            childFrame.add(label);

            // Căn giữa cửa sổ con
            childFrame.setLocationRelativeTo(mainFrame);

            // Đóng riêng cửa sổ con khi nhấn X
            childFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Hiển thị cửa sổ con
            childFrame.setVisible(true);
        });

        // Hiển thị JFrame chính
        mainFrame.setVisible(true);
    }
}