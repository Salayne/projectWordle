package com.example.projectwordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var wordToGuess = FourLetterWordList.getRandomFourLetterWord()


    private fun resetGame() {
        wordToGuess = FourLetterWordList.getRandomFourLetterWord()

        findViewById<TextView>(R.id.guessOneDisplay).text = ""
        findViewById<TextView>(R.id.guessOneDisplayCheck).text = ""
        findViewById<TextView>(R.id.guessTwoDisplay).text = ""
        findViewById<TextView>(R.id.guessTwoDisplayCheck).text = ""
        findViewById<TextView>(R.id.guessThreeDisplay).text = ""
        findViewById<TextView>(R.id.guessThreeDisplayCheck).text = ""
        findViewById<TextView>(R.id.answerDisplay).text = ""
        findViewById<EditText>(R.id.guessInput).text.clear()
        findViewById<Button>(R.id.guessButton).isEnabled = true
        findViewById<Button>(R.id.resetBtn).visibility = View.INVISIBLE
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val guessBtn = findViewById<Button>(R.id.guessButton)
        guessBtn.setOnClickListener {
            play()
        }

    }


    private fun play(){

            val userGuess = findViewById<EditText>(R.id.guessInput)
            val guess = userGuess.text.toString().uppercase()
            val result = checkGuess(guess)
            val guess1display = findViewById<TextView>(R.id.guessOneDisplay)
            val guess1CheckDisplay = findViewById<TextView>(R.id.guessOneDisplayCheck)
            val guess2display = findViewById<TextView>(R.id.guessTwoDisplay)
            val guess2CheckDisplay = findViewById<TextView>(R.id.guessTwoDisplayCheck)
            val guess3display = findViewById<TextView>(R.id.guessThreeDisplay)
            val guess3CheckDisplay = findViewById<TextView>(R.id.guessThreeDisplayCheck)
            val answerDisplay = findViewById<TextView>(R.id.answerDisplay)
            val guessBtn = findViewById<Button>(R.id.guessButton)
            val resetButton = findViewById<Button>(R.id.resetBtn)




        if (guess1display.text.isEmpty()) {
                guess1display.text = guess
                guess1CheckDisplay.text = result
                userGuess.text.clear()
            } else if (guess2display.text.isEmpty()) {
                guess2display.text = guess
                guess2CheckDisplay.text = result
                userGuess.text.clear()
            } else if (guess3display.text.isEmpty()) {
                guess3display.text = guess
                guess3CheckDisplay.text = result
                userGuess.text.clear()

                answerDisplay.text = wordToGuess

            } else {
                guessBtn.isEnabled = false
                Toast.makeText(applicationContext, "Exceeded guesses restart game", Toast.LENGTH_SHORT).show()

        }
        resetButton.visibility = View.VISIBLE
        resetButton.setOnClickListener { resetGame() }


    }



    private fun checkGuess(guess: String) : String {

        var result = ""
        for (i in 0..3) {
            result += if (guess[i] == wordToGuess[i]) {
                "O"
            } else if (guess[i] in wordToGuess) {
                "+"
            } else {
                "X"
            }
        }
        return result

    }





}


