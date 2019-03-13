package com.cmpayne.kotlincomicguidedproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        findViewById<Button>(R.id.button).setOnClickListener { Log.i("MainActivity", "Button Clicked!") }

        findViewById<Button>(R.id.button).setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Log.i("MainActivity", "Button Clicked!")
            }

        })
    }
}
