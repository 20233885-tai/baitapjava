package com.student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentManagementApp extends JFrame {

    private JTextField txtMaSV, txtTenSV, txtMonHoc, txtChuyenCan, txtGiuaKi, txtCuoiKi;
    private JButton btnThem, btnSua, btnXoa, btnXoaTatCa;
    private JTable table;
    private DefaultTableModel tableModel;

    public StudentManagementApp() {
        setTitle("Quản Lý Điểm Sinh Viên");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị giữa màn hình
        setLayout(new BorderLayout());

        // Top Panel chứa Form và Buttons
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setPreferredSize(new Dimension(850, 260));

        // Tiêu đề
        JLabel lblTitle = new JLabel("Quản Lý Điểm Sinh Viên");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setBounds(330, 20, 250, 30);
        formPanel.add(lblTitle);

        // Labels
        JLabel lblMaSV = new JLabel("Mã SV");
        lblMaSV.setBounds(40, 70, 80, 25);
        formPanel.add(lblMaSV);

        JLabel lblTenSV = new JLabel("Tên SV");
        lblTenSV.setBounds(40, 110, 80, 25);
        formPanel.add(lblTenSV);

        JLabel lblMonHoc = new JLabel("Môn Học");
        lblMonHoc.setBounds(40, 150, 80, 25);
        formPanel.add(lblMonHoc);

        JLabel lblChuyenCan = new JLabel("Chuyên Cần");
        lblChuyenCan.setBounds(40, 190, 80, 25);
        formPanel.add(lblChuyenCan);

        JLabel lblGiuaKi = new JLabel("Giữa Kì");
        lblGiuaKi.setBounds(200, 190, 60, 25);
        formPanel.add(lblGiuaKi);

        JLabel lblCuoiKi = new JLabel("Cuối Kì");
        lblCuoiKi.setBounds(340, 190, 60, 25);
        formPanel.add(lblCuoiKi);

        JLabel lblFormula = new JLabel("Công thức: Tổng kết = CC*10% + GK*30% + CK*60%");
        lblFormula.setFont(new Font("Tahoma", Font.ITALIC, 12));
        lblFormula.setForeground(Color.DARK_GRAY);
        lblFormula.setBounds(40, 225, 400, 25);
        formPanel.add(lblFormula);

        // TextFields
        txtMaSV = new JTextField();
        txtMaSV.setBounds(120, 70, 340, 25);
        formPanel.add(txtMaSV);

        txtTenSV = new JTextField();
        txtTenSV.setBounds(120, 110, 340, 25);
        formPanel.add(txtTenSV);

        txtMonHoc = new JTextField();
        txtMonHoc.setBounds(120, 150, 340, 25);
        formPanel.add(txtMonHoc);

        txtChuyenCan = new JTextField();
        txtChuyenCan.setBounds(120, 190, 60, 25);
        formPanel.add(txtChuyenCan);

        txtGiuaKi = new JTextField();
        txtGiuaKi.setBounds(260, 190, 60, 25);
        formPanel.add(txtGiuaKi);

        txtCuoiKi = new JTextField();
        txtCuoiKi.setBounds(400, 190, 60, 25);
        formPanel.add(txtCuoiKi);

        // Buttons
        btnThem = new JButton("Thêm");
        btnThem.setBounds(500, 70, 75, 30);
        formPanel.add(btnThem);

        btnSua = new JButton("Sửa");
        btnSua.setBounds(585, 70, 75, 30);
        formPanel.add(btnSua);

        btnXoa = new JButton("Xóa");
        btnXoa.setBounds(670, 70, 75, 30);
        formPanel.add(btnXoa);

        btnXoaTatCa = new JButton("Xóa Tất Cả");
        btnXoaTatCa.setBounds(755, 70, 95, 30);
        formPanel.add(btnXoaTatCa);

        add(formPanel, BorderLayout.NORTH);

        // Table Panel
        String[] columns = {"MSV", "Tên SV", "Môn Học", "Chuyên Cần", "Giữa Kì", "Cuối Kì", "Tổng Kết"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Gắn sự kiện (Events)
        addEvents();
    }

    private void addEvents() {
        // Nút Thêm
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput()) {
                    double cc = Double.parseDouble(txtChuyenCan.getText().trim());
                    double gk = Double.parseDouble(txtGiuaKi.getText().trim());
                    double ck = Double.parseDouble(txtCuoiKi.getText().trim());
                    double tongKet = cc * 0.1 + gk * 0.3 + ck * 0.6;
                    tongKet = Math.round(tongKet * 100.0) / 100.0;
                    
                    tableModel.addRow(new Object[]{
                            txtMaSV.getText(),
                            txtTenSV.getText(),
                            txtMonHoc.getText(),
                            txtChuyenCan.getText(),
                            txtGiuaKi.getText(),
                            txtCuoiKi.getText(),
                            tongKet
                    });
                    clearFields();
                }
            }
        });

        // Nút Sửa
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    if (validateInput()) {
                        double cc = Double.parseDouble(txtChuyenCan.getText().trim());
                        double gk = Double.parseDouble(txtGiuaKi.getText().trim());
                        double ck = Double.parseDouble(txtCuoiKi.getText().trim());
                        double tongKet = cc * 0.1 + gk * 0.3 + ck * 0.6;
                        tongKet = Math.round(tongKet * 100.0) / 100.0;

                        tableModel.setValueAt(txtMaSV.getText(), selectedRow, 0);
                        tableModel.setValueAt(txtTenSV.getText(), selectedRow, 1);
                        tableModel.setValueAt(txtMonHoc.getText(), selectedRow, 2);
                        tableModel.setValueAt(txtChuyenCan.getText(), selectedRow, 3);
                        tableModel.setValueAt(txtGiuaKi.getText(), selectedRow, 4);
                        tableModel.setValueAt(txtCuoiKi.getText(), selectedRow, 5);
                        tableModel.setValueAt(tongKet, selectedRow, 6);
                        clearFields();
                    }
                } else {
                    JOptionPane.showMessageDialog(StudentManagementApp.this, "Vui lòng chọn sinh viên để sửa!");
                }
            }
        });

        // Nút Xóa
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(StudentManagementApp.this, 
                            "Bạn có chắc chắn muốn xóa sinh viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                        clearFields();
                    }
                } else {
                    JOptionPane.showMessageDialog(StudentManagementApp.this, "Vui lòng chọn sinh viên để xóa!");
                }
            }
        });

        // Nút Xóa Tất Cả
        btnXoaTatCa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableModel.getRowCount() > 0) {
                    int confirm = JOptionPane.showConfirmDialog(StudentManagementApp.this, 
                            "Bạn có chắc chắn muốn xóa tất cả sinh viên?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.setRowCount(0);
                        clearFields();
                    }
                }
            }
        });

        // Sự kiện click vào bảng để đổ dữ liệu lên Form
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    txtMaSV.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    txtTenSV.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    txtMonHoc.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    txtChuyenCan.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    txtGiuaKi.setText(tableModel.getValueAt(selectedRow, 4).toString());
                    txtCuoiKi.setText(tableModel.getValueAt(selectedRow, 5).toString());
                }
            }
        });
    }

    private boolean validateInput() {
        if (txtMaSV.getText().trim().isEmpty() || 
            txtTenSV.getText().trim().isEmpty() || 
            txtMonHoc.getText().trim().isEmpty() || 
            txtChuyenCan.getText().trim().isEmpty() ||
            txtGiuaKi.getText().trim().isEmpty() ||
            txtCuoiKi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return false;
        }
        try {
            double cc = Double.parseDouble(txtChuyenCan.getText().trim());
            double gk = Double.parseDouble(txtGiuaKi.getText().trim());
            double ck = Double.parseDouble(txtCuoiKi.getText().trim());
            if (cc < 0 || cc > 10 || gk < 0 || gk > 10 || ck < 0 || ck > 10) {
                JOptionPane.showMessageDialog(this, "Các điểm phải từ 0 đến 10!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm phải là số hợp lệ!");
            return false;
        }
        return true;
    }

    private void clearFields() {
        txtMaSV.setText("");
        txtTenSV.setText("");
        txtMonHoc.setText("");
        txtChuyenCan.setText("");
        txtGiuaKi.setText("");
        txtCuoiKi.setText("");
        txtMaSV.requestFocus();
    }

    public static void main(String[] args) {
        // Sử dụng giao diện System Look And Feel (giống Windows)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentManagementApp().setVisible(true);
            }
        });
    }
}
