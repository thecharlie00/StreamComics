package com.example.streamcomics.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.streamcomics.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private  lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()

        setContentView(binding.root)



        binding.back.setOnClickListener{
            startActivity(Intent(this, LoginRegister::class.java))
        }
        binding.next.setOnClickListener{
            val email = binding.loginMail.text.toString()
            val password = binding.loginPassword.text.toString()


            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                    if(it.isSuccessful){
                       // val intent = Intent(this, Library::class.java)
                        //startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                       print(it.exception.toString())
                    }
                }

            }else{
                Toast.makeText(this, "Empty fills are not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}