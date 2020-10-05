package com.example.presentation.screens

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager
    private lateinit var fragmentJokes: FragmentJokes
    private lateinit var fragmentWeb: FragmentWeb
    private lateinit var textLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentJokes = FragmentJokes.getInstance(fragmentManager)
        fragmentWeb = FragmentWeb.getInstance(fragmentManager)
        textLabel = findViewById(R.id.name_tab)

        savedInstanceState?.let { } ?: run {
            textLabel.text = this.getText(R.string.tab_jokes)
            fragmentManager.beginTransaction().add(R.id.container_fragment, fragmentJokes)
                .commit()
        }

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_jokes -> {
                    textLabel.text = this.getText(R.string.tab_jokes)
                    fragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, fragmentJokes).commit(); true
                }
                else -> {
                    textLabel.text = this.getText(R.string.tab_api)
                    fragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, fragmentWeb).commit(); true
                }
            }
        }
    }
}
