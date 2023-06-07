package manage;

import manager.Manager;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageManager {
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    ManageManager() {
    }
    public void writeDataToFile(List<Manager> managers) {
        try (FileOutputStream fos = new FileOutputStream("Managers.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(managers);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Manager> readDataFromFile() {
        List<Manager> managers = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("Managers.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            managers = (List<Manager>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return managers;
    }





}
