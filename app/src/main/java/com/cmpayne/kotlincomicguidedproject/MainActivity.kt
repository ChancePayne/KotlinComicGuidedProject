package com.cmpayne.kotlincomicguidedproject

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button

import kotlinx.serialization.*
import kotlinx.serialization.json.Json

@Serializable
data class Data(val a: Int, @Optional val b: String = "42")

fun libraryTest() {
    // serializing objects
    val jsonData = Json.stringify(Data.serializer(), Data(42))
    // serializing lists
    val jsonList = Json.stringify(Data.serializer().list, listOf(Data(42)))
    println(jsonData) // {"a": 42, "b": "42"}
    println(jsonList) // [{"a": 42, "b": "42"}]

    // parsing data back
    val obj = Json.parse(Data.serializer(), """{"a":42}""")
    println(obj) // Data(a=42, b="42")
}

class MainActivity : AppCompatActivity() {

//    private var viewManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewAdapter = CharacterListAdapter(this)
        val viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(false)

            layoutManager = viewManager

            adapter = viewAdapter
        }

        /*val jsonString = "{\n" +
                "    \"error\": \"OK\",\n" +
                "    \"limit\": 1,\n" +
                "    \"offset\": 0,\n" +
                "    \"number_of_page_results\": 1,\n" +
                "    \"number_of_total_results\": 131093,\n" +
                "    \"status_code\": 1,\n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"aliases\": \"Garth Ranzz\\nLightning Boy\\nProty\\nLive Wire\\nStarfinger\\nLightning Man\",\n" +
                "            \"api_detail_url\": \"https://comicvine.gamespot.com/api/character/4005-1253/\",\n" +
                "            \"birth\": null,\n" +
                "            \"count_of_issue_appearances\": 903,\n" +
                "            \"date_added\": \"2008-06-06 11:27:37\",\n" +
                "            \"date_last_updated\": \"2017-08-29 21:57:24\",\n" +
                "            \"deck\": \"Garth Ranzz is one of the three original members/founders, of the Legion, of Super-Heroes. Empowered, with the ability, to control electricity, he is called Lightning Lad.  Garth is, the twin brother of fellow legionnaire Lightning Lass, and the younger brother, of Lightning Lord.\",\n" +
                "            \"description\": \"<h2>Origin</h2><figure\",\n" +
                "            \"first_appeared_in_issue\": {\n" +
                "                \"api_detail_url\": \"https://comicvine.gamespot.com/api/first_appeared_in_issue/4000-114594/\",\n" +
                "                \"id\": 114594,\n" +
                "                \"name\": \"The Legion of Super-Heroes\",\n" +
                "                \"issue_number\": \"247\"\n" +
                "            },\n" +
                "            \"gender\": 1,\n" +
                "            \"id\": 1253,\n" +
                "            \"image\": {\n" +
                "                \"icon_url\": \"https://comicvine.gamespot.com/api/image/square_avatar/6031055-ll4.jpg\",\n" +
                "                \"medium_url\": \"https://comicvine.gamespot.com/api/image/scale_medium/6031055-ll4.jpg\",\n" +
                "                \"screen_url\": \"https://comicvine.gamespot.com/api/image/screen_medium/6031055-ll4.jpg\",\n" +
                "                \"screen_large_url\": \"https://comicvine.gamespot.com/api/image/screen_kubrick/6031055-ll4.jpg\",\n" +
                "                \"small_url\": \"https://comicvine.gamespot.com/api/image/scale_small/6031055-ll4.jpg\",\n" +
                "                \"super_url\": \"https://comicvine.gamespot.com/api/image/scale_large/6031055-ll4.jpg\",\n" +
                "                \"thumb_url\": \"https://comicvine.gamespot.com/api/image/scale_avatar/6031055-ll4.jpg\",\n" +
                "                \"tiny_url\": \"https://comicvine.gamespot.com/api/image/square_mini/6031055-ll4.jpg\",\n" +
                "                \"original_url\": \"https://comicvine.gamespot.com/api/image/original/6031055-ll4.jpg\",\n" +
                "                \"image_tags\": \"All Images,Images From Editing,New Earth\"\n" +
                "            },\n" +
                "            \"name\": \"Lightning Lad\",\n" +
                "            \"origin\": {\n" +
                "                \"api_detail_url\": \"https://comicvine.gamespot.com/api/origin/4030-3/\",\n" +
                "                \"id\": 3,\n" +
                "                \"name\": \"Alien\"\n" +
                "            },\n" +
                "            \"publisher\": {\n" +
                "                \"api_detail_url\": \"https://comicvine.gamespot.com/api/publisher/4010-10/\",\n" +
                "                \"id\": 10,\n" +
                "                \"name\": \"DC Comics\"\n" +
                "            },\n" +
                "            \"real_name\": \"Garth Ranzz\",\n" +
                "            \"site_detail_url\": \"https://comicvine.gamespot.com/lightning-lad/4005-1253/\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"version\": \"1.0\"\n" +
                "}"

        val list = Json.parse(CharacterList.serializer(), jsonString)
        println(list)

//        val stringified = Json.stringify(CharacterList.serializer(), CharacterList())
//        println(stringified)*/
    }
}
