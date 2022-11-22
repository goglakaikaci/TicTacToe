package com.example.leqcia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PageOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_one)
        val playbtn = findViewById<Button>(R.id.playButton)

        playbtn.setOnClickListener() {
            callActivity()
        }
    }

    private fun callActivity() {
        val name1 = findViewById<EditText>(R.id.p1name)
        val name2 = findViewById<EditText>(R.id.p2name)

        val message1 = name1.text.toString()
        val message2 = name2.text.toString()

        val intent = Intent(this, MainActivity::class.java).also {
            it.putExtra("PLAYER1", message1)
            it.putExtra("PLAYER2", message2)
            startActivity(it)
        }
    }
}