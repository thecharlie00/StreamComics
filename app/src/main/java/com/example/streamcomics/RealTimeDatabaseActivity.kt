package com.example.streamcomics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.streamcomics.databinding.ActivityLibraryBinding
import com.example.streamcomics.databinding.ActivityRealTimeDatabaseBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RealTimeDatabaseActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityRealTimeDatabaseBinding
    private  lateinit var  database: FirebaseDatabase

    private  val scores: ArrayList<Score> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityRealTimeDatabaseBinding.inflate(layoutInflater)

        Firebase.database("https://streamcomics-20a04-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("scores")



    }
}