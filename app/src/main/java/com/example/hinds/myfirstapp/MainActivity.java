package com.example.hinds.myfirstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final int TL = Toast.LENGTH_SHORT;   // Toast.LENGTH_LONG for longer
    private static final String AC = "Main Activity: ";
    private static final String TAG = "LIFECYCLES";
    private SharedPreferences mPrefs;
    private String message = "";
    private String sendMessage = "";
    private EditText editText;
    private String savedMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up shared prefs to hold username
        mPrefs = getSharedPreferences("LSprefs",0);
        //savedMsg = mPrefs.getString("saved_message", "");
        editText = (EditText) findViewById(R.id.editText);

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        sendMessage  = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, sendMessage );
        startActivity(intent);
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
        savedMsg = mPrefs.getString("saved_message", "");
        editText.setText(savedMsg);
        //this moves the cursor to the end of the text in the editText widget
        //may not work for spannable strings
        int cursorPos = savedMsg.length();
        Editable etext = editText.getText();
        Selection.setSelection(etext, cursorPos);

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

        savedMsg = editText.getText().toString();
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString("saved_message", savedMsg);
        editor.commit();

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
