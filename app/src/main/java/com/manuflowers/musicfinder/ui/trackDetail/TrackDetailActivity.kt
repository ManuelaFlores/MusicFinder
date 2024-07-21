package com.manuflowers.musicfinder.ui.trackDetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import com.manuflowers.musicfinder.R
import com.manuflowers.musicfinder.databinding.ActivityTrackDetailBinding
import com.manuflowers.musicfinder.ui.home.model.TrackView


class TrackDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackDetailBinding

    private val trackView: TrackView? by lazy {
        intent.getParcelableExtra("TRACK_DETAIL") as TrackView?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getIntentValues()
    }

    private fun getIntentValues() {
        trackView?.let {
            Log.e("TRACK_PASSED", "$it")
            binding.run {
                trackNameTextView.text = it.trackName
                authorTrackTextView.text = it.artistName
                trackAlbumImageView.load(it.trackImage) {
                    placeholder(R.drawable.shape_view)
                    transformations(CircleCropTransformation())
                }
            }
        }
    }
}