package com.example.leqcia

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var Button4: Button
    private lateinit var Button5: Button
    private lateinit var Button6: Button
    private lateinit var Button7: Button
    private lateinit var Button8: Button
    private lateinit var Button9: Button
    private lateinit var Reset: Button
    private lateinit var p1Score: TextView
    private lateinit var p2Score: TextView
    var p1points = 0
    var p2points = 0

    private var playerOne = ArrayList<Int>()
    private var playerTwo = ArrayList<Int>()
    var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val restartgame = findViewById<Button>(R.id.restartgame)
        var Player1 = intent.getStringExtra("PLAYER1")
        var Player2 = intent.getStringExtra("PLAYER2")

        restartgame.setOnClickListener() {
            callActivity()
        }

        var firstplayer = findViewById<TextView>(R.id.score1).apply {
            text = Player1
        }

        var secondplayer = findViewById<TextView>(R.id.score2).apply {
            text = Player2
        }
        Button1 = findViewById(R.id.button1)
        Button2 = findViewById(R.id.button2)
        Button3 = findViewById(R.id.button3)
        Button4 = findViewById(R.id.button4)
        Button5 = findViewById(R.id.button5)
        Button6 = findViewById(R.id.button6)
        Button7 = findViewById(R.id.button7)
        Button8 = findViewById(R.id.button8)
        Button9 = findViewById(R.id.button9)
        Reset = findViewById(R.id.reset)
        p1Score = findViewById(R.id.p1Score)
        p2Score = findViewById(R.id.p2Score)

        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)
        Button4.setOnClickListener(this)
        Button5.setOnClickListener(this)
        Button6.setOnClickListener(this)
        Button7.setOnClickListener(this)
        Button8.setOnClickListener(this)
        Button9.setOnClickListener(this)
        Reset.setOnClickListener{
            Button1.text = ""
            Button1.setBackgroundColor(Color.WHITE)
            Button1.isEnabled = true
            Button2.text = ""
            Button2.setBackgroundColor(Color.WHITE)
            Button2.isEnabled = true
            Button3.text = ""
            Button3.setBackgroundColor(Color.WHITE)
            Button3.isEnabled = true
            Button4.text = ""
            Button4.setBackgroundColor(Color.WHITE)
            Button4.isEnabled = true
            Button5.text = ""
            Button5.setBackgroundColor(Color.WHITE)
            Button5.isEnabled = true
            Button6.text = ""
            Button6.setBackgroundColor(Color.WHITE)
            Button6.isEnabled = true
            Button7.text = ""
            Button7.setBackgroundColor(Color.WHITE)
            Button7.isEnabled = true
            Button8.text = ""
            Button8.setBackgroundColor(Color.WHITE)
            Button8.isEnabled = true
            Button9.text = ""
            Button9.setBackgroundColor(Color.WHITE)
            Button9.isEnabled = true
            playerOne.clear()
            playerTwo.clear()
            activePlayer = 1
        }
    }

    private fun callActivity() {
        val intent = Intent(this, PageOne::class.java).also {
            startActivity(it)
        }
    }

    override fun onClick(clickedView: View?) {
        var buttonNumber = 0
        if (clickedView is Button) {
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
        }
        if (buttonNumber != 0) {
            game(buttonNumber, clickedView as Button)
        }
    }


    private fun disableButtons() {
        Button1.isEnabled = false
        Button2.isEnabled = false
        Button3.isEnabled = false
        Button4.isEnabled = false
        Button5.isEnabled = false
        Button6.isEnabled = false
        Button7.isEnabled = false
        Button8.isEnabled = false
        Button9.isEnabled = false
    }

    private fun game(buttonNumber: Int, clickedView: Button) {
        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setTextColor(Color.BLACK)
            activePlayer = 2
            playerOne.add(buttonNumber)
        }
        else if (activePlayer == 2){
            clickedView.text = "O"
            clickedView.setTextColor(Color.BLACK)
            activePlayer = 1
            playerTwo.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {

        var winner = 0
        val len1 = playerOne.size
        val len2 = playerTwo.size


        if (playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3)) {
            winner = 1
            Button1.setBackgroundColor(Color.GREEN)
            Button2.setBackgroundColor(Color.GREEN)
            Button3.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3)) {
            winner = 2
            Button1.setBackgroundColor(Color.GREEN)
            Button2.setBackgroundColor(Color.GREEN)
            Button3.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6)) {
            winner = 1
            Button4.setBackgroundColor(Color.GREEN)
            Button5.setBackgroundColor(Color.GREEN)
            Button6.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6)) {
            winner = 2
            Button4.setBackgroundColor(Color.GREEN)
            Button5.setBackgroundColor(Color.GREEN)
            Button6.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9)) {
            winner = 1
            Button7.setBackgroundColor(Color.GREEN)
            Button8.setBackgroundColor(Color.GREEN)
            Button9.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9)) {
            winner = 2
            Button7.setBackgroundColor(Color.GREEN)
            Button8.setBackgroundColor(Color.GREEN)
            Button9.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7)) {
            winner = 1
            Button1.setBackgroundColor(Color.GREEN)
            Button4.setBackgroundColor(Color.GREEN)
            Button7.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7)) {
            winner = 2
            Button1.setBackgroundColor(Color.GREEN)
            Button4.setBackgroundColor(Color.GREEN)
            Button7.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8)) {
            winner = 1
            Button2.setBackgroundColor(Color.GREEN)
            Button5.setBackgroundColor(Color.GREEN)
            Button8.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8)) {
            winner = 2
            Button2.setBackgroundColor(Color.GREEN)
            Button5.setBackgroundColor(Color.GREEN)
            Button8.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9)) {
            winner = 1
            Button3.setBackgroundColor(Color.GREEN)
            Button6.setBackgroundColor(Color.GREEN)
            Button9.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9)) {
            winner = 2
            Button3.setBackgroundColor(Color.GREEN)
            Button6.setBackgroundColor(Color.GREEN)
            Button9.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerOne.contains(1) && playerOne.contains(5) && playerOne.contains(9)) {
            winner = 1
            Button1.setBackgroundColor(Color.GREEN)
            Button5.setBackgroundColor(Color.GREEN)
            Button9.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerTwo.contains(1) && playerTwo.contains(5) && playerTwo.contains(9)) {
            winner = 2
            Button1.setBackgroundColor(Color.GREEN)
            Button5.setBackgroundColor(Color.GREEN)
            Button9.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerOne.contains(3) && playerOne.contains(5) && playerOne.contains(7)) {
            winner = 1
            Button3.setBackgroundColor(Color.GREEN)
            Button5.setBackgroundColor(Color.GREEN)
            Button7.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (playerTwo.contains(3) && playerTwo.contains(5) && playerTwo.contains(7)) {
            winner = 2
            Button3.setBackgroundColor(Color.GREEN)
            Button5.setBackgroundColor(Color.GREEN)
            Button7.setBackgroundColor(Color.GREEN)
            disableButtons()
        }
        if (winner == 1) {
            disableButtons()
            p1points++
            p1Score.text = p1points.toString()
            Toast.makeText(applicationContext, "Wins", Toast.LENGTH_SHORT).show()
        } else if (winner == 2) {
            disableButtons()
            p2points++
            p2Score.text = p2points.toString()
            Toast.makeText(applicationContext,  "Wins", Toast.LENGTH_SHORT).show()
        } else if (len1 + len2 == 9 && winner != 1 && winner != 2) {
            Toast.makeText(applicationContext, "Its a draw", Toast.LENGTH_SHORT).show()
            Button1.setBackgroundColor(Color.RED)
            Button2.setBackgroundColor(Color.RED)
            Button3.setBackgroundColor(Color.RED)
            Button4.setBackgroundColor(Color.RED)
            Button5.setBackgroundColor(Color.RED)
            Button6.setBackgroundColor(Color.RED)
            Button7.setBackgroundColor(Color.RED)
            Button8.setBackgroundColor(Color.RED)
            Button9.setBackgroundColor(Color.RED)
        }
    }
}