package com.project.dudko.thebeastofthelabyrinth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.project.dudko.thebeastofthelabyrinth.R.layout.activity_help
import com.project.dudko.thebeastofthelabyrinth.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        about.setOnClickListener{
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }

        help.setOnClickListener {
            val intent2 = Intent( this, Help::class.java)
            startActivity(intent2)
        }

        start.setOnClickListener {
            val intent3 = Intent( this, LevelSelector::class.java )
            startActivity(intent3)
        }

        options.setOnClickListener {
            val intent4 = Intent( this, Options::class.java)
            startActivity(intent4)
        }

}
}