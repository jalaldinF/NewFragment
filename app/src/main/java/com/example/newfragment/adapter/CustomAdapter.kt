package com.example.newfragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newfragment.R
import com.example.newfragment.model.Contact
import java.time.temporal.TemporalField

class CustomAdapter (val contact:List<Contact>,var listener:ContactListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_contacts,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val contact = contact[position]

        if (holder is CustomViewHolder){
            holder.name.text = contact.name
            holder.phoneNumber.text = contact.phoneNumber.toString()

             holder.lay_click.setOnClickListener{
                 listener.onContactSend(contact)
             }}
    }

    override fun getItemCount(): Int {
       return contact.size
    }

    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name:TextView = view.findViewById(R.id.tv_name)
        val phoneNumber:TextView = view.findViewById(R.id.tv_phoneNumber)
        val lay_click:ConstraintLayout = view.findViewById(R.id.lay_contacts)


    }
    interface ContactListener{
        fun onContactSend(contact:Contact)
    }
}