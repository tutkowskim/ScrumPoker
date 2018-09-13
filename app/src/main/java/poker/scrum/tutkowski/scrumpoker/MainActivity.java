package poker.scrum.tutkowski.scrumpoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public final static String MESSAGE_DECK_NAME = "poker.scrum.tutkowski.scrumpoker.MainActivity.DECK_NAME";
    public final static String FIBONACCI_DECK = "FibonacciDeck";

    private final static Map<String, List<Card>> decks = buildDecks();

    private static Map<String, List<Card>> buildDecks() {
        HashMap<String, List<Card>> decks = new HashMap<>();

        List<Card> fibonacciDeck = new ArrayList<>();
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_low_hanging_fruit)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_piece_of_cake)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_it_aint_rocket_science)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_ornitorinco)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_an_arm_and_a_leg)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_squeaking_by)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_dont_put_all_your_eggs_in_one_basket)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_meterse_en_un_berenjenal)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_monster_task)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_here_be_dragons)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_when_pigs_fly)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_coffee_break)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_eat_a_brownie)));
        fibonacciDeck.add(new Card((R.drawable.ic_planning_poker_yak_shaving)));
        decks.put(MainActivity.FIBONACCI_DECK, fibonacciDeck);

        return decks;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String deckName = intent.hasExtra(MESSAGE_DECK_NAME) ? intent.getStringExtra(MESSAGE_DECK_NAME) : FIBONACCI_DECK;
        List<Card> deck = decks.get(deckName);

        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.CENTER);
        flexboxLayoutManager.setAlignItems(AlignItems.CENTER);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setAdapter(new CardAdapter(deck));
    }
}