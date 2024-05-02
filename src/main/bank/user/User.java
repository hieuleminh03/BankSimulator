package user;

import account.Account;
import staff.Staff;
import staff.StaffManager;

import java.util.ArrayList;

public class User {
    private UserRegisterInformation userRegisterInformation;
    private ArrayList<Account> accounts = new ArrayList<>(); // list of accounts, by default 1 account is added

    public User(UserRegisterInformation userRegisterInformation) {
        this.userRegisterInformation = userRegisterInformation;
        // add default account
        Account defaultAccount = new Account(this);
        this.addAccount(defaultAccount); // default account is added
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public UserRegisterInformation getUserRegisterInformation() {
        return userRegisterInformation;
    }

    public void setUserRegisterInformation(UserRegisterInformation userRegisterInformation) {
        this.userRegisterInformation = userRegisterInformation;
    }

    // later this should be a transaction
    public void updatePinNumber(String newPinNumber) {
        this.userRegisterInformation.setPinNumber(newPinNumber);
    }

    // later this should be a transaction
    public void registerNewAccount() {
        // call a staff to process
        Staff staff = StaffManager.getInstance().getAvailableStaff();
        if (staff != null) {
            System.out.println("Staff " + staff.getStaffId() + " is processing new account for user " + this.userRegisterInformation.getFullName());
        } else {
            System.out.println("No staff available to process new account, try again later");
        }

    }
}
