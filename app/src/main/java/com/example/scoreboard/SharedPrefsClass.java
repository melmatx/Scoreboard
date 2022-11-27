package com.example.scoreboard;

import android.content.SharedPreferences;
import android.widget.EditText;

public class SharedPrefsClass {

    public static final String myPREFERENCES = "UserPrefs";
    public static final String PREF_teamA_name = "teamAName";
    public static final String PREF_teamB_name = "teamBName";

    public static SharedPreferences sp;

    public static void saveIntoSP(String TA_name, String TB_name) {
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(PREF_teamA_name, TA_name);
        editor.putString(PREF_teamB_name, TB_name);

        editor.commit();
    }

    public static String displayTeamNames(int teamName) {
        if(teamName == 1)
        {
            return sp.getString(PREF_teamA_name, "");
        }
        else if(teamName == 2)
        {
            return sp.getString(PREF_teamB_name, "");
        }
        else {
            return null;
        }
    }
}
