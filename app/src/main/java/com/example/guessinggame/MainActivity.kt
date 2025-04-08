package com.example.guessinggame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var leftButton: Button
    private lateinit var rightButton: Button
    var score: Int = 0
    private lateinit var scoreBox: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        leftButton = findViewById(R.id.leftButton)
        rightButton = findViewById(R.id.rightButton)
        leftButton.text = Random.nextInt(0, 9).toString()
        rightButton.text = Random.nextInt(0, 9).toString()
        scoreBox = findViewById(R.id.scoreBox)
    }

    fun onClick(v: View) {
        val leftText = leftButton.text.toString()
        val rightText = rightButton.text.toString()

        if (v.equals(leftButton)) {
            if (leftText > rightText) {
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                score--
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            if (leftText < rightText) {
                score++
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                score--
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }
        }
        // show score
        scoreBox.setText("Points: $score")

        // generate new numbers
        leftButton.text = Random.nextInt(0, 9).toString()
        rightButton.text = Random.nextInt(0, 9).toString()
        // ensure they are different
        while (leftButton.text.toString() == rightButton.text.toString()) {
            rightButton.text = Random.nextInt(0, 9).toString()
        }
    }
}
