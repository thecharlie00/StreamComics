package com.example.streamcomics.hangmanGame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.children
import com.example.classhangman.game.GameAnimationsBinder
import com.example.streamcomics.R
import com.example.streamcomics.databinding.ActivityGameBinding
import com.example.streamcomics.databinding.ActivityGameBinding.inflate

class GameActivity : AppCompatActivity() {
    lateinit var binding: ActivityGameBinding
    lateinit var hangmanModelView: HangmanModelView
    lateinit var animator: GameAnimationsBinder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animator = GameAnimationsBinder(binding).startAnimations()



        hangmanModelView.hangman.observe(this) { it ->
            binding.hangmanTextOutput.text = it.word.replace("_", "_ ")

            //if (it?.correct == false)
            //animator.failAnimation()

            //it?.solution?.let { solution ->
            //Toast.makeText(this, solution, Toast.LENGTH_SHORT).show()
            //}
        }

        hangmanModelView.alphabet.observe(this) { alphabet ->
            var usedLetters = ""
            alphabet.forEach { (char, isUsed) ->
                if (isUsed)
                    usedLetters += "$char,"
            }
            binding.keyboard.children.forEach { key ->
                val letter = resources.getResourceName(key.id).lowercase().last()
                if (alphabet[letter] == true && key is ImageButton) {
                    key.isEnabled = false
                    key.setColorFilter(0x81989898.toInt())
                }
            }

        }
        hangmanModelView.gameSate.observe(this) {
            if (it == HangmanModelView.GameState.PLAYING)
                return@observe

            // Lock all keys
            binding.keyboard.children.forEach { key ->
                if (key is ImageButton) {
                    key.isEnabled = false
                    key.setColorFilter(0x81989898.toInt())
                }
            }
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)

            if (it == HangmanModelView.GameState.LOST) {
                animator.loseGame()
                builder.setTitle("You lose :(")
                    .setMessage("Retry?")
            } else if (it == HangmanModelView.GameState.WON) {
                animator.winGame()
                builder.setTitle("You are save")
                    .setMessage("Play again?")
            }

            builder.setPositiveButton("Of course!") { _, _ ->
                finish()
                startActivity(Intent(this, GameActivity::class.java))
            }
            builder.setNegativeButton("No") { _, _ -> }

            builder.create().show()
        }



    }
}

