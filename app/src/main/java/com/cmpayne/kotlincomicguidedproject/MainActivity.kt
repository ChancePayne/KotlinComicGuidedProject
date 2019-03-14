package com.cmpayne.kotlincomicguidedproject

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.LayoutDirection
import android.util.Log
import android.view.View
import android.widget.Button

import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class Data(val a: Int, @Optional val b: String = "42")

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewAdapter = CharacterListAdapter(this)
        val viewManager: RecyclerView.LayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(false)

            layoutManager = viewManager

            adapter = viewAdapter
        }
    }
}
