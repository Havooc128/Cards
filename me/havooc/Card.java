package me.havooc;

public class Card {

    public static final int KIER = 0;
    public static final int KARO = 1;
    public static final int TREFl = 2;
    public static final int PIK = 3;
    private final int cardSymbolId;
    private final String cardValue;

    public Card(int cardSymbolId, int cardValue) throws UnknownCardException {
        if (cardSymbolId > 3 || cardSymbolId < 0)
            throw new UnknownCardException("Nie znaleziono karty o id symbolu " + cardSymbolId + " (oczekuje wartości od 0 do 3)");
        this.cardSymbolId = cardSymbolId;
        if (cardValue > 13 || cardValue < 1)
            throw new UnknownCardException("Nie znaleziono karty o id " + cardValue + " (oczekuje wartości od 1 do 13)");
        this.cardValue = switch (cardValue) {
            case 1 -> "A";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            default -> String.valueOf(cardValue);
        };
    }

    public Card(int cardSymbolId, String cardValue) {
        this.cardSymbolId = cardSymbolId;
        this.cardValue = cardValue;
    }

    public int getSymbolId() {
        return cardSymbolId;
    }

    public String getValue() {
        return cardValue;
    }

    public void print() {
        String additionalSpace =this.getValue().length() !=1 ? "" : " ";
        String symbolToPrint = this.getValue()+getSymbol(this.getSymbolId());
        System.out.println(
                "┍-----------------------┐\n" +
                        "|"+ symbolToPrint + additionalSpace +"                   |\n" +
                        "|                       |\n" +
                        "|                       |\n" +
                        "|                       |\n" +
                        "|                       |\n" +
                        "|                       |\n" +
                        "|                       |\n" +
                        "|                       |\n" +
                        "|                       |\n" +
                        "|                       |\n" +
                        "|                   "+ additionalSpace + symbolToPrint +"|\n" +
                        "┖-----------------------┙\n" +
                        "\n" +
                        "\n" +
                        "\n");
    }

    private static String getSymbol(int symbol) {
        return switch (symbol) {
            case 0 -> "♥";
            case 1 -> "♦";
            case 2 -> "♣";
            case 3 -> "♠";
            default -> null;
        };
    }
    public boolean equals(Object o) {
        if(!(o instanceof Card c))
            return false;
        return this.cardValue.equals(c.getValue()) && this.cardSymbolId == c.cardSymbolId;
    }
}
