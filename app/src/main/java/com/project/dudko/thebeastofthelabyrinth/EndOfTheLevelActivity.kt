package com.project.dudko.thebeastofthelabyrinth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_end_of_the_level.*

class EndOfTheLevelActivity : AppCompatActivity() {

    fun newScore(coins: Long, level: String, turns: Long) {
        val dbHandler = ScoreDBHandler(this, null, null, 1)
        val score = Score(level, coins, turns)
        dbHandler.addScore(score)
        dbHandler.close()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_of_the_level)


        Won.text = Won.text.toString().replace("level!", "level ${intent.getStringExtra("Level")}!")
        //results.text = "Your results:\nCoins: ${intent.getStringExtra("Coins")}; Time: ${intent.getStringExtra("Time")}; Turns: ${intent.getStringExtra("Turns")}"
        results.text = "Your results:\nCoins: ${intent.getStringExtra("Coins")}; Turns: ${intent.getStringExtra("Turns")}"
        results.textAlignment = View.TEXT_ALIGNMENT_CENTER
        /*button_start.setOnClickListener{
            setResult(1)
            finish()
        }*/

        newScore(intent.getStringExtra("Coins").toLong(), "Level ${intent.getStringExtra("Level")}", intent.getStringExtra("Turns").toLong())

        setResult(1)
        button_levels.setOnClickListener{
            finish()
        }
    }
}
