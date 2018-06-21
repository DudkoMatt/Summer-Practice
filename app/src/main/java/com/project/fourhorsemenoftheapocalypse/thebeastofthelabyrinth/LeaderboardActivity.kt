package com.project.fourhorsemenoftheapocalypse.thebeastofthelabyrinth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_leaderboard.*

class LeaderboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)


        level_number.setOnItemClickListener {
            parent, view, position, id ->
            var scores = lookupLevel((view as TextView).text.toString())
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, scores[0])
            val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, scores[1])
            list_time.adapter = adapter
            list_coins.adapter = adapter1
        }

        //val scores = lookupLevel( level_number.onItemSelectedListener(this))


    }

    fun newScore(coins: Long, level: String, turns: Long) {
        val dbHandler = ScoreDBHandler(this, null, null, 1)
        val score = Score(level, coins, turns)
        dbHandler.addScore(score)
        dbHandler.close()
    }

    fun lookupLevel(level: String): MutableList<MutableList<String>> {
        val dbHandler = ScoreDBHandler(this, null, null, 1)

       return dbHandler.findLevel(level)


    }

    fun removeScores(view: View) {
        val dbHandler = ScoreDBHandler(this, null, null, 1)
        dbHandler.deleteScores()

        //Очищаем поля, где находятся все отображенные рекорды
        //Может быть сработает. Попробуй. Если что, пиши)
        var a = Array(0){""}
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, a)
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, a)
        list_time.adapter = adapter
        list_coins.adapter = adapter1
    }
}
