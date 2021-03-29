package com.cbellmont.mapejemplo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cbellmont.mapejemplo.databinding.ItemAdapterBinding

class PlacesAdapter(private val callback: OnItemClicked) : RecyclerView.Adapter<PlacesAdapter.AdapterViewHolder>() {

    interface OnItemClicked {
        fun onItemClicked(place: String)
    }

    class AdapterViewHolder(val itemBinding: ItemAdapterBinding) : RecyclerView.ViewHolder(itemBinding.root)

    private var places =  listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val itemBinding = ItemAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.itemBinding.tvText.text = places[position]
        holder.itemBinding.root.setOnClickListener {
            callback.onItemClicked(places[position])
        }
    }

    override fun getItemCount(): Int {
        return places.count()
    }

    fun updateData(places : List<String>){
        this.places = places
        notifyDataSetChanged()
    }

}