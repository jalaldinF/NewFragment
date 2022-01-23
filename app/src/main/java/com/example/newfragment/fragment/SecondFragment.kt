package com.example.newfragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.newfragment.R
import com.example.newfragment.model.Contact
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

private lateinit var TextView:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        initViews(rootView)

        return rootView

     }

    private fun initViews(rootView: View) {
        TextView = rootView.findViewById(R.id.tv_showContacts)
    }

    fun updateContact(contact: Contact){
        val data:String = " ${contact.name} ${contact.phoneNumber} "
        tv_showContacts.text = data
    }
}