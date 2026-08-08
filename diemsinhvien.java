import java.util.Scanner;

public class Diemsinhvien {
    public static void diemsinhvien (String[] args) {
        Scanner sc = new Scanner(System.in);

        String maSV;
        String hoTen;
        double chuyenCan, giuaKy, cuoiKy;

        // Nhập mã sinh viên
        System.out.print("Nhập mã sinh viên: ");
        maSV = sc.nextLine();

        // Nhập họ tên
        System.out.print("Nhập họ tên: ");
        hoTen = sc.nextLine();

        // Nhập điểm chuyên cần
        do {
            System.out.print("Nhập điểm chuyên cần (0-10): ");
            chuyenCan = sc.nextDouble();

            if (chuyenCan < 0 || chuyenCan > 10) {
                System.out.println("Điểm không hợp lệ! Vui lòng nhập lại.");
            }
        } while (chuyenCan < 0 || chuyenCan > 10);

        // Nhập điểm giữa kỳ
        do {
            System.out.print("Nhập điểm giữa kỳ (0-10): ");
            giuaKy = sc.nextDouble();

            if (giuaKy < 0 || giuaKy > 10) {
                System.out.println("Điểm không hợp lệ! Vui lòng nhập lại.");
            }
        } while (giuaKy < 0 || giuaKy > 10);

        // Nhập điểm cuối kỳ
        do {
            System.out.print("Nhập điểm cuối kỳ (0-10): ");
            cuoiKy = sc.nextDouble();

            if (cuoiKy < 0 || cuoiKy > 10) {
                System.out.println("Điểm không hợp lệ! Vui lòng nhập lại.");
            }
        } while (cuoiKy < 0 || cuoiKy > 10);

        // Tính điểm tổng kết
        double tongKet = chuyenCan * 0.10
                       + giuaKy * 0.30
                       + cuoiKy * 0.60;

        // Xếp loại
        String xepLoai;

        if (tongKet >= 8.5) {
            xepLoai = "A";
        } else if (tongKet >= 7.0) {
            xepLoai = "B";
        } else if (tongKet >= 5.5) {
            xepLoai = "C";
        } else if (tongKet >= 4.0) {
            xepLoai = "D";
        } else {
            xepLoai = "F";
        }

        // Hiển thị kết quả
        System.out.println("\n===== KẾT QUẢ =====");
        System.out.println("Mã sinh viên: " + maSV);
        System.out.println("Họ tên: " + hoTen);
        System.out.printf("Điểm chuyên cần: %.2f%n", chuyenCan);
        System.out.printf("Điểm giữa kỳ: %.2f%n", giuaKy);
        System.out.printf("Điểm cuối kỳ: %.2f%n", cuoiKy);
        System.out.printf("Điểm tổng kết: %.2f%n", tongKet);
        System.out.println("Xếp loại: " + xepLoai);

        sc.close();
    }
}