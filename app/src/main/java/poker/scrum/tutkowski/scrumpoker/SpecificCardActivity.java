package poker.scrum.tutkowski.scrumpoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SpecificCardActivity extends AppCompatActivity {
    public static final String MESSAGE_CARD_ID = "poker.scrum.tutkowski.scrumpoker.SpecificCardActivity.CARD_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_card);

        Intent intent = getIntent();
        int cardId = intent.getIntExtra(MESSAGE_CARD_ID, -1);
        if (cardId > 0) {
            ImageView imageView = findViewById(R.id.imageview);
            imageView.setImageResource(cardId);

            // Close the activity if the image is clicked
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SpecificCardActivity.this.finish();
                }
            });
        }
    }
}
