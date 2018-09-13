package poker.scrum.tutkowski.scrumpoker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private final List<Card> deck;

    public CardAdapter(List<Card> deck) {
        this.deck = deck;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_card, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int position) {
        cardViewHolder.bindTo(deck.get(position));
    }

    @Override
    public int getItemCount() {
        return deck.size();
    }
}
