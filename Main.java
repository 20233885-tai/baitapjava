import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        try {
            // Nhập số thứ nhất
            String input1 = JOptionPane.showInputDialog(
                    null,
                    "Nhập số thứ nhất:"
            );

            double so1 = Double.parseDouble(input1);

            // Nhập số thứ hai
            String input2 = JOptionPane.showInputDialog(
                    null,
                    "Nhập số thứ hai:"
            );

            double so2 = Double.parseDouble(input2);

            // Tính tổng
            double tong = so1 + so2;

            // Hiển thị kết quả
            JOptionPane.showMessageDialog(
                    null,
                    "Tổng = " + tong,
                    "Kết quả",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException e) {

            // Xử lý khi nhập không phải số
            JOptionPane.showMessageDialog(
                    null,
                    "Lỗi! Vui lòng nhập số.",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (NullPointerException e) {

            // Xử lý khi người dùng bấm Cancel
            JOptionPane.showMessageDialog(
                    null,
                    "Bạn đã hủy nhập dữ liệu.",
                    "Thông báo",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}