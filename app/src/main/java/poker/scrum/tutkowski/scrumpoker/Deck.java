package poker.scrum.tutkowski.scrumpoker;

import java.util.List;

public class Deck {
    private final String deckName;
    private final String deckAuthor;
    private final List<Card> deckCards;
    private String deckDescription;

    public Deck(String deckName, String deckAuthor, String deckDescription, List<Card> deckCards) {
        this.deckName = deckName;
        this.deckAuthor = deckAuthor;
        this.deckDescription = deckDescription;
        this.deckCards = deckCards;
    }

    public String getDeckName() {
        return deckName;
    }

    public String getDeckAuthor() {
        return deckAuthor;
    }

    public List<Card> getDeckCards() {
        return deckCards;
    }

    public String getDeckDescription() {
        return deckDescription;
    }
}
