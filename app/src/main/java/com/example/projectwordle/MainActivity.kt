package com.example.projectwordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessBtn = findViewById<Button>(R.id.guessButton)
        val userGuess = findViewById<EditText>(R.id.guessInput)

        guessBtn.setOnClickListener {
            val guess = userGuess.text.toString().uppercase()
            val result = checkGuess(guess)

            val guess1display = findViewById<TextView>(R.id.guessOneDisplay)
            val guess1CheckDisplay = findViewById<TextView>(R.id.guessOneDisplayCheck)

            val guess2display = findViewById<TextView>(R.id.guessTwoDisplay)
            val guess2CheckDisplay = findViewById<TextView>(R.id.guessTwoDisplayCheck)

            val guess3display = findViewById<TextView>(R.id.guessThreeDisplay)
            val guess3CheckDisplay = findViewById<TextView>(R.id.guessThreeDisplayCheck)


            if (guess1display.text.isEmpty()){
                guess1display.text = guess
                guess1CheckDisplay.text = result
                userGuess.text.clear()
            }
            else if (guess2display.text.isEmpty()) {
                guess2display.text = guess
                guess2CheckDisplay.text = result
                userGuess.text.clear()
            }
            else{
                guess3display.text.isEmpty()
                guess3display.text = guess
                guess3CheckDisplay.text = result
                userGuess.text.clear()
            }

        }
    }

    private fun checkGuess(guess: String) : String {
        val wordToGuess = FourLetterWordList.toString()

        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result

    }

}


