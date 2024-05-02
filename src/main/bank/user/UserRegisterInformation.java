package user;

import java.util.Date;

public class UserRegisterInformation {
    private String fullName;
    private Date dob;
    private String address;
    private String phoneNumber;
    private String email;
    private String identificationNumber; // use as username
    private String pinNumber = null; // use as password

    public UserRegisterInformation(String fullName, Date dob, String address, String phoneNumber, String email, String pinNumber, String identificationNumber) {
        setFullName(fullName);
        setDob(dob);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setIdentificationNumber(identificationNumber);
        setPinNumber(pinNumber);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}
