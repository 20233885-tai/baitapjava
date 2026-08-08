import java.util.Scanner;

public class BaiTapTongHop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== MENU ==========");
        System.out.println("1. Tinh tong so chan");
        System.out.println("2. Tinh tong nghich dao");
        System.out.println("3. Kiem tra so nguyen to");
        System.out.println("4. Kiem tra va phan loai tam giac");
        System.out.println("5. Hien thi day Fibonacci");
        System.out.print("Chon bai (1-5): ");

        int chon = sc.nextInt();

        switch (chon) {

            case 1:
                System.out.print("Nhap n: ");
                int n1 = sc.nextInt();
                int tong = 0;

                for (int i = 2; i <= n1; i += 2) {
                    tong += i;
                }

                System.out.println("Tong so chan = " + tong);
                break;

            case 2:
                System.out.print("Nhap n: ");
                int n2 = sc.nextInt();
                double s = 0;

                for (int i = 1; i <= n2; i++) {
                    s += 1.0 / i;
                }

                System.out.println("Tong nghich dao = " + s);
                break;

            case 3:
                System.out.print("Nhap n: ");
                int n3 = sc.nextInt();

                boolean prime = true;

                if (n3 < 2)
                    prime = false;
                else {
                    for (int i = 2; i <= Math.sqrt(n3); i++) {
                        if (n3 % i == 0) {
                            prime = false;
                            break;
                        }
                    }
                }

                if (prime)
                    System.out.println(n3 + " la so nguyen to.");
                else
                    System.out.println(n3 + " khong phai la so nguyen to.");
                break;

            case 4:
                System.out.print("Nhap a: ");
                double a = sc.nextDouble();
                System.out.print("Nhap b: ");
                double b = sc.nextDouble();
                System.out.print("Nhap c: ");
                double c = sc.nextDouble();

                if (a + b > c && a + c > b && b + c > a) {

                    if (a == b && b == c)
                        System.out.println("Tam giac deu");

                    else if (a == b || a == c || b == c) {

                        if (a * a + b * b == c * c ||
                            a * a + c * c == b * b ||
                            b * b + c * c == a * a)
                            System.out.println("Tam giac vuong can");
                        else
                            System.out.println("Tam giac can");
                    }

                    else if (a * a + b * b == c * c ||
                             a * a + c * c == b * b ||
                             b * b + c * c == a * a)
                        System.out.println("Tam giac vuong");

                    else
                        System.out.println("Tam giac thuong");

                } else {
                    System.out.println("Khong phai tam giac.");
                }
                break;

            case 5:
                System.out.print("Nhap n: ");
                int n5 = sc.nextInt();

                int f1 = 0;
                int f2 = 1;

                System.out.print("Day Fibonacci: ");

                for (int i = 1; i <= n5; i++) {
                    System.out.print(f1 + " ");
                    int f3 = f1 + f2;
                    f1 = f2;
                    f2 = f3;
                }
                break;

            default:
                System.out.println("Lua chon khong hop le!");
        }

        sc.close();
    }
}