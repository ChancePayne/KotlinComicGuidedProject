package com.cmpayne.kotlincomicguidedproject

import android.support.annotation.WorkerThread
import kotlinx.serialization.json.Json

object ComicDao {

    const val CHARACTERS_URL =
        "https://comicvine.gamespot.com/api/characters?api_key=789825a0e6665829732b5a594a79157f246c0ebe&format=json"
//    const val CHARACTERS_URL = "https://api.comicvine.com/characters?api_key=789825a0e6665829732b5a594a79157f246c0ebe&format=json&limit=10"

    interface CharactersCallback {
        fun callback(list: List<Character>)
    }

    fun getCharacters(callback: CharactersCallback, offset: Int = 0, limit: Int = 10) {
        NetworkAdapter.httpGetRequest(
            "$CHARACTERS_URL&limit=$limit&offset=$offset",
            object : NetworkAdapter.NetworkCallback {
                override fun returnResult(success: Boolean?, result: String) {
                    if (success == true) {
                        val characterList = Json.parse(CharacterList.serializer(), result)

                        callback.callback(characterList.results ?: listOf())
                    }
                }
            })
    }

    @WorkerThread
    suspend fun getCharacters(offset: Int = 0, limit: Int = 10): List<Character> {
        val (success, result) = NetworkAdapter.httpGetRequest("$CHARACTERS_URL&limit=$limit&offset=$offset")
        var characterList: CharacterList? = null
        if (success) {
            characterList = Json.parse(CharacterList.serializer(), result)
        }
        return characterList?.results ?: listOf<Character>()
    }
}