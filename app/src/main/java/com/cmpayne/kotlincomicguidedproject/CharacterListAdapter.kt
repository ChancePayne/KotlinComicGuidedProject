package com.cmpayne.kotlincomicguidedproject

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CharacterListAdapter(val activity: Activity, val data: List<Character>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class CharacterItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val characterNameView: TextView = view.findViewById(R.id.item_character_name)
        val publisherNameView: TextView = view.findViewById(R.id.item_publisher_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.character_item_layout, parent, false)
        return CharacterItemViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, index: Int) {
        val element = data[index]
        val characterHolder = viewHolder as CharacterItemViewHolder

        characterHolder.characterNameView.text = element.name
        characterHolder.publisherNameView.text = element.publisher?.name?:"Publisher Name"
    }
}