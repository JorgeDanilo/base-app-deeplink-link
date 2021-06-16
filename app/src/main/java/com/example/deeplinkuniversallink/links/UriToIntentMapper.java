package com.example.deeplinkuniversallink.links;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.example.deeplinkuniversallink.intents.IntentHelper;

public class UriToIntentMapper {
    final private Context mContext;
    final private IntentHelper mIntents;

    public UriToIntentMapper(Context mContext, IntentHelper mIntents) {
        this.mContext = mContext;
        this.mIntents = mIntents;
    }

    public void dispatchIntent(Intent intent) {
        final Uri uri = intent.getData();
        Intent dispatchIntent = null;

        if (uri == null) throw new IllegalArgumentException("Uri cannot be null");

        final String scheme = uri.getScheme().toLowerCase();
        final String host = uri.getHost().toLowerCase();

        if ("example-scheme".equals(scheme)) {
            dispatchIntent = mapAppLink(uri);
        } else if (("http".equals(scheme) || "https".equals(scheme)) &&
        ("www.example.co.uk".equals(host) || "example.co.uk".equals(host))) {
            dispatchIntent = mapWebLink(uri);
        }

        if (dispatchIntent != null) {
            mContext.startActivity(dispatchIntent);
        }
    }

    private Intent mapAppLink(Uri uri) {
        final String host = uri.getHost().toLowerCase();

        switch (host) {
            case "activitya":
                return mIntents.newAActivityIntent(mContext);
            case "activityb":
                return mIntents.newBActivityIntent(mContext, uri.getQueryParameter("query"));
            case "activityc":
                int choise = Integer.parseInt(uri.getQueryParameter("choice"));
                return mIntents.newCActivityIntent(mContext, uri.getQueryParameter("query"), choise);
        }
        return null;
    }

    private Intent mapWebLink(Uri uri) {
        final String path = uri.getPath();

        switch (path) {
            case "/a":
                return mIntents.newAActivityIntent(mContext);
            case "/c":
                String query = uri.getQueryParameter("query");
                int choise = Integer.parseInt(uri.getQueryParameter("choise"));
                return mIntents.newCActivityIntent(mContext, query, choise);
        }
        return null;
    }
}
