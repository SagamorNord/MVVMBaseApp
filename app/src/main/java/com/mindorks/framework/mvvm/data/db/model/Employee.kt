package com.mindorks.framework.mvvm.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * @author a.v.davtyan
 */
@Entity(tableName = "employee")
class Employee(

    @ColumnInfo(name = "f_name")
    val f_name: String,

    @ColumnInfo(name = "l_name")
    val l_name: String,

    @ColumnInfo(name = "birthday")
    val birthday: String,

    @ColumnInfo(name = "full_name")
    val avatr_url: String,

    @ColumnInfo(name = "specialty_id")
    val departmentId: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Long = 0
}
