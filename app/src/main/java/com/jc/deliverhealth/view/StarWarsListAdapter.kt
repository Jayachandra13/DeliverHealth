package com.jc.deliverhealth.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devtides.coroutinesretrofit.view.loadImage
import com.jc.deliverhealth.R
import com.jc.deliverhealth.model.Result
import com.jc.deliverhealth.model.StarWarsOnClickListener
import kotlinx.android.synthetic.main.item_star_wars.view.*

class StarWarsListAdapter(private val listener: StarWarsOnClickListener) : RecyclerView.Adapter<StarWarsListAdapter.StarWarsItemViewHolder>() {

    private val starWarsResultItems = arrayListOf<Result>()

    fun onAddStarWarsItem(item: Result) {
        starWarsResultItems.add(0, item)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = StarWarsItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_star_wars, parent, false)
    )

    override fun getItemCount() = starWarsResultItems.size

    override fun onBindViewHolder(holder: StarWarsItemViewHolder, position: Int) {
        holder.bind(starWarsResultItems[position])
        holder.itemView.setOnClickListener { listener.onStarWarsClick(starWarsResultItems[position]) }
    }

    class StarWarsItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageView = view.imageViewProfilePhoto
        private val name = view.tvName

        fun bind(result: Result) {
            imageView.loadImage(result.image)
            name.text = result.name
        }
    }
}