package com.Aditya.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var titleName="Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnLogOut : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.scrollview_example)
        titleName= sharedPreferences.getString("Title","The Avengers")!!

        title=titleName

        btnLogOut=findViewById(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }
    }

}