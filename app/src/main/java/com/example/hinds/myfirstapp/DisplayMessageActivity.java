package com.example.hinds.myfirstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {
    private static final int TL = Toast.LENGTH_SHORT;   // Toast.LENGTH_LONG for longer
    private static final String AC = "Display Message Activity: ";
    private static final String TAG = "LIFECYCLES";

    private String message = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //Get the intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(message);
    }

    /** Lifecycle method: Called when the activity is becoming visible to user. */
    @Override
    protected void onStart(){
        super.onStart();
        message = "onStart() called";
        Toast.makeText(this, AC+message, TL).show();
        Log.d(TAG, AC+message);
    }

    /** Lifecycle method: Called when the activity begins interacting with the user. */
    @Override
    protected void onResume(){
        super.onResume();

        message = "onResume() called";
        Toast.makeText(this, AC+message, TL).show();
        Log.i(TAG, AC+message);
    }

    /** Lifecycle method: Called when the activity is being placed in the background.
     * Any user data that need to persist should be written to long-term storage here since
     * after onPause() returns there is no guarantee that further lifecycle methods will be
     * executed if the system decides to kill the app while it is in the background to reclaim
     * resources. We shall use shared preferences to illustrate writing to long-term storage. */

    @Override
    protected void onPause(){
        super.onPause();

        message = "onPause() called ()";
        Toast.makeText(this, AC+message, TL).show();
        Log.w(TAG, AC+message);



    }

    /** Lifecycle method: Called after the activity has been stopped, prior to restarting. */
    @Override
    protected void onRestart(){
        super.onRestart();
        message = "onRestart() called";
        Toast.makeText(this, AC+message, TL).show();
        Log.v(TAG, AC+message);
    }

    /** Lifecycle method: Called when the activity is no longer visible to the user. */
    @Override
    protected void onStop(){
        super.onStop();
        message = "onStop() called";
        Toast.makeText(this, AC+message, TL).show();
        Log.e(TAG, AC+message);
    }

    /** Lifecycle method: The final call received before the activity is destroyed. */
    @Override
    protected void onDestroy(){
        super.onDestroy();

        message = "onDestroy() called";
        Toast.makeText(this, AC+message, TL).show();
        Log.i(TAG, AC+message);
    }
}
