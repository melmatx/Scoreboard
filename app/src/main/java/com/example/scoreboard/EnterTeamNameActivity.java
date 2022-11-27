package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterTeamNameActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE1 = "com.examples.activities.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.examples.activities.MESSAGE2";

    EditText et_TeamA_name, et_TeamB_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_team_name);
        SharedPrefsClass.sp = getSharedPreferences(SharedPrefsClass.myPREFERENCES, MODE_PRIVATE);

        int TeamA = 1;
        int TeamB = 2;

        et_TeamA_name = findViewById(R.id.et_TeamA_name);
        et_TeamB_name = findViewById(R.id.et_TeamB_name);

        et_TeamA_name.setText(SharedPrefsClass.displayTeamNames(TeamA));
        et_TeamB_name.setText(SharedPrefsClass.displayTeamNames(TeamB));
    }

    public void startMain(View view){
        SharedPrefsClass.sp = getSharedPreferences(SharedPrefsClass.myPREFERENCES, MODE_PRIVATE);
        Intent intent = new Intent(this, MainActivity.class);
        et_TeamA_name = findViewById(R.id.et_TeamA_name);
        et_TeamB_name = findViewById(R.id.et_TeamB_name);
        String TeamA_name = et_TeamA_name.getText().toString();
        String TeamB_name = et_TeamB_name.getText().toString();
        SharedPrefsClass.saveIntoSP(TeamA_name, TeamB_name);
        intent.putExtra(EXTRA_MESSAGE1, TeamA_name);
        intent.putExtra(EXTRA_MESSAGE2, TeamB_name);
        startActivity(intent);
    }

    public void clearInput(View view){
        et_TeamA_name.setText("");
        et_TeamB_name.setText("");

        SharedPreferences.Editor editor = SharedPrefsClass.sp.edit();
        editor.clear();
        editor.commit();
    }
}