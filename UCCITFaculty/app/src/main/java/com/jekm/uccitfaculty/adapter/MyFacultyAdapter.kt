package com.jekm.uccitfaculty.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jekm.uccitfaculty.R
import com.jekm.uccitfaculty.model.Faculty
import de.hdodenhof.circleimageview.CircleImageView

//This is the adapter class for the Faculty recycler view
class MyFacultyAdapter(usersList: List<Faculty>, context: Context) :
    RecyclerView.Adapter<MyFacultyAdapter.MyViewHolder>() {
    var notesList: List<Faculty>
    var context: Context

    //constructor
    init {
        notesList = usersList
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_faculty, parent, false)
        return MyViewHolder(itemView)
    }

    //Binding the data of every list item to the view of single item in recycler view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val faculty: Faculty = notesList[position]
        holder.email.setText(faculty.email)
        holder.phone.setText(faculty.phone)
        holder.name.setText(faculty.name)
        holder.position.setText(faculty.position)
        Glide.with(context).load(faculty.profile)
            .apply(RequestOptions().placeholder(R.drawable.profile).error(R.drawable.profile))
            .into(holder.profile_Img)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    //Binding the UI element with single item of adapter
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var email: TextView
        var phone: TextView
        var name: TextView
        var position: TextView
        var profile_Img: CircleImageView

        init {
            email = itemView.findViewById(R.id.email_tv)
            phone = itemView.findViewById(R.id.phone_tv)
            name = itemView.findViewById(R.id.name_tv)
            position = itemView.findViewById(R.id.position_tv)
            profile_Img = itemView.findViewById(R.id.profile_image)
        }
    }
}