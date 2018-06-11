package com.project.dudko.thebeastofthelabyrinth

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_options.*

class Options : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        val sPref = getSharedPreferences("System", Context.MODE_PRIVATE)
        checkBox1.isChecked = sPref.getBoolean("darkMode", false)
        // Сохраняем состояние в preference
        checkBox1.setOnCheckedChangeListener {buttonView, isChecked ->
            if (isChecked) {
                val sPref = getSharedPreferences("System", Context.MODE_PRIVATE)
                val editor = sPref.edit()
                editor.putBoolean("darkMode", true)
                editor.apply()
            }
            else {
                val sPref = getSharedPreferences("System", Context.MODE_PRIVATE)
                val editor = sPref.edit()
                editor.putBoolean("darkMode", false)
                editor.apply()
            }
        }

        button1.setOnClickListener {
            finish()
        }
    }
}