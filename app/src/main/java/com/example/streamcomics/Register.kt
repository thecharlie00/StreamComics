package com.example.streamcomics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.streamcomics.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private  lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.backRegister.setOnClickListener {
            startActivity(Intent(this, LoginRegister::class.java))
        }
        binding.nextRegister.setOnClickListener {
            val email = binding.mailRegister.text.toString()
            val password = binding.registerPassword.text.toString()
            val confirmPassword = binding.registerPassword2.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if(password == confirmPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener() {
                        if(it.isSuccessful){
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                   Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Empty fills are not allowed", Toast.LENGTH_SHORT).show()
            }
        }


    }
}