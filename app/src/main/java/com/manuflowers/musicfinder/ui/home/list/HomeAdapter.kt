package com.manuflowers.musicfinder.ui.home.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuflowers.domain.search.model.TrackEntity

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {

    private val trackList = mutableListOf<TrackEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(trackList[position])
    }

    override fun getItemCount(): Int = trackList.size

    fun setData(list: List<TrackEntity>) {
        this.trackList.clear()
        trackList.addAll(list)
        notifyDataSetChanged()
    }
}