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

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner : Spinner = findViewById(R.id.action_bar_spinner_select_register)
        ArrayAdapter.createFromResource(
            this,
            R.array.action_bar_spinner_select_login,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter= adapter
        }
        println("[INFO] Entered Registration Page")

        val context : Context = this
        var firstname_edt : EditText = findViewById(R.id.firstName)
        var lastname_edt : EditText = findViewById(R.id.LastName)
        var email_edt : EditText = findViewById(R.id.emailorphone)
        var pass_edt : EditText = findViewById(R.id.passwordReg)
        var confpass_edt : EditText = findViewById(R.id.confirmpasswordReg)
        val regButton : Button = findViewById(R.id.RegisterinReg)

        regButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val intent = Intent(context,MainActivity::class.java)
                val tempSpinValue : String = spinner.selectedItem.toString()
                println("[INFO] Registration Page - User Type : $tempSpinValue")
                println("[INFO] Registration Page - First Name : " + firstname_edt.text.toString())
                println("[INFO] Registration Page - Last Name : " + lastname_edt.text.toString())
                println("[INFO] Registration Page - Email : " + email_edt.text.toString())
                println("[INFO] Registration Page - Password : " + pass_edt.text.toString())
                println("[INFO] Registration Page - Confirm Password : " + confpass_edt.text.toString())
                startActivity(intent)
            }
        })

    }
}