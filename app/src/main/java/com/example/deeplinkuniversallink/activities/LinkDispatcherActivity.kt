package com.example.deeplinkuniversallink.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.deeplinkuniversallink.R
import com.example.deeplinkuniversallink.intents.IntentHelper
import com.example.deeplinkuniversallink.links.UriToIntentMapper
import java.lang.IllegalArgumentException


class LinkDispatcherActivity : AppCompatActivity() {

    private val mMapper = UriToIntentMapper(this, IntentHelper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            mMapper.dispatchIntent(intent)
        } catch (ex: IllegalArgumentException) {
            Log.e("Deep links", "Invalid URI", ex);
        } finally {
            finish()
        }
    }
}