package com.project.dudko.thebeastofthelabyrinth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_leaderboard.*

class LeaderboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)

        var array = arrayOf("Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6",
                "Level 7", "Level 8", "Level 9")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)

        listview.adapter = adapter

        listview.setOnItemClickListener {
            _, view, _, _ ->
                lookupLevel((view as TextView).text.toString())
        }

        button2.setOnClickListener {
            finish()
        }
    }

    fun newScore(coins: Long, level: String, turns: Long) {
        val dbHandler = ScoreDBHandler(this, null, null, 1)
        val score = Score(level, coins, turns)
        dbHandler.addScore(score)
        dbHandler.close()
    }

    fun lookupLevel(level: String) {
        val dbHandler = ScoreDBHandler(this, null, null, 1)

        val scores = dbHandler.findLevel(level)

        if (scores != null) {
            scoreboard.text = scores
        } else if (scores == ""){
            scoreboard.text = "No Match Found"
        } else {
            scoreboard.text = "No Match Found"
        }


    }


    fun removeScores(view: View) {
        val dbHandler = ScoreDBHandler(this, null, null, 1)
        dbHandler.deleteScores()
        scoreboard.text = ""
    }
}
