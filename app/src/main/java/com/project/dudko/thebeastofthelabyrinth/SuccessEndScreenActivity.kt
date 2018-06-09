package com.project.dudko.thebeastofthelabyrinth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_success_end_screen.*

class SuccessEndScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_end_screen)
        exit_success.setOnClickListener{
            setResult(1)
            //1 - выйти на главное меню
            finish()
        }
    }
}
