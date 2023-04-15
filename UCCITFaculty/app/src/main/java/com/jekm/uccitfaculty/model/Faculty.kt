package com.jekm.uccitfaculty.model

import java.io.Serializable

//Model class for the
class Faculty : Serializable {
    var id = 0
    var profile: String? = null
    var name: String? = null
    var position: String? = null
    var email: String? = null
    var phone: String? = null

    constructor(
        profile: String?,
        name: String?,
        position: String?,
        email: String?,
        phone: String?
    ) {
        this.profile = profile
        this.name = name
        this.position = position
        this.email = email
        this.phone = phone
    }

    constructor() {}

    override fun toString(): String {
        return "Faculty{" +
                "id=" + id +
                ", profile='" + profile + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}'
    }

    companion object {
        const val TABLE_NAME = "faculty"
        const val COLUMN_ID = "id"
        const val COLUMN_Profile = "profile"
        const val COLUMN_Name = "name"
        const val COLUMN_position = "position"
        const val COLUMN_Email = "email"
        const val COLUMN_Phone = "phone"

        //Query to create Faculty Table
        const val CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_Profile + " TEXT,"
                + COLUMN_Name + " TEXT,"
                + COLUMN_position + " TEXT,"
                + COLUMN_Email + " TEXT,"
                + COLUMN_Phone + " TEXT"
                + ")")
    }
}