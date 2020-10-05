package com.example.presentation.screens

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let { } ?: run {
            setNameTab(this.getText(R.string.tab_jokes).toString())
            supportFragmentManager.beginTransaction()
                .add(R.id.container_fragment, FragmentJokes.getInstance(supportFragmentManager))
                .commit()
        }

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_jokes -> {
                    setNameTab(this.getText(R.string.tab_jokes).toString())
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container_fragment,
                            FragmentJokes.getInstance(supportFragmentManager)
                        ).commit(); true
                }
                else -> {
                    setNameTab(this.getText(R.string.tab_api).toString())
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container_fragment,
                            FragmentWeb.getInstance(supportFragmentManager)
                        ).commit(); true
                }
            }
        }
    }

    private fun setNameTab(name: String) {
        findViewById<TextView>(R.id.name_tab).text = name
    }
}

