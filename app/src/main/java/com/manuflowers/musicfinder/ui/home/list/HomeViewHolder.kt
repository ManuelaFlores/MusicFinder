package com.manuflowers.musicfinder.ui.home.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuflowers.domain.search.model.TrackEntity
import com.manuflowers.musicfinder.R

class HomeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun newInstance(parent: ViewGroup): HomeViewHolder {
            return HomeViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.home_view_holder, parent, false)
            )
        }
    }

    fun bind(trackEntity: TrackEntity) {
        // TODO: bind data
    }
}