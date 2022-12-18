package com.example.streamcomics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.streamcomics.databinding.ActivityRegisterBinding

private  lateinit var binding: ActivityRegisterBinding
class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        binding.backRegister.setOnClickListener{
            startActivity(Intent(this, LoginRegister::class.java))
        }
        binding.nextRegister.setOnClickListener{
            startActivity(Intent(this, Library::class.java))
        }
    }
}