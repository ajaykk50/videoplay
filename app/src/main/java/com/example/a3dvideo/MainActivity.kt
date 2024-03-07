package com.example.a3dvideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.net.Uri
import android.widget.MediaController
import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.view.Surface
import android.view.TextureView
import com.devbrackets.android.exomedia.listener.OnPreparedListener
import com.devbrackets.android.exomedia.ui.widget.VideoView

import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class MainActivity : AppCompatActivity() {

    private lateinit var playerView: VideoView
    private lateinit var textureView: TextureView
    private lateinit var player: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // textureView = findViewById(R.id.textureView);
        playerView =findViewById(R.id.playerView);
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video)



        playerView.setMedia(videoUri)
        playerView.setOnPreparedListener(object : OnPreparedListener {
            override fun onPrepared() {
                // Set the alpha to make the video background transparent
                playerView.alpha = 0.50f
                playerView.start()
            }
        })



//        player = SimpleExoPlayer.Builder(this, DefaultRenderersFactory(this))
//            .setTrackSelector(DefaultTrackSelector(this))
//            .build()
//
//        val dataSourceFactory = DefaultDataSourceFactory(this, Util.getUserAgent(this, "your_app_name"))
//        val extractorsFactory = DefaultExtractorsFactory()
//
//        val mediaItem = MediaItem.fromUri(videoUri)
//
////        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory, extractorsFactory)
////            .createMediaSource(videoUri)
//
//        player.setMediaItem(mediaItem)
//
//
//       // player.prepare(mediaSource)
//        player.setRepeatMode(Player.REPEAT_MODE_ONE)  // Set to repeat the video
//        player.playWhenReady = true
//
//        // Set the player to the TextureView
//        playerView.player = player
    }


    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}

