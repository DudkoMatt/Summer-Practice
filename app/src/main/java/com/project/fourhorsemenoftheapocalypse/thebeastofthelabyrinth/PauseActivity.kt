package com.project.fourhorsemenoftheapocalypse.thebeastofthelabyrinth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_pause.*

class PauseActivity : AppCompatActivity() {


    //0 - продолжить
    //1 - выйти

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pause)
        button_continue.setOnClickListener {
            setResult(0)
            finish()
        }

        button_exit.setOnClickListener {
            setResult(1)
            finish()
        }
    }
}
