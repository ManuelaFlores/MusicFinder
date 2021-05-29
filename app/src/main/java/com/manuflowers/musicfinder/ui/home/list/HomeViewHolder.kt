package com.manuflowers.musicfinder.ui.home.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manuflowers.musicfinder.R
import com.manuflowers.musicfinder.ui.home.model.TrackView
import kotlinx.android.synthetic.main.home_view_holder.view.*

class HomeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun newInstance(parent: ViewGroup): HomeViewHolder {
            return HomeViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.home_view_holder, parent, false)
            )
        }
    }

    fun bind(trackView: TrackView, onClickListener: (TrackView) -> Unit) {

        itemView.setOnClickListener {
            onClickListener.invoke(trackView)
        }

        itemView.trackNameTextView.text = trackView.trackName
        itemView.authorTrackTextView.text = trackView.artistName
        itemView.trackDurationTextView.text = trackView.trackDuration
    }
}