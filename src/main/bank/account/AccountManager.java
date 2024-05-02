package account;

import user.User;

public class AccountManager {
    private static AccountManager instance;

    private AccountManager() {
    }

    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public void createDefaultAccount(User user) {
        Account defaultAccount = new Account(user);
        user.addAccount(defaultAccount);
        System.out.println("Default account is created for user " + user.getUserRegisterInformation().getFullName());
    }
}
