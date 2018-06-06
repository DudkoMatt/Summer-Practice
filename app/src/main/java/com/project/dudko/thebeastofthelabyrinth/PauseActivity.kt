package com.project.dudko.thebeastofthelabyrinth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pause.*

class PauseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pause)
        button_continue.setOnClickListener{
            val intent = Intent(this, MainGameActivity::class.java)
            startActivity(intent)
        }
    }
}
