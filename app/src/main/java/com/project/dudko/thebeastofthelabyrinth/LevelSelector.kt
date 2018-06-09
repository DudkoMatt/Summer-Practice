package com.project.dudko.thebeastofthelabyrinth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_level_selector.*

class LevelSelector : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_selector)
        button_back.setOnClickListener {
            finish()
        }
        button_1.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "1")
            startActivity(intent)
        }
        button_2.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "2")
            startActivity(intent)
        }
    }
}