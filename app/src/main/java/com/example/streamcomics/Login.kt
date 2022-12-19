package com.example.streamcomics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.streamcomics.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)



        binding.back.setOnClickListener{
            startActivity(Intent(this, LoginRegister::class.java))
        }
        binding.next.setOnClickListener{
            startActivity(Intent(this, Library::class.java))
        }
    }
}