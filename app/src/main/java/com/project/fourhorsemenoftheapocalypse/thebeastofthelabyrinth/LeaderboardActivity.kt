package com.project.fourhorsemenoftheapocalypse.thebeastofthelabyrinth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.project.fourhorsemenoftheapocalypse.thebeastofthelabyrinth.R.id.level_number
import com.project.fourhorsemenoftheapocalypse.thebeastofthelabyrinth.R.id.list_time
import kotlinx.android.synthetic.main.activity_leaderboard.*
import android.widget.ArrayAdapter



class LeaderboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)

        button2.setOnClickListener{
            finish()
        }
        val spinner = findViewById(R.id.level_number) as Spinner

        spinner.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, resources.getStringArray(R.array.Levels))

        val context = this

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {



                var scores = lookupLevel((view as TextView).text.toString())
                val adapter = ArrayAdapter(context,  android.R.layout.simple_list_item_1, scores[0])
                val adapter1 = ArrayAdapter(context, android.R.layout.simple_list_item_1, scores[1])
                val listView = findViewById(R.id.list_time) as ListView
                list_time.adapter = adapter
                val list_coins = findViewById(R.id.list_coins) as ListView
                list_coins.adapter = adapter1
            }
        }



            }
        //level_number.OnItemSelectedListener {
        // parent, view, position, id ->
//            var scores = lookupLevel((view as TextView).text.toString())
//            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, scores[0])
//            val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, scores[1])
//            list_time.adapter = adapter
//            list_coins.adapter = adapter1

        //val scores = lookupLevel( level_number.onItemSelectedListener(this))




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

        var a = Array(0){""}
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, a)
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, a)
        list_time.adapter = adapter
        list_coins.adapter = adapter1
    }
}
