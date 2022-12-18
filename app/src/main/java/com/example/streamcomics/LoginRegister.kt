package com.example.streamcomics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.streamcomics.databinding.ActivityLoginRegisterBinding
import com.example.streamcomics.databinding.ActivityMainBinding

private lateinit var binding: ActivityLoginRegisterBinding
class LoginRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)
        binding =  ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toLogin.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
        }
        binding.toRegister.setOnClickListener{
            startActivity(Intent(this, Register::class.java))
        }
    }
}