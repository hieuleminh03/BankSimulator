package user;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager instance;
    private final List<User> users;

    private UserManager() {
        users = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void registerNewUser(UserRegisterInformation userRegisterInformation) throws InterruptedException {
        if (!checkExistingUser((userRegisterInformation))){
            User user = new User(userRegisterInformation);
            addUser(user);
            System.out.println("User " + user.getUserRegisterInformation().getFullName() + "(" + user.getUserRegisterInformation().getIdentificationNumber() + ")" + " is registered successfully");
            System.out.println("Creating default account for user " + user.getUserRegisterInformation().getFullName());
        } else {
            System.out.println("User " + userRegisterInformation.getFullName() + " is already registered");
        }
        Thread.sleep(3000);
        // TODO: thread sleep is added to simulate processing time, remove it later
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean checkExistingUser(UserRegisterInformation userRegisterInformation){
        for(User user: users){
            if(user.getUserRegisterInformation().getIdentificationNumber().equals(userRegisterInformation.getIdentificationNumber())){
                return true;
            }
        }
        return false;
    }
}