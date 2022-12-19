package com.example.streamcomics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.streamcomics.databinding.ActivityLibraryBinding

class Library : AppCompatActivity() {

    private  lateinit var binding: ActivityLibraryBinding
    private  var archiveList:MutableList<Archivo> = mutableListOf()
    private  lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)



        archiveList.add(Archivo("Spiderman 1"))
        archiveList.add(Archivo("Spiderman 2"))
        archiveList.add(Archivo("Spiderman 3"))
        startAdapter()

    }

    private  fun startAdapter(){
        recycler = binding.list
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecycleArchive(this, archiveList)
    }
}