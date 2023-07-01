package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        connectViews()
        setData()

    }

    private fun connectViews(){
        textView=findViewById(R.id.TvName)

    }

    private fun setData(){
        textView.text=intent.getStringExtra("Name")
    }



}