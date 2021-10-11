package com.example.testing.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import com.example.testing.domain.UserData

object EmployeeDatabaseHelper {


    lateinit var employeeDbHelper: EmployeeDbHelper

    fun createSQLiteHelper(context: Context) {             //CREATE A TABLE AND INSERT A DATA IN TABLE AND GET A DATA IN TABLE

        employeeDbHelper = EmployeeDbHelper(context)

    }

    fun insertData(userData: UserData) {
        // Gets the data repository in write mode
        val db = employeeDbHelper.writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(EmployeeContract.Employee.COLUMN_NAME_USERNAME, userData.userName)
            put(EmployeeContract.Employee.COLUMN_NAME_PASSWORD, userData.password)
            put(EmployeeContract.Employee.COLUMN_NAME_EMAIL, userData.email)
            put(EmployeeContract.Employee.COLUMN_NAME_NUMBER, userData.number)
        }

        // Insert the new row, returning the primary key value of the new row
        val newRowId = db?.insert(EmployeeContract.Employee.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun getData(signinUserName : String, signinPassword : String) : UserData? {

        var userData : UserData?= null

        val db1 = employeeDbHelper.readableDatabase

        //Select _Id,username,password from employee where usrname = 'madhan' and password = '123'

        val projection = arrayOf(
            BaseColumns._ID,
            EmployeeContract.Employee.COLUMN_NAME_USERNAME,
            EmployeeContract.Employee.COLUMN_NAME_PASSWORD
        )

        val selection = "${EmployeeContract.Employee.COLUMN_NAME_USERNAME} = ? AND ${EmployeeContract.Employee.COLUMN_NAME_PASSWORD} = ?"
        val selectionArgs = arrayOf(signinUserName,signinPassword)

        val sortOrder = "${EmployeeContract.Employee.COLUMN_NAME_USERNAME} DESC"

        val cursor = db1.query(
            EmployeeContract.Employee.TABLE_NAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )

        if(cursor != null && cursor.count != 0) {

            while (cursor.moveToNext()) {

                userData = UserData(
                    cursor.getString(cursor.getColumnIndex(EmployeeContract.Employee.COLUMN_NAME_USERNAME)),
                    cursor.getString(cursor.getColumnIndex(EmployeeContract.Employee.COLUMN_NAME_PASSWORD)),
                    cursor.getString(cursor.getColumnIndex(EmployeeContract.Employee.COLUMN_NAME_EMAIL)),
                    cursor.getString(cursor.getColumnIndex(EmployeeContract.Employee.COLUMN_NAME_NUMBER))
                )

            }

        }

        return userData

    }
    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${EmployeeContract.Employee.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${EmployeeContract.Employee.COLUMN_NAME_USERNAME} TEXT," +
                "${EmployeeContract.Employee.COLUMN_NAME_PASSWORD} TEXT," +
                "${EmployeeContract.Employee.COLUMN_NAME_EMAIL} TEXT," +
                "${EmployeeContract.Employee.COLUMN_NAME_NUMBER} TEXT)"

}

