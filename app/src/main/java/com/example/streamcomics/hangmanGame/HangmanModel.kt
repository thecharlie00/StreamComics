package com.example.streamcomics.hangmanGame

import com.google.gson.annotations.SerializedName

data class HangmanModel(
    val token: String = "",
    val language: String = "",
    val maxTries: Int = 0,
    val incorrectGuesses: Int = 0,
    val correct: Boolean? = null, // Only filled with guess

    @SerializedName("hangman")
    val word: String = "",
    val solution: String? = null
)