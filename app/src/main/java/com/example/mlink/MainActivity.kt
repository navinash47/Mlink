package com.example.mlink

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner : Spinner = findViewById(R.id.action_bar_spinner_select_login)
        ArrayAdapter.createFromResource(
            this,
            R.array.action_bar_spinner_select_login,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter= adapter
        }
        val context: Context = this
        var usern : EditText
        var passw : EditText
        val loginButton: Button = findViewById(R.id.Login)
        loginButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                usern = findViewById(R.id.Username)
                passw = findViewById(R.id.Password)
                val tempSpinValue : String = spinner.selectedItem.toString()
                println("[INFO] Usertype : $tempSpinValue")
                println("[INFO] UserName : "+ usern.text.toString())
                println("[INFO] PassWord : "+ passw.text.toString())
                val intent = Intent ( context, HomepageActivity::class.java)
                startActivity(intent)
            }
        })
        val registerButton : Button = findViewById(R.id.Register)
        registerButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(context, RegisterActivity::class.java)
                startActivity(intent)
            }
        })
    }
}