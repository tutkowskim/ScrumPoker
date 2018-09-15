package poker.scrum.tutkowski.scrumpoker;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Decks {
    /**
     * Get the default deck
     * @param content
     * @return
     */
    public static Deck getDefaultDeck(Context content) {
        return buildRedboothDeck(content);
    }

    /**
     * Get all of the available decks
     * @param content
     * @return
     */
    public static Map<String, Deck> getAllDecks(Context content) {
        HashMap<String, Deck> decks = new HashMap<>();

        Deck redboothDeck = buildRedboothDeck(content);
        decks.put(redboothDeck.getDeckName(), redboothDeck);

        return decks;
    }

    /**
     * Get the requested deck or the default deck if not found.
     * @param context Activity context
     * @param desiredDeckName Desired deck
     * @return Desired deck or default deck if not found
     */
    public static Deck getDeck(Context context, String desiredDeckName) {
        Map<String, Deck> decks = Decks.getAllDecks(context);
        return decks.containsKey(desiredDeckName)
                ? decks.get(desiredDeckName)
                : Decks.getDefaultDeck(context);
    }

    @NonNull
    private static Deck buildRedboothDeck(Context content) {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card((R.drawable.ic_planning_poker_low_hanging_fruit)));
        cards.add(new Card((R.drawable.ic_planning_poker_piece_of_cake)));
        cards.add(new Card((R.drawable.ic_planning_poker_it_aint_rocket_science)));
        cards.add(new Card((R.drawable.ic_planning_poker_ornitorinco)));
        cards.add(new Card((R.drawable.ic_planning_poker_an_arm_and_a_leg)));
        cards.add(new Card((R.drawable.ic_planning_poker_squeaking_by)));
        cards.add(new Card((R.drawable.ic_planning_poker_dont_put_all_your_eggs_in_one_basket)));
        cards.add(new Card((R.drawable.ic_planning_poker_meterse_en_un_berenjenal)));
        cards.add(new Card((R.drawable.ic_planning_poker_monster_task)));
        cards.add(new Card((R.drawable.ic_planning_poker_here_be_dragons)));
        cards.add(new Card((R.drawable.ic_planning_poker_when_pigs_fly)));
        cards.add(new Card((R.drawable.ic_planning_poker_coffee_break)));
        cards.add(new Card((R.drawable.ic_planning_poker_eat_a_brownie)));
        cards.add(new Card((R.drawable.ic_planning_poker_yak_shaving)));

        String deckName = content.getResources().getString(R.string.deck_redbooth_name);
        String deckAuthor = content.getResources().getString(R.string.deck_redbooth_author);
        String deckDescription = content.getResources().getString(R.string.deck_redbooth_description);
        return new Deck(deckName, deckAuthor, deckDescription, cards);
    }


}
