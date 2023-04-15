package com.jekm.uccitfaculty.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jekm.uccitfaculty.R


class SocialMediaFragment : Fragment() {

    var twitterIV: ImageView? = null
    var faceIv: android.widget.ImageView? = null
    var instaIv: android.widget.ImageView? = null
    var youtubeIV: android.widget.ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_social_media, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding UI button
        twitterIV = view.findViewById(R.id.twitter)
        faceIv = view.findViewById(R.id.facebook)
        instaIv = view.findViewById(R.id.instagram)
        youtubeIV = view.findViewById(R.id.youtube)


        //Button click function to load facebook page url
        faceIv!!.setOnClickListener(View.OnClickListener {
            val url = "https://m.facebook.com/381496945527257/ "
            if (url.startsWith("https://") || url.startsWith("http://")) {
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Invalid Url", Toast.LENGTH_SHORT).show()
            }
        })




        //Button click function to load Twitter page url
        twitterIV!!.setOnClickListener(View.OnClickListener {
            val url = "http://www.twitter.com/uccjamaica"
            if (url.startsWith("https://") || url.startsWith("http://")) {
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Invalid Url", Toast.LENGTH_SHORT).show()
            }
        })



        //Button click function to load Instagram page url
        instaIv!!.setOnClickListener(View.OnClickListener {
            val url = "http://www.instagram.com/uccjamaica"
            if (url.startsWith("https://") || url.startsWith("http://")) {
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Invalid Url", Toast.LENGTH_SHORT).show()
            }
        })



        //Button click function to load Youtube page url
        youtubeIV!!.setOnClickListener(View.OnClickListener {
            val url = "https://www.youtube.com/channel/UCZRvkbzlwgpZVHMacb6MtLQ"
            if (url.startsWith("https://") || url.startsWith("http://")) {
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Invalid Url", Toast.LENGTH_SHORT).show()
            }
        })
    }
}