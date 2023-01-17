package com.example.streamcomics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.streamcomics.databinding.ActivityLibraryBinding
import com.example.streamcomics.databinding.ActivityRealTimeDatabaseBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RealTimeDatabaseActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityRealTimeDatabaseBinding
    private  lateinit var  database: DatabaseReference

    private  val scores: ArrayList<Score> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityRealTimeDatabaseBinding.inflate(layoutInflater)

        Firebase.database("https://streamcomics-20a04-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("scores")


        binding.sendButton.setOnClickListener(){
            val scoreField = binding.score.text.toString()
            if(scoreField.isNotEmpty()){
                val newScore = Score("NewScore")
                newScore.scores.add(scoreField)
                scores.add(newScore)
                database.child(newScore.id)
                    .setValue(newScore)
                database.child(newScore.id).addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val c = snapshot.getValue(Score::class.java)
                        Toast.makeText(
                            this@RealTimeDatabaseActivity,
                            "${c?.scores}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    override fun onCancelled(error: DatabaseError)= Unit

                })
            }else{
                Toast.makeText(this, "Empty fills are not allowed", Toast.LENGTH_SHORT).show()
            }

        }
    }
}