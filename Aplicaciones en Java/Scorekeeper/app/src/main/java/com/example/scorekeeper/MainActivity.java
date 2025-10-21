package com.example.scorekeeper;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Member variables for holding the score
    private int mScore1;
    private int mScore2;

    //Member variable for the two score TextView
    private TextView mScoreText1;
    private TextView mScoreText2;

    //Tag to be used as the key in OnSavedInstanceState
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    private ImageButton bttnMinus1;
    private ImageButton bttnMinus2;

    private ImageButton bttnPlus1;
    private ImageButton bttnPlus2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Find the TextViews by ID
        mScoreText1 = (TextView)findViewById(R.id.score_1);
        mScoreText2 = (TextView)findViewById(R.id.score_2);

        bttnMinus1 = findViewById(R.id.decreaseTeam1);
        bttnMinus2 = findViewById(R.id.decreaseTeam2);

        bttnPlus1 = findViewById(R.id.increaseTeam1);
        bttnPlus2 = findViewById(R.id.increaseTeam2);

        //Restores the scores if there is savedInstanceState
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }

        bttnMinus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseScore(bttnMinus1);
            }
        });

        bttnPlus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScore(bttnPlus1);
            }
        });

        bttnMinus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseScore(bttnMinus2);
            }
        });

        bttnPlus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScore(bttnPlus2);
            }
        });
    }

    /**
     * Creates the night mode menu option
     * @param menu The menu in the action bar
     * @return True to display the menu, false to hide it
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    /**
     * Method that handles menu item clicks
     * @param item The item that was pressed
     * @return returns true since the item click wa handled
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){
            //Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            //Set the theme mode for the restarted activity
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            //Recreate the activity for the theme change to take effect
            recreate();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Method that handles the onClick of both the decrement buttons
     * @param view The button view that was clicked
     */
    public void decreaseScore(View view) {
        // Get the tag of the button that was clicked
        String buttonTag = (String) view.getTag();

        // Check which button was clicked based on its tag
        if ("decreaseTeam1".equals(buttonTag)) {
            // Decrement the score and update the TextView for Team 1
            mScore1--;
            mScoreText1.setText(String.valueOf(mScore1));
        } else if ("decreaseTeam2".equals(buttonTag)) {
            // Decrement the score and update the TextView for Team 2
            mScore2--;
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }


    /**
     * Method that handles the onClick of both the increment buttons
     * @param view The button view that was clicked
     */
    public void increaseScore(View view) {
        // Get the tag of the button that was clicked
        String buttonTag = (String) view.getTag();
        // Check which button was clicked based on its tag
        if ("increaseTeam1".equals(buttonTag)) {
            // Increment the score and update the TextView for Team 1
            mScore1++;
            mScoreText1.setText(String.valueOf(mScore1));
        } else if ("increaseTeam2".equals(buttonTag)) {
            // Increment the score and update the TextView for Team 2
            mScore2++;
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }


    /**
     * Method that is called when the configuration changes, used to preserve the state of the app
     * @param outState The bundle that will be passed in to the Activity when it is restored
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }

}