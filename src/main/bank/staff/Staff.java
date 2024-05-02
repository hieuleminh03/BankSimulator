package staff;

import user.UserManager;
import user.UserRegisterInformation;

public class Staff {
    public enum StaffStatus {
        BUSY,
        AVAILABLE,
        ON_LEAVE
    }
    private static int staffIdCounter = 0;
    private String staffId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private StaffStatus staffStatus;

    public Staff(String fullName, String email, String phoneNumber, String address) {
        setStaffId(String.valueOf(Staff.staffIdCounter++));
        setFullName(fullName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setStaffStatus(StaffStatus.AVAILABLE);
        printRegisteredStaffInfo();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StaffStatus getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(StaffStatus staffStatus) {
        this.staffStatus = staffStatus;
    }

    public void printRegisteredStaffInfo() {
        System.out.println("Staff " + this.getFullName() + " has been registered successfully");
    }

    // process new user from staff
    public void processNewUser(UserRegisterInformation userRegisterInformation) throws InterruptedException {
        System.out.println("Processing new user register request...");
        setStaffStatus(StaffStatus.BUSY);
        UserManager.getInstance().registerNewUser(userRegisterInformation);
        setStaffStatus(StaffStatus.AVAILABLE);
    }
}