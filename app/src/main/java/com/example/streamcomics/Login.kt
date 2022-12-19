package com.example.streamcomics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.streamcomics.databinding.ActivityLoginBinding

private lateinit var binding: ActivityLoginBinding
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        binding.back.setOnClickListener{
            startActivity(Intent(this, LoginRegister::class.java))
        }
        binding.next.setOnClickListener{
            startActivity(Intent(this, Library::class.java))
        }
    }
}