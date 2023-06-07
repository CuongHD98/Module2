package Manage;

import File.FilePATH;
import Function.Create;
import Function.IOFile;
import Function.Input;
import Model.Medicine;
import Model.Validate;

import java.util.List;

public class ManageMedicine {
    IOFile<Medicine> ioFile = new IOFile<>();
    Create create = new Create();
    Input input = new Input();

    public ManageMedicine() {
    }

    public void displayMedicine() {
        List<Medicine> medicines = ioFile.readDataFromFile(FilePATH.Medicine_PATH);
        System.out.println("-------------------Medicine-------------------");
        System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%s",
                "ID", "Name", "Type", "Effect", "TimesUse", "Quantity", "Price", "\n");
        for (Medicine medicine : medicines) {
            System.out.printf("%-5s%-20s%-10s%-30s%-25s%-10s%-10s%s",
                    medicine.getId(), medicine.getName(), medicine.getType(), medicine.getEffect(),
                    medicine.getTimesUse(), medicine.getQuantity(), medicine.getPrice(), "\n");
        }
    }

    public void addMedicine() {
        List<Medicine> medicines = ioFile.readDataFromFile(FilePATH.Medicine_PATH);
        Medicine medicine = create.medicine();
        medicines.add(medicine);
        ioFile.writeDataToFile(medicines, FilePATH.Medicine_PATH);
    }

    public int findIndexByName(String nameMedicine) {
        List<Medicine> medicines = ioFile.readDataFromFile(FilePATH.Medicine_PATH);
        for (int i = 0; i < medicines.size(); i++) {
            if (medicines.get(i).getName().equals(nameMedicine)) return i;
        }
        return -1;
    }

    public void editMedicine() {
        List<Medicine> medicines = ioFile.readDataFromFile(FilePATH.Medicine_PATH);
        String nameMedicine = input.inputString("nameMedicine", Validate.NameMedicine_PATTERN);
        int index = findIndexByName(nameMedicine);
        if (index != -1) {
            Medicine newMedicine = create.medicine();
            newMedicine.setId(medicines.get(index).getId());
            Medicine.setCountIDMedicine(Medicine.getCountIDMedicine() - 1);
            medicines.set(index, newMedicine);
        } else System.out.println("Not found Name!");
        ioFile.writeDataToFile(medicines, FilePATH.Medicine_PATH);
    }

    public void deleteMedicine() {
        List<Medicine> medicines = ioFile.readDataFromFile(FilePATH.Medicine_PATH);
        String nameMedicine = input.inputString("nameMedicine", Validate.NameMedicine_PATTERN);
        int index = findIndexByName(nameMedicine);
        if (index != -1) {
            medicines.remove(index);
        } else System.out.println("Not found ID!");
        ioFile.writeDataToFile(medicines, FilePATH.Medicine_PATH);
    }


    public Medicine findMedicineByName(String nameMedicine) {
        List<Medicine> medicines = ioFile.readDataFromFile(FilePATH.Medicine_PATH);
        int index = findIndexByName(nameMedicine);
        if (index != -1) return medicines.get(index);
        return null;
    }
}
