package com.manuflowers.musicfinder.ui.trackDetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.util.Util
import com.manuflowers.musicfinder.R
import com.manuflowers.musicfinder.databinding.ActivityTrackDetailBinding
import com.manuflowers.musicfinder.ui.home.model.TrackView


class TrackDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackDetailBinding

    private val trackView: TrackView? by lazy {
        intent.getParcelableExtra("TRACK_DETAIL") as TrackView?
    }

    private val player = SimpleExoPlayer.Builder(this).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getIntentValues()
        initializePlayer()
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

    private fun initializePlayer() {
        /*playerView.player = player
        trackView?.let {
           val mediaItem =  MediaItem.fromUri(it.previewUrl)
            player.setMediaItem(mediaItem)
        }*/
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer();
        }
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
        if ((Util.SDK_INT < 24 || player == null)) {
            initializePlayer();
        }
    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        /*playerView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)*/
    }
}