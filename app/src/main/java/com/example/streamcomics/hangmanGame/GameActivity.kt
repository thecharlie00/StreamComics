package com.example.streamcomics.hangmanGame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.streamcomics.R
import com.example.streamcomics.databinding.ActivityGameBinding
import com.example.streamcomics.databinding.ActivityGameBinding.inflate

class GameActivity : AppCompatActivity() {
    lateinit var binding: ActivityGameBinding
    lateinit var hangmanModelView: HangmanModelView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hangmanModelView = HangmanModelView()
        hangmanModelView.getNewWord(binding.hangmanTextOutput)

        binding.guessButton.setOnClickListener {
            val char = binding.guessLetterInput.text.getOrNull(0)
            if (char != null)
                hangmanModelView.guessLetter(char, binding.hangmanTextOutput, binding.alphabet, this)
            else
                Toast.makeText(this, "You must submit a letter", Toast.LENGTH_SHORT).show()

            binding.guessLetterInput.setText("")
        }

        setContentView(R.layout.activity_game)
    }
}