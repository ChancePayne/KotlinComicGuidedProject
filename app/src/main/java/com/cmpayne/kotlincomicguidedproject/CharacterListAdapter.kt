package com.cmpayne.kotlincomicguidedproject

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CharacterListAdapter(val activity: Activity): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class CharacterItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val characterNameView: TextView = view.findViewById(R.id.item_character_name)
        val publisherNameView: TextView = view.findViewById(R.id.item_publisher_name)
    }

    companion object {
        const val ITEMS_PER_QUERY = 10
    }

    val data = mutableListOf<Character>()

    init {
        getItems()
    }

    private fun getItems(offset: Int = 0, limit:Int = ITEMS_PER_QUERY) {
        Log.i("ListAdapter", "Querying offset $offset")
        ComicDao.getCharacters(offset = offset, limit = limit,
            callback = object : ComicDao.CharactersCallback {
            override fun callback(list: List<Character>) {
                data.addAll(list)
                activity.runOnUiThread { notifyDataSetChanged() }
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.character_item_layout, parent, false)
        return CharacterItemViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, index: Int) {
        if(index == data.size - 5) {
            getItems(data.size)
        }


        val element = data[index]
        val characterHolder = viewHolder as CharacterItemViewHolder

        characterHolder.characterNameView.text = element.name
        characterHolder.publisherNameView.text = element.publisher?.name?:"Publisher Name"
    }
}