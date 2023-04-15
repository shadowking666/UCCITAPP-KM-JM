package com.jekm.uccitfaculty.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.jekm.uccitfaculty.model.Course
import com.jekm.uccitfaculty.model.Faculty

class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(Faculty.CREATE_TABLE)
        db.execSQL(Course.CREATE_TABLE)
        Log.d("createtable", Faculty.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + Faculty.TABLE_NAME)
        db.execSQL("DROP TABLE IF EXISTS " + Course.TABLE_NAME)

        // Create tables again
        onCreate(db)
    }

    //************************USER***********************
    //insert new faculty in database
    fun insertFaculty(user: Faculty): Long {
        // get writable database as we want to write data
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(Faculty.COLUMN_Profile, user.profile)
        values.put(Faculty.COLUMN_Name, user.name)
        values.put(Faculty.COLUMN_position, user.position)
        values.put(Faculty.COLUMN_Email, user.email)
        values.put(Faculty.COLUMN_Phone, user.phone)

        // insert row
        val id = db.insert(Faculty.TABLE_NAME, null, values)

        // close db connection
        db.close()

        // return newly inserted row id
        return id
    }

    //getting all the list of faculty stored in the faculty table
    val allFaculty: ArrayList<Faculty>
        get() {
            val db = this.readableDatabase
            val notesArrayList: ArrayList<Faculty> = ArrayList<Faculty>()
            val res = db.rawQuery("select * from " + Faculty.TABLE_NAME, null)
            res.moveToFirst()
            while (!res.isAfterLast) {
                val company = Faculty()
                company.id=(res.getInt(res.getColumnIndex(Faculty.COLUMN_ID)))
                company.profile=(res.getString(res.getColumnIndex(Faculty.COLUMN_Profile)))
                company.name=(res.getString(res.getColumnIndex(Faculty.COLUMN_Name)))
                company.position=(res.getString(res.getColumnIndex(Faculty.COLUMN_position)))
                company.email=(res.getString(res.getColumnIndex(Faculty.COLUMN_Email)))
                company.phone=(res.getString(res.getColumnIndex(Faculty.COLUMN_Phone)))
                notesArrayList.add(company)
                res.moveToNext()
            }
            return notesArrayList
        }

    //this is function is used to store courses
    fun insertCourse(course: Course): Long {
        // get writable database allowing us to write data
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(Course.COLUMN_Code, course.code)
        values.put(Course.COLUMN_Name, course.name)
        values.put(Course.COLUMN_Year_Semester, course.yearSemester)
        values.put(Course.COLUMN_Credit, course.creditHrs)
        values.put(Course.COLUMN_Total_Credits, course.totalCreditHr)
        values.put(Course.COLUMN_preRec, course.preRec)
        values.put(Course.COLUMN_Description, course.description)

        // insert row
        val id = db.insert(Course.TABLE_NAME, null, values)

        // close db connection
        db.close()

        // return newly inserted row id
        return id
    }

    //getting all the courses details
    val allCourse: ArrayList<Course>
        get() {
            val db = this.readableDatabase
            val notesArrayList: ArrayList<Course> = ArrayList<Course>()
            val res = db.rawQuery("select * from " + Course.TABLE_NAME, null)
            res.moveToFirst()
            while (!res.isAfterLast) {
                val company = Course()
                company.id=(res.getInt(res.getColumnIndex(Course.COLUMN_ID)))
                company.code=(res.getString(res.getColumnIndex(Course.COLUMN_Code)))
                company.name=(res.getString(res.getColumnIndex(Course.COLUMN_Name)))
                company.yearSemester=(res.getString(res.getColumnIndex(Course.COLUMN_Year_Semester)))
                company.creditHrs=(res.getString(res.getColumnIndex(Course.COLUMN_Credit)))
                company.totalCreditHr=(res.getString(res.getColumnIndex(Course.COLUMN_Total_Credits)))
                company.preRec=(res.getString(res.getColumnIndex(Course.COLUMN_preRec)))
                company.description=(res.getString(res.getColumnIndex(Course.COLUMN_Description)))
                notesArrayList.add(company)
                res.moveToNext()
            }
            return notesArrayList
        }

    companion object {
        // Database Name
        const val DATABASE_NAME = "school_db"

        // Database Version
        private const val DATABASE_VERSION = 1
    }
}