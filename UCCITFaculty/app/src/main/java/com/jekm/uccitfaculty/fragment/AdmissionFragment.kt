package com.jekm.uccitfaculty.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jekm.uccitfaculty.R

class AdmissionFragment : Fragment() {

    private var submitBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admissions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submitBtn = view.findViewById(R.id.start_application)

        //button click to navigate the user to the link for application page on the university website
        submitBtn!!.setOnClickListener(View.OnClickListener {
            val url = "https://ucc.edu.jm/apply/undergraduate/preform"
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