package ra.view;

import ra.Service.FileService.FileService;
import ra.Service.UserService;
import ra.config.InputMethods;
import ra.config.Validate;
import ra.models.User;

import java.util.List;

import static ra.config.ConsoleColor.*;
import static ra.constant.Containt.ADMIN_CODE;
import static ra.constant.Containt.Role.*;

public class UserView {
    private UserService userService;

    public UserView(UserService userService) {
        this.userService = userService;
    }

    public User registerUser() {
        List<User> users = userService.findAll();
        User user = new User();
        printlnMess("Vui lòng đăng ký tài khoản !!");
        System.out.println("Hãy chọn role của bạn 1: ADMIN            2: USER: ");
        int role = InputMethods.getInteger();
        user.setId(userService.autoInc());
        if (role == ADMIN) {
            user.setRole(role);
            printlnMess("Nhập vào mã xác nhận ADMIN :");
            String adminCode = InputMethods.getString();
            if (!adminCode.equals(ADMIN_CODE)) {
                printlnError("Mã xác thực không đúng vui lòng nhập lại!!");
                registerUser();

            }
        } else if(role == USER) {
            user.setRole(role);
        }
        System.out.println();
        while (true) {
            System.out.println("Hãy nhâp vào họ và tên đầy đủ");
            String fullName = InputMethods.scanner().nextLine();
            if (Validate.isValidFullName(fullName)) {
                user.setFullName(fullName);
                break;
            }
        }

        while (true) {
            System.out.println("Hãy nhập vào tên đăng nhập");
            String username = InputMethods.scanner().nextLine();

            if (Validate.isValidFullName(username)) {
                boolean isUsernameAvailable = true;
                if(users != null) {
                    for (User user1 : userService.findAll()) {
                        if (user1.getUsername().trim().equals(username)) {
                            printlnError("Tên đăng nhập đã được sử dụng, mời nhập tên đăng nhập mới");
                            isUsernameAvailable = false;
                            break;
                        }
                    }
                } else {
                    isUsernameAvailable = false;
                    break;
                }


                if (isUsernameAvailable) {
                    user.setUsername(username);
                    break; // Kết thúc vòng lặp khi tên đăng nhập hợp lệ và không trùng lặp
                }
            }
        }

        while (true) {
            System.out.println("Hãy nhâp vào password");
            String password = InputMethods.scanner().nextLine();
            if (Validate.isValidPassword(password)) {
                user.setPassword(password);
                break;
            }
        }

        while (true) {
            System.out.println("Hãy nhập vào email đăng ký");
            String email = InputMethods.scanner().nextLine();

            if (Validate.isValidFullName(email)) {
                boolean isEmailAvailable = true;

                if(users != null ) {
                    for (User user1 : users) {
                        if (user1.getUsername().trim().equals(email)) {
                            printlnError("Email đã được sử dụng, mời nhập email mới");
                            isEmailAvailable = false;
                            break;
                        }
                    }
                } else {
                    isEmailAvailable = false;
                    break;
                }

                if (isEmailAvailable) {
                    user.setEmail(email);
                    break; // Kết thúc vòng lặp khi  email hợp lệ và không trùng lặp
                }
            }
        }

        while (true) {
            System.out.println("Hãy nhập vào số điện thoại");
            String phone = InputMethods.scanner().nextLine();

            if (Validate.isValidPhone(phone)) {
                boolean isPhoneAvailable = true;
                if(users != null) {
                    for (User user1 : userService.findAll()) {
                        if (user1.getUsername().trim().equals(phone)) {
                            printlnError("Số điện thoại đã được sử dụng, mời nhập số điện thoại mới");
                            isPhoneAvailable = false;
                            break;
                        }
                    }
                } else {
                    isPhoneAvailable = false;
                    break;
                }

                if (isPhoneAvailable) {
                    user.setPhone(phone);
                    break; // Kết thúc vòng lặp khi  phone hợp lệ và không trùng lặp
                }
            }
        }

        while (true) {
            System.out.println("Hãy nhâp vào địa chỉ");
            String address = InputMethods.scanner().nextLine();
            if (Validate.isValidAddress(address)) {
                user.setAddress(address);
                break;
            }
        }
        userService.save(user);
        printlnSuccess("Đăng ký thành công !");
        return user;
    }

}
