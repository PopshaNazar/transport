package card;

class Card {
    private String name;
    private int sold;

    public Card(String name, int sold) {
        this.name = name;
        this.sold = sold;

    }

    public int getSold() {
        return sold;
    }

    public String toString() {
        return "name: " + name + ", sold: " + sold;
    }
}

class Wallet {
    private String Name;
    private static int MaxCards = 6;
    private Card[] cardList;
    private int count = 0;
    private int summ = 0;

    public Wallet(String Name) {
        this.Name = Name;
        cardList = new Card[MaxCards];
    }

    public boolean addCard(Card card) {
        if (count < MaxCards) {
            cardList[count] = card;
            count++;
            return true;
        }
        return false;
    }

    public int sum() {
        for (int i = 0; i < count; i++) {
            summ += cardList[i].getSold();
        }
        return summ;

    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.Name);
        for (int i = 0; i < count; i++) {
            result.append(" (" + cardList[i].toString() + ") ");
        }

        result.append("sum: " + this.sum());
        return result.toString();
    }

}

public class MainCard {
    public static void main(String[] args) {
        Wallet wallet = new Wallet("Nazar");
        Card card1 = new Card("12332312", 124);
        Card card2 = new Card("132312", 124);

        wallet.addCard(card1);
        wallet.addCard(card2);

        System.out.println(wallet.toString());
    }
}
