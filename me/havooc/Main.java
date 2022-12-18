package me.havooc;

public class Main {

    public static Deck gameDeck = Deck.gameDeck;
    public static Deck playerDeck = new Deck();
    public static Deck enemyDeck = new Deck();

    public static void main(String[] args) throws UnknownCardException {
        gameDeck.print();
    }

}