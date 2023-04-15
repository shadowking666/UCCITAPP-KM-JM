package com.jekm.uccitfaculty.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jekm.uccitfaculty.R
import com.jekm.uccitfaculty.adapter.MyFacultyAdapter
import com.jekm.uccitfaculty.database.DatabaseHelper
import com.jekm.uccitfaculty.model.Faculty

class FacultyFragment : Fragment() {


    var mDB: DatabaseHelper? = null

    private var mAdapter: MyFacultyAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var notesArrayList: ArrayList<Faculty>? = null
    private var noDataLayout: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_faculty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        mDB = DatabaseHelper(activity)
        recyclerView = view.findViewById(R.id.faculty_recyclerview)
        noDataLayout = view.findViewById(R.id.no_faculty_layout)

        notesArrayList = java.util.ArrayList()

    }


    override fun onResume() {
        super.onResume()
        notesArrayList!!.clear()

        //get data form faculty table
        notesArrayList = mDB!!.allFaculty

        setData()

    }

    //setting data in recycler view
    private fun setData() {
        Log.d("tEstarraylist", notesArrayList.toString())
        if (notesArrayList!!.size > 0) {
            recyclerView!!.visibility = View.VISIBLE
            noDataLayout!!.visibility = View.GONE
            mAdapter = MyFacultyAdapter(notesArrayList!!, requireActivity())
            val mLayoutManager1: RecyclerView.LayoutManager = LinearLayoutManager(activity)
            recyclerView!!.layoutManager = mLayoutManager1
            recyclerView!!.adapter = mAdapter
            mAdapter!!.notifyDataSetChanged()
        } else {
            noDataLayout!!.visibility = View.VISIBLE
            recyclerView!!.visibility = View.GONE
        }
    }
}