package Function;

import Manage.Validate;
import Model.*;

import java.util.Collections;
import java.util.List;

public class Create {
    InputString inputString = new InputString();
    IOFile<Medicine> ioFileM = new IOFile<>();
    IOFile<Person> ioFileP = new IOFile<>();

    public Medicine createMedicine(String path) {
        List<Medicine> medicines = ioFileM.readDataFromFile(path);
        String nameMedicine = inputString.inputNotDuplicated("namMedicine", Validate.Name_PATTERN, Collections.singletonList(medicines), path);
        String typeMedicine = inputString.inputString("typeMedicine", Validate.TypeMedicine_PATTERN);
        String effect = inputString.inputString("effect", Validate.EffectMedicine_PATTERN);
        String timesUse = inputString.inputString("timesUse", Validate.TimesUseMedicine_PATTERN);
        int quantity = inputString.inputInt("quantity", Validate.Quantity_PATTERN);
        float price = inputString.inputFloat("price", Validate.Price_PATTERN);
        return new Medicine(nameMedicine, typeMedicine, effect, timesUse, quantity, price);
    }

    public Person createPerson(String path) {
        List<Person> personList = ioFileP.readDataFromFile(path);
        String userName = inputString.inputNotDuplicated("userName", Validate.UserName_PATTERN, Collections.singletonList(personList), path);
        String passWord = inputString.inputString("passWord", Validate.PassWord_PATTERN);
        String name = inputString.inputString("name", Validate.Name_PATTERN);
        String gender = inputString.inputString("gender", Validate.Gender_PATTERN);
        String birthday = inputString.inputString("birthday", Validate.Birthday_PATTERN);
        String phone = inputString.inputString("phone", Validate.Phone_PATTERN);
        String email = inputString.inputString("email", Validate.Email_PATTERN);
        return new Person(userName, passWord, name, gender, birthday, phone, email);
    }

    public Manager createManager(String path) {
        Person person = createPerson(path);
        return new Manager(person.getUserName(), person.getPassWord(), person.getName(), person.getGender(),
                person.getBirthDay(), person.getPhone(), person.getEmail());
    }

    public Customer createCustomer(String path) {
        Person person = createPerson(path);
        return new Customer(person.getUserName(), person.getPassWord(), person.getName(), person.getGender(),
                person.getBirthDay(), person.getPhone(), person.getEmail());
    }

    public Pharmacits createPharmacist(String path) {
        Person person = createPerson(path);
        int daysOn = inputString.inputInt("daysOn", Validate.Quantity_PATTERN);
        int daysOff = inputString.inputInt("daysOn", Validate.Quantity_PATTERN);
        int timesCheckInLate = inputString.inputInt("timesCheckInLate", Validate.Quantity_PATTERN);
        int timesCheckOutSoon = inputString.inputInt("timesCheckOutSoon", Validate.Quantity_PATTERN);
        return new Pharmacits(person.getUserName(), person.getPassWord(), person.getName(), person.getGender(),
                person.getBirthDay(), person.getPhone(), person.getEmail(), daysOn, daysOff, timesCheckInLate, timesCheckOutSoon);
    }
}
