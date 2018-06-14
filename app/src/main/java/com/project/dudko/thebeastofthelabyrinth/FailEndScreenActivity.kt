package com.project.dudko.thebeastofthelabyrinth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fail_end_screen.*

class FailEndScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fail_end_screen)
        setResult(1)
        exit_fail.setOnClickListener{
            finish()
        }
    }
}
