package com.example.homwork5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val etProfLogin = findViewById<EditText>(R.id.etProfLogin)
        val etProfPassword = findViewById<EditText>(R.id.etProfPassword)
        val btUpdate = findViewById<Button>(R.id.btUpdate)
        val btExit = findViewById<Button>(R.id.btExit)

        val preference = getSharedPreferences("Preference", Context.MODE_PRIVATE)

        val Exitpreference = getSharedPreferences("Exitpreference", Context.MODE_PRIVATE)

        btUpdate.setOnClickListener {

            val login = etProfLogin.text.toString()
            val password = etProfPassword.text.toString()

            preference.edit().putString("text", login).apply()
            preference.edit().putString("text1", password).apply()
            Toast.makeText(this, "Ваши данные обновились", Toast.LENGTH_SHORT).show()

        }

        btExit.setOnClickListener {
            val login = etProfLogin.text.toString()
            val password = etProfPassword.text.toString()
            Exitpreference.edit().putString("", login).apply()
            Exitpreference.edit().putString("", password).apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}