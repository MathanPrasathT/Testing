package com.example.testing.data

import android.provider.BaseColumns

object EmployeeContract {

    object Employee : BaseColumns{

        const val TABLE_NAME = "employee"
        const val COLUMN_NAME_USERNAME = "username"
        const val COLUMN_NAME_PASSWORD = "password"
        const val COLUMN_NAME_EMAIL = "email"
        const val COLUMN_NAME_NUMBER ="number"
    }


}