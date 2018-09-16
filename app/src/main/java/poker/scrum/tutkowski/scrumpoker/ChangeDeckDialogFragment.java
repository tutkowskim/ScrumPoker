package poker.scrum.tutkowski.scrumpoker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.Map;

public class ChangeDeckDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Activity activity = getActivity();
        Map<String, Deck> decks = Decks.getAllDecks(activity);
        final CharSequence[] deckNames = decks.keySet().toArray(new CharSequence[decks.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.choose_deck).setItems(deckNames, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(activity, MainActivity.class);
                intent.putExtra(MainActivity.MESSAGE_DECK_NAME, deckNames[which]);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                activity.startActivity(intent);
            }
        });
        return builder.create();
    }
}
