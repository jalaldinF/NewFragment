package com.example.newfragment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newfragment.R
import com.example.newfragment.fragment.FirstFragment
import com.example.newfragment.fragment.SecondFragment
import com.example.newfragment.model.Contact

class MainActivity : AppCompatActivity(),FirstFragment.FirstListener {

    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          initViews()
    }


    private fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_first,firstFragment)
            .replace(R.id.frame_second,secondFragment)
            .commit()

    }

    override fun onFirsSend(contact: Contact) {
        secondFragment.updateContact(contact)
    }
}