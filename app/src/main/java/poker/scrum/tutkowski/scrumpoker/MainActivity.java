package poker.scrum.tutkowski.scrumpoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

public class MainActivity extends AppCompatActivity {
    public final static String MESSAGE_DECK_NAME = "poker.scrum.tutkowski.scrumpoker.MainActivity.DECK_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String desiredDeckName = intent.hasExtra(MESSAGE_DECK_NAME) ? intent.getStringExtra(MESSAGE_DECK_NAME) : "";
        final Deck deck = Decks.getDeck(this, desiredDeckName);

        FloatingActionButton fabActivateFabs = findViewById(R.id.fabActivateFabs);
        fabActivateFabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFloatingActionItems(true);
            }
        });

        FloatingActionButton fabDeactivateFabs = findViewById(R.id.fabDeactivateFabs);
        fabDeactivateFabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFloatingActionItems(false);
            }
        });

        FloatingActionButton fabShowDeckInfo = findViewById(R.id.fabShowDeckInfo);
        fabShowDeckInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeckInformationDialogFragment deckInformationDialogFragment = new DeckInformationDialogFragment();
                deckInformationDialogFragment.show(getSupportFragmentManager(), deck.getDeckName());
                showFloatingActionItems(false);
            }
        });

        FloatingActionButton fabChangeDeck = findViewById(R.id.fabChangeDeck);
        fabChangeDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeDeckDialogFragment deckInformationDialogFragment = new ChangeDeckDialogFragment();
                deckInformationDialogFragment.show(getSupportFragmentManager(), deck.getDeckName());
                showFloatingActionItems(false);
            }
        });

        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.CENTER);
        flexboxLayoutManager.setAlignItems(AlignItems.CENTER);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setAdapter(new CardAdapter(deck.getDeckCards()));
    }

    private void showFloatingActionItems(boolean show) {
        findViewById(R.id.passiveFabItems).setVisibility(show ? View.INVISIBLE : View.VISIBLE);
        findViewById(R.id.activeFabItems).setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }
}