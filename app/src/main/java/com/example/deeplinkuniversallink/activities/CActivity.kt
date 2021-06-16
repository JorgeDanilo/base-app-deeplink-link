package com.example.deeplinkuniversallink.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.deeplinkuniversallink.R
import com.example.deeplinkuniversallink.intents.IntentHelper

class CActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        parseIntent()
    }

    private fun parseIntent() {
        val txtQuery = findViewById<TextView>(R.id.txtQuery)
        txtQuery.text = intent.getStringExtra(IntentHelper.EXTRA_C_QUERY) +
                intent.getIntExtra(IntentHelper.EXTRA_C_CHOISE, 0)
    }
}