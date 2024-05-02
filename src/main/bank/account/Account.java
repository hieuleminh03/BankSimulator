package account;


import card.Card;
import user.User;
import user.UserRegisterInformation;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    // this is account for holding money
    // later on should split into different types of accounts
    // for now, card must be attached to account to get the money
    private static int accountCount = 0;
    public enum accountStatus {
        ACTIVE,
        INACTIVE,
        RESTRICTED
    }
    private String accountId;
    private User user;
    private double balance;
    private accountStatus status;
    private ArrayList<Card> cards; // list of cards, by default 1 card is added
    private boolean isDefaultAccount;

    public Account(User user) {
        setStatus(accountStatus.ACTIVE);
        setAccountId(String.valueOf(Account.accountCount++));
        System.out.println("Account ID: " + this.accountId);
        setUser(user);
        // balance is 0 by default
        setBalance(0);
        setDefaultAccount(user.getAccounts().isEmpty()); // is default account if user has no account
        this.user.addAccount(this);
    }

    public Account(User user, double balance) {
        setStatus(accountStatus.ACTIVE);
        // balance is set when creating account
        setAccountId(String.valueOf(Account.accountCount++));
        System.out.println("Account ID: " + this.accountId);
        setUser(user);
        setBalance(balance);
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    // by default, we don't allow to remove card, just set the card's status to inactive
    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void inactiveAccount(){
        this.status = accountStatus.INACTIVE;
    }

    public void activeAccount(){
        this.status = accountStatus.ACTIVE;
    }

    public accountStatus getStatus() {
        return status;
    }

    public void setStatus(accountStatus status) {
        this.status = status;
    }

    public boolean isDefaultAccount() {
        return isDefaultAccount;
    }

    public void setDefaultAccount(boolean defaultAccount) {
        isDefaultAccount = defaultAccount;
    }

    public static void main(String[] args) {
        User user = new User(
                new UserRegisterInformation("Hieu", new Date(), "Hanoi", "0123456789", "test@user.com", "123456", "0348435436324")
        );
        Account account = new Account(user);
        Account account2 = new Account(user, 30000);
        System.out.println("Account 1 balance: " + account.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}
