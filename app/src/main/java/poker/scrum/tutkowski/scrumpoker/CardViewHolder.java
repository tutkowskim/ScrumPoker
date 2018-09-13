package poker.scrum.tutkowski.scrumpoker;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Card card;
    private final ImageView imageView;

    public CardViewHolder(View view) {
        super(view);
        this.imageView = view.findViewById(R.id.imageview);
        view.setOnClickListener(this);
    }

    public void bindTo(Card card) {
        this.card = card;
        imageView.setImageResource(card.getImageId());
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), SpecificCardActivity.class);
        intent.putExtra(SpecificCardActivity.MESSAGE_CARD_ID, card.getImageId());
        view.getContext().startActivity(intent);
    }
}
