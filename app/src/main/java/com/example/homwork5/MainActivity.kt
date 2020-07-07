package com.example.homwork5

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etLogin = findViewById<EditText>(R.id.etLogin)
        val etPaswword = findViewById<EditText>(R.id.etPassword)
        val btLogin = findViewById<Button>(R.id.btLogin)
        val btRegistration = findViewById<Button>(R.id.btRegistration)

        val preference = getSharedPreferences("prefecence", Context.MODE_PRIVATE)

        btRegistration.setOnClickListener {
            val login = etLogin.text.toString()
            val password = etPaswword.text.toString()
            preference.edit().putString("text", login).apply()
            preference.edit().putString("text1", password).apply()
            Toast.makeText(this, "Ваши данные сохранились", Toast.LENGTH_SHORT).show()

        }
        btLogin.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            if (etLogin.text.toString().equals("nurik") && etPaswword.text.toString().equals("12345")
            ) {
                Toast.makeText(this, "Вы вошли через логин", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Ваш логин и пароль не совпадают", Toast.LENGTH_SHORT).show()
            }
            /*val FromLogin = preference.getString("text", "no saved Login")
            val FromPassword = preference.getString("text1", "no saved Password")
            etLogin.setText(FromLogin)
            etPaswword.setText(FromPassword)*/
        }
    }
}