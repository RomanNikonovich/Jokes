package com.example.presentation.screens.rvAfapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.entity.Joke
import com.example.presentation.R
import kotlinx.android.synthetic.main.item_joke.view.*


class AdaptRV : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val list: MutableList<Joke> = arrayListOf()

    fun setJokes(list: MutableList<Joke>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_joke, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.rv_joke_text.text = list[position].joke
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textJoke: TextView

        init {
            textJoke = view.findViewById(R.id.rv_joke_text)
        }
    }
}