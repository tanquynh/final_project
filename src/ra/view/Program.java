package ra.view;

import ra.config.InputMethods;
import ra.models.User;

import static com.sun.webkit.perf.PerfLogger.resetAll;
import static ra.config.ConsoleColor.*;

public class Program {
    public static void main(String[] args) {
        Program program = new Program();
        program.start();
    }

    public void start() {
        System.out.println("Trang web mua sắm");
        System.out.println("Hãy đăng nhập hoặc đăng ký để sử dụng hệ thống");
        int choice;
        do {

            print(BLUE);
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║          😍🧡  KARA 😍😍            ║");
            System.out.println("╟────────┬─────────────────────────────╢");
            System.out.println("║   1    │    👩 Đăng nhập             ║");
            System.out.println("║   2    │    🧒 Đăng ký               ║");
            System.out.println("║   0    │       Thoát                 ║");
            System.out.println("╚════════╧═════════════════════════════╝");
            System.out.println("Nhập vào lựa chọn của bạn 🧡🧡 : ");

            choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
//                    LoginView loginView = new LoginView();
//                    User user;
//                    if ((user = loginView.showLogin()) != null) {
//                        if (user.getRole().equals(Role.ADMIN)) {
//                            showAdminMenu();
//                        } else {
//                            showUserMenu();
//                        }
//                    }
                    break;
                case 2:
                    new UserView().registerUser();
                    start();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (true);


    }
}
