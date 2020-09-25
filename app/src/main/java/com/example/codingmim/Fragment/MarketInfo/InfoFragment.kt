package com.example.codingmim.Fragment.MarketInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.codingmim.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.fragment_info.*

/**
 * A simple [Fragment] subclass.
 */
class InfoFragment : Fragment() {

    class MainActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

        override fun onInitializationSuccess(
            provider: YouTubePlayer.Provider?,
            player: YouTubePlayer?,
            wasRestored: Boolean
        ) {
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
            if (!wasRestored) {
                player?.cueVideo("-m9R9oPLnWc");
            }
        }

        override fun onInitializationFailure(
            p0: YouTubePlayer.Provider?,
            p1: YouTubeInitializationResult?
        ) {
            Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show()
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_content)
//            player.initialize("AIzaSyCfwQoxNxTqlNxGlwV4YfCzwLo7xRTG-qk", this)

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

}
