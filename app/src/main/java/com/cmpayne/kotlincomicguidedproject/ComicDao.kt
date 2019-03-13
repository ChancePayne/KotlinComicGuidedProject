package com.cmpayne.kotlincomicguidedproject

import kotlinx.serialization.json.Json

object ComicDao {

    const val CHARACTERS_URL = "https://api.comicvine.com/characters?api_key=789825a0e6665829732b5a594a79157f246c0ebe&format=json&limit=10"

    interface CharactersCallback {
        fun callback(list: List<Character>)
    }

    fun getCharacters(callback: CharactersCallback) {
        NetworkAdapter.httpGetRequest(CHARACTERS_URL, object: NetworkAdapter.NetworkCallback {
            override fun returnResult(success: Boolean?, result: String) {
                if(success == true) {
                    val characterList = Json.parse(CharacterList.serializer(), result)

                    callback.callback(characterList.results?: listOf())
                }
            }
        })
    }
}