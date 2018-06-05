package com.project.dudko.thebeastofthelabyrinth

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_game.*
import java.util.*

class MainGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)


        pause.setOnClickListener {
            val intent = Intent(this, PauseActivity::class.java)
            startActivity(intent)
        }


        button00.setOnClickListener{
            button00.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button01.setOnClickListener{
            button01.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button02.setOnClickListener{
            button02.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button03.setOnClickListener{
            button03.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button04.setOnClickListener{
            button04.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button05.setOnClickListener{
            button05.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button06.setOnClickListener{
            button06.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button07.setOnClickListener{
            button07.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button10.setOnClickListener{
            button10.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button11.setOnClickListener{
            button11.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button12.setOnClickListener{
            button12.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button13.setOnClickListener{
            button13.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button14.setOnClickListener{
            button14.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button15.setOnClickListener{
            button15.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button16.setOnClickListener{
            button16.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button17.setOnClickListener{
            button17.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button20.setOnClickListener{
            button20.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button21.setOnClickListener{
            button21.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button22.setOnClickListener{
            button22.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button23.setOnClickListener{
            button23.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button24.setOnClickListener{
            button24.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button25.setOnClickListener{
            button25.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button26.setOnClickListener{
            button26.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button27.setOnClickListener{
            button27.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button30.setOnClickListener{
            button30.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button31.setOnClickListener{
            button31.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button32.setOnClickListener{
            button32.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button33.setOnClickListener{
            button33.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button34.setOnClickListener{
            button34.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button35.setOnClickListener{
            button35.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button36.setOnClickListener{
            button36.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button37.setOnClickListener{
            button37.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button40.setOnClickListener{
            button40.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button41.setOnClickListener{
            button41.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button42.setOnClickListener{
            button42.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button43.setOnClickListener{
            button43.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button44.setOnClickListener{
            button44.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button45.setOnClickListener{
            button45.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button46.setOnClickListener{
            button46.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button47.setOnClickListener{
            button47.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button50.setOnClickListener{
            button50.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button51.setOnClickListener{
            button51.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button52.setOnClickListener{
            button52.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button53.setOnClickListener{
            button53.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button54.setOnClickListener{
            button54.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button55.setOnClickListener{
            button55.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button56.setOnClickListener{
            button56.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button57.setOnClickListener{
            button57.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button60.setOnClickListener{
            button60.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button61.setOnClickListener{
            button61.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button62.setOnClickListener{
            button62.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button63.setOnClickListener{
            button63.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button64.setOnClickListener{
            button64.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button65.setOnClickListener{
            button65.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button66.setOnClickListener{
            button66.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button67.setOnClickListener{
            button67.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button70.setOnClickListener{
            button70.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button71.setOnClickListener{
            button71.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button72.setOnClickListener{
            button72.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button73.setOnClickListener{
            button73.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button74.setOnClickListener{
            button74.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button75.setOnClickListener{
            button75.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button76.setOnClickListener{
            button76.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }

        button77.setOnClickListener{
            button77.setBackgroundColor(Color.BLACK + (Random().nextInt()) % 16777216)
        }
        
    }
}
