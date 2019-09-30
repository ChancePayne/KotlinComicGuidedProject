package com.cmpayne.kotlincomicguidedproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_character_details.*

class CharacterDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        text_name.text = "Hello"
        text_name.contentDescription = "Label Description"


    }
}
