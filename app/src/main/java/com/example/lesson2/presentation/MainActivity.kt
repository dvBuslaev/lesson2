package com.example.lesson2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lesson2.R
import com.example.lesson2.presentation.authFragment.AuthFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragment(AuthFragment.newInstance())
    }




    private fun startFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).addToBackStack(null).commit()
    }


}