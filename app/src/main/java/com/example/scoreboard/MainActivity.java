package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int teamA_score;
    public int teamB_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String TeamA_name = intent.getStringExtra(EnterTeamNameActivity.EXTRA_MESSAGE1);
        String TeamB_name = intent.getStringExtra(EnterTeamNameActivity.EXTRA_MESSAGE2);
        TextView tv_TeamA_name = findViewById(R.id.tv_TeamA_name);
        TextView tv_TeamB_name = findViewById(R.id.tv_TeamB_name);
        tv_TeamA_name.setText(TeamA_name);
        tv_TeamB_name.setText(TeamB_name);
    }

    public void addTAone(View view){
        teamA_score += 1;
        displayTAscore(teamA_score);
    }

    public void addTAtwo(View view){
        teamA_score += 2;
        displayTAscore(teamA_score);
    }

    public void addTAthree(View view){
        teamA_score += 3;
        displayTAscore(teamA_score);
    }

    public void addTBone(View view){
        teamB_score += 1;
        displayTBscore(teamB_score);
    }

    public void addTBtwo(View view){
        teamB_score += 2;
        displayTBscore(teamB_score);
    }

    public void addTBthree(View view){
        teamB_score += 3;
        displayTBscore(teamB_score);
    }

    private void displayTAscore(int teamA_score){
        TextView tv_teamAscore = findViewById(R.id.tv_TeamA_points);
        tv_teamAscore.setText("" + teamA_score);
    }

    private void displayTBscore(int teamB_score){
        TextView tv_teamBscore = findViewById(R.id.tv_TeamB_points);
        tv_teamBscore.setText("" + teamB_score);
    }

    public void changeTeam(View view){
        Intent intent = new Intent(this, EnterTeamNameActivity.class);
        startActivity(intent);
    }

    public void reset(View view){
        teamA_score = 0;
        teamB_score = 0;
        displayTAscore(teamA_score);
        displayTBscore(teamB_score);
    }
}