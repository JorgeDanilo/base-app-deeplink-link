package com.example.deeplinkuniversallink.intents;

import android.content.Context;
import android.content.Intent;

import com.example.deeplinkuniversallink.activities.AActivity;
import com.example.deeplinkuniversallink.activities.BActivity;
import com.example.deeplinkuniversallink.activities.CActivity;

public class IntentHelper {

    public static String EXTRA_B_QUERY = "com.example.deeplinkuniversallink.intents.Intents.EXTRA_B_QUERY";
    public static String EXTRA_C_QUERY = "com.example.deeplinkuniversallink.intents.Intents.EXTRA_C_QUERY";
    public static String EXTRA_C_CHOISE = "com.example.deeplinkuniversallink.intents.Intents.EXTRA_C_CHOISE";

    public Intent newAActivityIntent(Context context) {
        Intent intent = new Intent(context, AActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }

    public Intent newBActivityIntent(Context context, String query) {
        Intent intent = new Intent(context, BActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(EXTRA_B_QUERY, query);
        return intent;
    }

    public Intent newCActivityIntent(Context context, String query, int choice) {
        Intent intent = new Intent(context, CActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(EXTRA_C_QUERY, query);
        intent.putExtra(EXTRA_C_CHOISE, choice);
        return intent;
    }
}
