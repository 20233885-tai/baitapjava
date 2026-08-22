import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai5 extends JFrame {
    private JTextField txtN;
    private JTextArea txtArea;
    private JButton btnHienThi;

    public Bai5() {
        setTitle("Hiển thị n số Fibonacci");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Nhập n:"));
        txtN = new JTextField(10);
        topPanel.add(txtN);
        btnHienThi = new JButton("Hiển thị");
        topPanel.add(btnHienThi);
        add(topPanel, BorderLayout.NORTH);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtArea);
        add(scrollPane, BorderLayout.CENTER);

        btnHienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hienThiFibonacci();
            }
        });
    }

    private void hienThiFibonacci() {
        try {
            int n = Integer.parseInt(txtN.getText());
            if (n <= 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            StringBuilder sb = new StringBuilder();
            long f0 = 0, f1 = 1, fn = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0) fn = f0;
                else if (i == 1) fn = f1;
                else {
                    fn = f0 + f1;
                    f0 = f1;
                    f1 = fn;
                }
                sb.append(fn).append(i < n - 1 ? ", " : "");
            }
            txtArea.setText(sb.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai5().setVisible(true));
    }
}
