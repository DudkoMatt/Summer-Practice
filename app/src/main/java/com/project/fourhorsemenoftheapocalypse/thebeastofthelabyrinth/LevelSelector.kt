package com.project.fourhorsemenoftheapocalypse.thebeastofthelabyrinth

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
        lvl1.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "1")
            startActivity(intent)
        }
        lvl2.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "2")
            startActivity(intent)
        }
        lvl3.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "3")
            startActivity(intent)
        }
        lvl4.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "4")
            startActivity(intent)
        }
        lvl5.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "5")
            startActivity(intent)
        }
        lvl6.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "6")
            startActivity(intent)
        }
        lvl7.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "7")
            startActivity(intent)
        }
        lvl8.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "8")
            startActivity(intent)
        }
        lvl9.setOnClickListener {
            val intent = Intent(this, MainGameActivity::class.java)
            intent.putExtra("Id_Of_Level", "9")
            startActivity(intent)
        }
    }
}
