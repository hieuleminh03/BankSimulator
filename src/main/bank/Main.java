import staff.Staff;
import staff.StaffManager;
import user.UserRegisterInformation;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        // add some staff
        StaffManager staffManager = StaffManager.getInstance();
        staffManager.addStaff(new Staff("Hieu", "test@ok.com", "0123456789","Hanoi"));
        staffManager.addStaff(new Staff("Hoang", "test2@ok.com", "012343789","HCM"));
        staffManager.addStaff(new Staff("Huy", "test3@ok.com", "0123456734","Hue"));

        // add two users
        UserRegisterInformation userRegisterInformation = new UserRegisterInformation("Hieu", new Date(), "Ha Noi", "0123456789", "test@user.com","123456", "2044097545");
        UserRegisterInformation userRegisterInformation2 = new UserRegisterInformation("Hoang", new Date(), "Ha Noi", "0123456789", "test2@user.com", "123456", "204409745");

        staffManager.getAvailableStaff().processNewUser(userRegisterInformation);
        staffManager.getAvailableStaff().processNewUser(userRegisterInformation2);
    }
}
