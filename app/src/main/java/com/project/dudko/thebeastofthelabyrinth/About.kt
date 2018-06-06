package com.project.dudko.thebeastofthelabyrinth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataArray = arrayOf("Creators:", "Dudko Matt", "Zaharcev Dmitriy", "Lvov Aleksander", "Sorokin Dmitriy")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataArray)

        list2.adapter = adapter

        button1.setOnClickListener {
          finish()
        }
    }
}