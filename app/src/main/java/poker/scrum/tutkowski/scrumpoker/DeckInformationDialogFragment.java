package poker.scrum.tutkowski.scrumpoker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class DeckInformationDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Activity activity = getActivity();
        String deckName = activity.getIntent().getStringExtra(MainActivity.MESSAGE_DECK_NAME);
        Deck deck = Decks.getDeck(activity, deckName);

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.deck_information_dialog_fragment, null);

        TextView deckNameTv = view.findViewById(R.id.deckNameValue);
        deckNameTv.setText(deck.getDeckName());

        TextView deckAuthorTv = view.findViewById(R.id.deckAuthorValue);
        deckAuthorTv.setText(deck.getDeckAuthor());

        TextView deckAuthorValueTv = view.findViewById(R.id.deckDescriptionValue);
        deckAuthorValueTv.setText(deck.getDeckDescription());

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setMessage(R.string.deck_info_dialog_title);
        builder.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DeckInformationDialogFragment.this.getDialog().dismiss();
            }
        });
        builder.setCancelable(true);
        return builder.create();
    }
}
