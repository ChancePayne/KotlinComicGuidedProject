package com.cmpayne.kotlincomicguidedproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import kotlinx.serialization.*
import org.json.JSONObject

@Serializable
data class Data(val a: Int, @Optional val b: String = "42")




/*fun libraryTest() {
    // serializing objects
    val jsonData = Json.stringify(Data.serializer(), Data(42))
    // serializing lists
    val jsonList = Json.stringify(Data.serializer().list, listOf(Data(42)))
    println(jsonData) // {"a": 42, "b": "42"}
    println(jsonList) // [{"a": 42, "b": "42"}]

    // parsing data back
    val obj = Json.parse(Data.serializer(), """{"a":42}""")
    println(obj) // Data(a=42, b="42")
}*/

class MainActivity : AppCompatActivity() {

//    private var viewManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getColor(R.color.colorAccent)

        resources.getColor(R.color.colorAccent)


        val my_text_view = TextView(this)
        val color = ContextCompat.getColor(
            this, R.color.colorAccent)
        my_text_view.setBackgroundColor(color)


        ContextCompat.getDrawable(this, R.drawable.tooltip_frame_dark)

        MainScope().launch {
            withContext(Dispatchers.IO) {
                val tokenRequest = NetworkAdapter.httpRequest(
                    "https://api.thetvdb.com/login", "POST",
                    content = "{\n" +
                            "  \"apikey\": \"990WW9UD3AIKYGDJ\",\n" +
                            "  \"userkey\": \"AX0YQ5KG9QEATBRV\",\n" +
                            "  \"username\": \"mormon.ninja005z4y\"\n" +
                            "}",
                    headerProperties = mapOf(
                        "Content-Type" to "application/json",
                        "Accept" to "application/json")
                )
                println(tokenRequest)
                val token = JSONObject(tokenRequest).getString("token")
                val result = NetworkAdapter.httpRequest(
                    "https://api.thetvdb.com/search/series?name=haunting", "GET",
                    headerProperties = mapOf(
                        "Authorization" to "Bearer $token",
                        "Content-Type" to "application/json",
                        "Accept" to "application/json")
                )
                Log.i("Authentication", result)
            }
        }

        val viewAdapter = CharacterListAdapter()
        val viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
//        findViewById<RecyclerView>(R.id.recycler_view).apply {
        recycler_view.apply {
            setHasFixedSize(false)

            layoutManager = viewManager

            adapter = viewAdapter
        }
    }
}
