package com.example.user.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lvl1.setOnClickListener {

            /*val intent1= Intent(this,lvlactivity1::class.java)
            startActivity(intent1)*/
        }
        lvl2.setOnClickListener {

            /*val intent2= Intent(this,lvlactivity2::class.java)
            startActivity(intent2)*/
        }
        lvl3.setOnClickListener {

            /*val intent3= Intent(this,lvlactivity3::class.java)
            startActivity(intent3)*/
        }
    }
}