package com.jekm.uccitfaculty.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.jekm.uccitfaculty.R
import com.jekm.uccitfaculty.database.DatabaseHelper
import com.jekm.uccitfaculty.databinding.ActivityMainBinding
import com.jekm.uccitfaculty.model.Course
import com.jekm.uccitfaculty.model.Faculty
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    var mDb: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //initializing Paper db
        Paper.init(this@MainActivity)

        //checking if the app opens first time then load the data in database
        val isFirstTime =
            Paper.book().read("is_first_time", true)!!
        if (isFirstTime) {
            PopulateData()
        }

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:") // only email apps should handle this

            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ithod@ucc.edu.jm"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject Here")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_about_us, R.id.nav_faculty, R.id.nav_courses, R.id.nav_admissions, R.id.nav_socialmedia
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    //this function is used to store data in SQLite data base when the app is opened first time.
    private fun PopulateData() {
        mDb = DatabaseHelper(this@MainActivity)
        Paper.book().write("is_first_time", false)

        //storing faculty objects
        val faculty1 = Faculty(
            "https://i.graphicmama.com/uploads/2016/2/Kim-the-Office-lady-56cc493697233.png",
            "Ms. Natalie Rose",
            "I.T H.O.D",
            "ithod@ucc.edu.jm",
            "876-838-2408"
        )
        val faculty2 = Faculty(
            "https://i.graphicmama.com/uploads/2020/8/5f31198708674-Young-Female-African-American-Teacher-Cartoon-Character.png",
            "Ms. Bryanna Chang",
            "I.T. Programme officer",
            "bchang@faculty.ucc.edu.jm",
            "876-906-3000"
        )
        val faculty3 = Faculty(
            "https://i.graphicmama.com/uploads/2020/5/5eb55e9f458ae-smart-african-american-teacher-cartoon-vector-character1.png",
            "Mr. Ricardo Reid",
            "I.T. Programme officer",
            "itprogrammeofficer3@ucc.edu.jm",
            "876-906-3000"
        )
        val faculty4 = Faculty(
            "https://thumbs.dreamstime.com/b/woman-teacher-african-american-female-books-90004773.jpg",
            "Ms. Winsome Bennett",
            "I.T. Programme Coordinator",
            "itprogrammeofficer@ucc.edu.jm",
            "876-548-0629"
        )
        val faculty5 = Faculty(
            "https://img.favpng.com/7/5/18/cartoon-drawing-man-png-favpng-cGevJkWmfyrRcQbm8EqPwnkkX.jpg",
            "Mr. Otis Osbourne",
            "I.T. Lecturer/Assistant Programme Coordinator",
            "itfaculty@ucc.edu.jm",
            "876-218-2935"
        )
        
        mDb!!.insertFaculty(faculty1)
        mDb!!.insertFaculty(faculty2)
        mDb!!.insertFaculty(faculty3)
        mDb!!.insertFaculty(faculty4)
        mDb!!.insertFaculty(faculty5)



        //storing the course objects
        val course1 = Course(
            "MOBILE APPLICATION DEVELOPMENT",
            "ITT420",
            "3",
            "3 CREDITS",
            "26 HOURS",
            "NONE",
            getString(R.string.des_1)
        )
        val course2 = Course(
            "OBJECT ORIENTED PROGRAMMING USING C++",
            "ITT200",
            "2",
            "3 CREDITS",
            "26 HOURS",
            "PROGRAMMING TECHNIQUES",
            getString(R.string.des_2)
        )
        val course3 = Course(
            "PROGRAMMING TECHNIQUES",
            "ITT103",
            "1",
            "3 CREDITS",
            "26 HOURS",
            "COMPUTER INFORMATION SYSTEMS (ITT 101)",
            getString(R.string.des_3)
        )
        val course4 = Course(
            "COMPUTER INFORMATION SYSTEMS",
            "ITT101",
            "1",
            "3 CREDITS",
            "26 HOURS",
            "NONE",
            getString(R.string.des_4)
        )
        val course5 = Course(
            "COMPUTER ESSENTIALS & TROUBLESHOOTING I",
            "ITT101",
            "1",
            "3 CREDITS",
            "26 HOURS",
            "COMPUTERS AND INFORMATION SYSTEMS (ITT 101)",
            getString(R.string.des_5)
        )
        val course6 = Course(
            "INTERNET AUTHORING I",
            "ITT208",
            "2",
            "3 CREDITS",
            "26 HOURS",
            "PROGRAMMING TECHNIQUES (ITT103)",
            getString(R.string.des_6)
        )
        val course7 = Course(
            "DATA STRUCTURES AND FILE MANAGEMENT I",
            "ITT203",
            "2",
            "3 CREDITS",
            "26 HOURS",
            "OBJECT-ORIENTED PROGRAMMING USING C ++ (ITT 200)",
            getString(R.string.des_7)
        )
        val course8 = Course(
            "DATABASE MANAGEMENT SYSTEMS",
            "ITT210",
            "2",
            "3 CREDITS",
            "26 HOURS",
            ": PROGRAMMING TECHNIQUES (ITT103)",
            getString(R.string.des_8)
        )
        val course9 = Course(
            "COMPUTER DATA ANALYSIS",
            "ITT211",
            "1",
            "3 CREDITS",
            "26 HOURS",
            "NONE",
            getString(R.string.des_9)
        )
        val course10 = Course(
            "DATA COMMUNICATIONS AND NETWORKS I",
            "ITT201",
            "2",
            "3 CREDITS",
            "26 HOURS",
            "COMPUTER INFORMATION SYSTEMS (ITT 101)",
            getString(R.string.des_10)
        )
        mDb!!.insertCourse(course1)
        mDb!!.insertCourse(course2)
        mDb!!.insertCourse(course3)
        mDb!!.insertCourse(course4)
        mDb!!.insertCourse(course5)
        mDb!!.insertCourse(course6)
        mDb!!.insertCourse(course7)
        mDb!!.insertCourse(course8)
        mDb!!.insertCourse(course9)
        mDb!!.insertCourse(course10)
    }
}