package com.manuflowers.musicfinder.ui.home.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuflowers.musicfinder.ui.home.model.TrackView

class HomeAdapter(
    private val onClickListener: (TrackView) -> Unit
) : RecyclerView.Adapter<HomeViewHolder>() {

    private val trackList = mutableListOf<TrackView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(trackList[position], onClickListener)
    }

    override fun getItemCount(): Int = trackList.size

    fun setData(list: List<TrackView>) {
        this.trackList.clear()
        trackList.addAll(list)
        notifyDataSetChanged()
    }
}