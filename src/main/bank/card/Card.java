package card;

import account.Account;

import java.util.Calendar;
import java.util.Date;

public class Card {
    private static int cardCount = 1000000000;
    private String cardNumber;
    private Account account; // card belongs to an account
    private String cvv; // as password
    private Date expiredDate;

    public Card(Account account) {
        setCardNumber(String.valueOf(Card.cardCount++));
        System.out.println("Generated Card with CardNumber: " + this.cardNumber);
        setAccount(account);
        // cvv is generated randomly
        setCvv(String.valueOf((int) (Math.random() * 1000)));

        // expired date is 5 years from now
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 5);
        this.expiredDate = c.getTime();

        System.out.println("Card Information: ");
        printCardInfo();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void printCardInfo() {
        System.out.println("Card Number: " + this.cardNumber);
        System.out.println("CVV: " + this.cvv);
        System.out.println("Expired Date: " + this.expiredDate);
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
