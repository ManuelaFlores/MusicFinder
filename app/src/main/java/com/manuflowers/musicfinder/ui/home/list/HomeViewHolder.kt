package com.manuflowers.musicfinder.ui.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.manuflowers.musicfinder.R
import com.manuflowers.musicfinder.databinding.HomeViewHolderBinding
import com.manuflowers.musicfinder.ui.home.model.TrackView

class HomeViewHolder(private val view: HomeViewHolderBinding) : RecyclerView.ViewHolder(view.root) {

    companion object {

        fun newInstance(parent: ViewGroup): HomeViewHolder {
            val itemBinding = HomeViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return HomeViewHolder(itemBinding)
        }
    }

    fun bind(trackView: TrackView, onClickListener: (TrackView) -> Unit) {

        itemView.setOnClickListener {
            onClickListener.invoke(trackView)
        }
        view.trackNameTextView.text = trackView.trackName
        view.authorTrackTextView.text = trackView.artistName
        view.trackDurationTextView.text = trackView.trackDuration
        view.trackImageView.load(trackView.trackImage) {
            placeholder(R.drawable.shape_view)
            transformations(RoundedCornersTransformation(10F))
        }
    }
}