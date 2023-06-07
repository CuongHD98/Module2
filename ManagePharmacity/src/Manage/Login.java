package Manage;

import File.FilePATH;
import Function.IOFile;
import Function.Input;
import Model.Account;
import Model.Validate;

import java.util.List;
public class Login {
    IOFile<Account> ioFile = new IOFile<>();
    Input input = new Input();
    public Account login() {
        List<Account> accounts = ioFile.readDataFromFile(FilePATH.Account_PATH);
        String username = input.inputString("username", Validate.UserName_PATTERN);
        String password = input.inputString("password", Validate.PassWord_PATTERN);
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                System.out.println("Login Success!");
                return account;
            }
        }
        System.out.println("Not found Account!");
        System.out.println("Enter again!");
        return null;
    }
}
