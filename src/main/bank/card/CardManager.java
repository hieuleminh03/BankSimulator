package card;

import account.Account;

public class CardManager {
    private static CardManager instance;

    private CardManager() {
    }

    public static CardManager getInstance() {
        if (instance == null) {
            instance = new CardManager();
        }
        return instance;
    }

    public void createDefaultCard(Account account) {
        Card defaultCard = new Card(account);
        System.out.println("Default card is created");
    }
}
