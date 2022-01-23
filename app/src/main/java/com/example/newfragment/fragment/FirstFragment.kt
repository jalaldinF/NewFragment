package com.example.newfragment.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newfragment.R
import com.example.newfragment.adapter.CustomAdapter
import com.example.newfragment.model.Contact
import java.lang.RuntimeException

class FirstFragment : Fragment() {

   private  var listener: FirstListener? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_first, container, false)
        initViews(rootView)

        val contact = prepareList()
        refreshAdapter(contact)

        return rootView

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FirstListener){
        listener = context
        }else {
            throw RuntimeException("Time is up!")
        }
    }


    fun refreshAdapter(contacts: List<Contact>){
       val adapter = CustomAdapter(contacts,object :CustomAdapter.ContactListener{
            override fun onContactSend(contact: Contact) {
                listener?.onFirsSend(contact)
            }

        })
        recyclerView.adapter = adapter
    }

    fun prepareList():List<Contact>{
        val contact = ArrayList<Contact>()

        for (i in 0..15){
            contact.add(Contact("Jalal-ad-Adin",941000543))
        }
      return contact
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
    }
    interface FirstListener{
        fun onFirsSend(contact: Contact)
    }
}