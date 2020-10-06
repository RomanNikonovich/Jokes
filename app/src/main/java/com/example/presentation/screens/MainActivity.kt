package com.example.presentation.screens

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.R
import com.example.presentation.utils.switch
import com.google.android.material.bottomnavigation.BottomNavigationView

const val TAG_F1 = "f1"
const val TAG_F2 = "f2"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {}
            ?: run {
                supportFragmentManager.switch(R.id.container_fragment, FragmentJokes.getInstance(supportFragmentManager), TAG_F1 )
            }

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_jokes -> {
                    supportFragmentManager.switch(R.id.container_fragment, FragmentJokes.getInstance(supportFragmentManager), TAG_F1 )
                    ; true
                }
                else -> {
                    supportFragmentManager.switch(R.id.container_fragment, FragmentWeb.getInstance(supportFragmentManager), TAG_F2 )
                    ; true
                }
            }
        }
    }

}
