package com.Aditya.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity() : AppCompatActivity(){
     lateinit var img:ImageView
    lateinit var etMobileNumber:EditText
    lateinit var password:EditText
    lateinit var btn:Button
    lateinit var forgpass:TextView
    lateinit var reg:TextView
    val validMobileNumber="012345678"
    val validPassword=arrayOf("tony","steve","bruce","thanos")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_new)
        if(isLoggedIn){
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        title="Login Page"

        img=findViewById(R.id.logo)
        etMobileNumber=findViewById(R.id.Pn)
        password=findViewById(R.id.password)
        btn=findViewById(R.id.loginButton)
        forgpass=findViewById(R.id.forgotPassword)
        reg=findViewById(R.id.register)
        var nameOfAvenger: String
        val intent = Intent(this@LoginActivity, MainActivity::class.java)

        btn.setOnClickListener {
            val mobileNumber=etMobileNumber.text.toString()
            val pass=password.text.toString()
            if(mobileNumber==validMobileNumber){
                if(pass == validPassword[0]){
                    nameOfAvenger="Iron Man"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(pass==validPassword[1]){
                    nameOfAvenger="Captain America"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(pass == validPassword[2]){
                    nameOfAvenger="The Hulk"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }
                else if(pass==validPassword[3]){
                    nameOfAvenger="The Avengers"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }

            }
            else{
                Toast.makeText(this@LoginActivity,
                    "Invalid Credentials",
                    Toast.LENGTH_LONG).show()
            }
        }
        forgpass.setOnClickListener{
            Toast.makeText(this@LoginActivity,
                "Bhaag fir idhar se",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}