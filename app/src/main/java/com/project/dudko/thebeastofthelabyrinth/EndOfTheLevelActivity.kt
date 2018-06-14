package com.project.dudko.thebeastofthelabyrinth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_end_of_the_level.*

class EndOfTheLevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_of_the_level)


<<<<<<< Updated upstream

        button_start.setOnClickListener{
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

=======
        Won.text = Won.text.toString().replace("level!", "level ${intent.getStringExtra("Level")}!")
        //results.text = "Your results:\nCoins: ${intent.getStringExtra("Coins")}; Time: ${intent.getStringExtra("Time")}; Turns: ${intent.getStringExtra("Turns")}"
        results.text = "Your results:\nCoins: ${intent.getStringExtra("Coins")}" +
                " Turns: ${intent.getStringExtra("Turns")}"
        results.textAlignment = View.TEXT_ALIGNMENT_CENTER
        /*button_start.setOnClickListener{
            setResult(1)
            finish()
        }*/
        setResult(1)
>>>>>>> Stashed changes
        button_levels.setOnClickListener{
            val intent = Intent(this, LevelSelector::class.java)
            startActivity(intent)
        }
    }
}
