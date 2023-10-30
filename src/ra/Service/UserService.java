package ra.Service;

import ra.Service.FileService.FileService;
import ra.models.User;
import ra.repository.IShop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IShop<User> {
    private FileService file;
    private List<User> users = new ArrayList<>();

    public UserService(FileService file) {
        this.file = file;
    }
    @Override
    public void save(User user) {
        List<User> users = file.findAll();
        boolean updated = false;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(user.getUsername())) {
                users.set(i, user);  // Cập nhật thông tin người dùng
                updated = true;
                break;
            }
        }

        if (!updated) {
            users.add(user);
        }

        file.saveToFile(users);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        List<User> users = file.findAll();
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public int findByindex(int id) {
        return 0;
    }
    public int autoInc() {
        int max = 0;
       List<User> users = findAll();
       if(users != null) {
           for (User user: users) {
               if(max < user.getId()) {
                   max = user.getId();
               }
           }
           return max +1;
       }
       else {
           return max = 1;
       }
    }
}
