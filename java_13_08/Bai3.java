import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai3 extends JFrame {
    private JTextField txtA, txtB, txtKetQua;
    private JButton btnGiai;

    public Bai3() {
        setTitle("Giải phương trình bậc nhất (ax + b = 0)");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Nhập a:"));
        txtA = new JTextField();
        add(txtA);

        add(new JLabel("Nhập b:"));
        txtB = new JTextField();
        add(txtB);

        add(new JLabel("Kết quả:"));
        txtKetQua = new JTextField();
        txtKetQua.setEditable(false);
        add(txtKetQua);

        btnGiai = new JButton("Giải");
        add(btnGiai);

        btnGiai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giaiPhuongTrinh();
            }
        });
    }

    private void giaiPhuongTrinh() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());

            if (a == 0) {
                if (b == 0) {
                    txtKetQua.setText("Phương trình vô số nghiệm");
                } else {
                    txtKetQua.setText("Phương trình vô nghiệm");
                }
            } else {
                double x = -b / a;
                txtKetQua.setText("x = " + x);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai3().setVisible(true));
    }
}
