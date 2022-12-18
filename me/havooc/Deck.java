package me.havooc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> deckCards;
    public static final Deck gameDeck = Deck.createRandomizedDeck();

    public Deck() {
        this.deckCards = new ArrayList<>();
    }
    public Deck(List<Card> cards) {
        this.deckCards = cards;
    }
    public void print() {
        for (Card c : deckCards) {
            c.print();
        }
    }
    public void removeCard(Card card) {
        if(!deckCards.contains(card) || deckCards == gameDeck.deckCards)
            return;
        deckCards.remove(card);
        gameDeck.getCards().add(card);
    }
    public static Deck createFullDeck() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            try {
                for (int j = 1; j <= 13; j++) {
                    cards.add(new Card(i, j));
                }
            } catch (UnknownCardException e) {
                e.printStackTrace();
            }
        }
        return new Deck(cards);
    }

    public static Deck createRandomizedDeck() {
        Deck deck = createFullDeck();
        Collections.shuffle(deck.getCards());
        return deck;
    }

    public void drawCard() {
        if(this.deckCards == gameDeck.deckCards)
            return;
        Card cardToDraw = gameDeck.getCards().get(0);
        deckCards.add(cardToDraw);
        gameDeck.getCards().remove(0);
    }

    public List<Card> getCards() {
        return deckCards;
    }

    public int getSize() {
        return deckCards.size();
    }
}
