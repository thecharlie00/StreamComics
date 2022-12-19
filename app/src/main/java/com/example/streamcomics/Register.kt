package com.example.streamcomics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.streamcomics.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backRegister.setOnClickListener {
            startActivity(Intent(this, LoginRegister::class.java))
        }
        binding.nextRegister.setOnClickListener {
            startActivity(Intent(this, Library::class.java))
        }


    }
}