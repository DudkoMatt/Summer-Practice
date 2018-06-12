package com.project.dudko.thebeastofthelabyrinth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_end_of_the_level.*

class EndOfTheLevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_of_the_level)

        /*button_start.setOnClickListener{
            setResult(1)
            finish()
        }*/
        setResult(1)
        button_levels.setOnClickListener{
            finish()
        }
    }
}
