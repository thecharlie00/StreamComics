package com.example.streamcomics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RecycleArchive(var context: Context, var archiveList:MutableList<Archivo>):
    RecyclerView.Adapter<RecycleArchive.miHolder>() {
    inner class  miHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var archiveSlot: TextView
        init {
            archiveSlot = itemView.findViewById(R.id.archive)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): miHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.archive_slot, parent, false)
        return miHolder(itemView)
    }

    override fun onBindViewHolder(holder: miHolder, position: Int) {
        var archive = archiveList[position]
        holder.archiveSlot.text = archive.Title
    }

    override fun getItemCount(): Int {
        return archiveList.size
    }
}