package Manage;

import Function.Create;
import Function.IOFile;
import Function.InputString;
import Model.Medicine;

import java.util.List;

public class ManageMedicine {
    public static final String Medicine_PATH = "C:\\Users\\HDC\\Desktop\\Module2\\Pharmacity\\src\\File\\Medicine.dat";
    IOFile<Medicine> ioFile = new IOFile<>();
    Create create = new Create();
    InputString inputString = new InputString();

    public ManageMedicine() {
    }

    public void displayMedicine() {
        List<Medicine> medicines = ioFile.readDataFromFile(Medicine_PATH);
        for (Medicine medicine : medicines) {
            System.out.println(medicine);
        }
    }

    public void addMedicine() {
        List<Medicine> medicines = ioFile.readDataFromFile(Medicine_PATH);
        Medicine medicine = create.createMedicine(Medicine_PATH);
        medicines.add(medicine);
        ioFile.writeDataToFile(medicines, Medicine_PATH);
    }

    public int findIndexByID(int id) {
        List<Medicine> medicines = ioFile.readDataFromFile(Medicine_PATH);
        for (int i = 0; i < medicines.size(); i++) {
            if (medicines.get(i).getId() == id) return i;
        }
        return -1;
    }

    public void editMedicine() {
        List<Medicine> medicines = ioFile.readDataFromFile(Medicine_PATH);
        int id = inputString.inputInt("id", Validate.Quantity_PATTERN);
        int index = findIndexByID(id);
        if (index != -1) {
            Medicine newMedicine = create.createMedicine(Medicine_PATH);
            newMedicine.setId(medicines.get(index).getId());
            Medicine.countIDMedicine--;
            medicines.set(index, newMedicine);
        } else System.out.println("Not found ID!");
        ioFile.writeDataToFile(medicines, Medicine_PATH);
    }

    public void deleteMedicine() {
        List<Medicine> medicines = ioFile.readDataFromFile(Medicine_PATH);
        int id = inputString.inputInt("id", Validate.Quantity_PATTERN);
        int index = findIndexByID(id);
        if (index != -1) {
            medicines.remove(index);
        } else System.out.println("Not found ID!");
        ioFile.writeDataToFile(medicines, Medicine_PATH);
    }

    public int findIndexByName(String nameMedicine) {
        List<Medicine> medicines = ioFile.readDataFromFile(Medicine_PATH);
        for (int i = 0; i < medicines.size(); i++) {
            if (medicines.get(i).getNameMedicine().equals(nameMedicine)) return i;
        }
        return -1;
    }

    public void searchMedicineByName() {
        List<Medicine> medicines = ioFile.readDataFromFile(Medicine_PATH);
        String nameMedicine = inputString.inputString("nameMedicine", Validate.NameMedicine_PATTERN);
        int index = findIndexByName(nameMedicine);
        if (index != -1) System.out.println(medicines.get(index));
        else System.out.println("Not found NameMedicine!");
    }
}


