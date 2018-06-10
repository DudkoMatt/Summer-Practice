package com.project.dudko.thebeastofthelabyrinth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_end_of_the_level.*

class EndOfTheLevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_of_the_level)



        button_start.setOnClickListener{
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

        button_levels.setOnClickListener{
            val intent = Intent(this, LevelSelector::class.java)
            startActivity(intent)
        }
    }
}
