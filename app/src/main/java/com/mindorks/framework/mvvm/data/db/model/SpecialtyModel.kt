package com.mindorks.framework.mvvm.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * @author a.v.davtyan
 */
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Employee::class,
            parentColumns = ["id"],
            childColumns = ["name"]
        )
    ],
    tableName = "specialties"
)
data class SpecialtyModel(
    @PrimaryKey
    val specialty_id: Int,

    @ColumnInfo(name = "name")
    val name: String
)
