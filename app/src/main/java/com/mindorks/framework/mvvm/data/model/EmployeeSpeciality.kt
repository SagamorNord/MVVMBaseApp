package com.mindorks.framework.mvvm.data.model

import androidx.room.ColumnInfo

data class EmployeeSpeciality(

    val f_name: String,

    val l_name: String,

    @ColumnInfo(name = "specialty_name")
    val specialtyName: String
)
