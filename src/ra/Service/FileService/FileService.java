package ra.Service.FileService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ra.constant.Containt.FIlePath.COMMON_PATH;

public class FileService <T>{
    private File file;
    public FileService() {

    }
    public FileService(String filePath) {
        File dataDir = new File(COMMON_PATH);
        if(!dataDir.exists()) {
            dataDir.mkdir();
        }
        this.file = new File(COMMON_PATH + filePath);
        try{
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi khởi tạo file");
        }
    }

    public boolean saveToFile(List<T> list, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(list);
            outputStream.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public List<T> findAll() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            List<T> list = (List<T>) inputStream.readObject();
            inputStream.close();
            return list;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return new ArrayList<>();
        }
    }


}
