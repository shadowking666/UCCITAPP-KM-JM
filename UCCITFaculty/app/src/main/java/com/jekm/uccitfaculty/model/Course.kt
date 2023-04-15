package com.jekm.uccitfaculty.model

import java.io.Serializable

class Course : Serializable {
    //Courses Attribute
    var id = 0
    var name: String? = null
    var code: String? = null

    //Getter //Setter function
    var yearSemester: String? = null
    var creditHrs: String? = null
    var totalCreditHr: String? = null
    var preRec: String? = null
    var description: String? = null

    constructor(
        name: String?,
        code: String?,
        yearSemester: String?,
        creditHrs: String?,
        totalCreditHr: String?,
        preRec: String?,
        description: String?
    ) {
        this.name = name
        this.code = code
        this.yearSemester = yearSemester
        this.creditHrs = creditHrs
        this.totalCreditHr = totalCreditHr
        this.preRec = preRec
        this.description = description
    }

    constructor() {}

    companion object {
        const val TABLE_NAME = "course"
        const val COLUMN_ID = "id"
        const val COLUMN_Code = "code"
        const val COLUMN_Name = "name"
        const val COLUMN_Year_Semester = "year_semester"
        const val COLUMN_Credit = "creditHrs"
        const val COLUMN_Total_Credits = "totalCredit"
        const val COLUMN_preRec = "preRec"
        const val COLUMN_Description = "description"

        //Query to create Courses Table
        const val CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_Code + " TEXT,"
                + COLUMN_Name + " TEXT,"
                + COLUMN_Year_Semester + " TEXT,"
                + COLUMN_Credit + " TEXT,"
                + COLUMN_Total_Credits + " TEXT,"
                + COLUMN_preRec + " TEXT,"
                + COLUMN_Description + " TEXT"
                + ")")
    }
}