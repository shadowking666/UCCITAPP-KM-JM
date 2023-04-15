package com.jekm.uccitfaculty.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jekm.uccitfaculty.R
import com.jekm.uccitfaculty.model.Course

//This is the adapter class for the courses recycler view to show data in list
class MyCourseAdapter(courseList: List<Course>, context: Context) :
    RecyclerView.Adapter<MyCourseAdapter.MyViewHolder>() {
    var courseList: List<Course>
    var context: Context

    init {
        this.courseList = courseList
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return MyViewHolder(itemView)
    }

    //Binding the data form list to single items
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val faculty: Course = courseList[position]
        holder.name.text = "COURSE TITLE: " + faculty.name
        holder.code.text = "COURSE CODE: " + faculty.code
        holder.yearSemester.text = "YEAR: " + faculty.yearSemester
        holder.credit.text = "CREDIT VALUE: " + faculty.creditHrs
        holder.totalCredit.text = "TOTAL HOURS: " + faculty.totalCreditHr
        holder.preRec.text = "PRE-REQUISITES: " + faculty.preRec
        holder.description.text = "COURSE DESCRIPTION: " + faculty.description
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var code: TextView
        var name: TextView
        var yearSemester: TextView
        var credit: TextView
        var totalCredit: TextView
        var preRec: TextView
        var description: TextView

        init {
            code = itemView.findViewById(R.id.code_tv)
            name = itemView.findViewById(R.id.name_tv)
            yearSemester = itemView.findViewById(R.id.year_semester_tv)
            credit = itemView.findViewById(R.id.credit_tv)
            totalCredit = itemView.findViewById(R.id.total_hours_tv)
            preRec = itemView.findViewById(R.id.pre_rec_tv)
            description = itemView.findViewById(R.id.description_tv)
        }
    }
}