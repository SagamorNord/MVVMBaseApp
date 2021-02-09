package com.mindorks.framework.mvvm.data.db

import androidx.room.*
import com.mindorks.framework.mvvm.data.db.model.Employee
import com.mindorks.framework.mvvm.data.model.EmployeeSpeciality


/**
 * @author a.v.davtyan
 */
@Dao
interface EmployeeDAO {

    @Query("SELECT * FROM employee")
    fun getAll(): List<Employee?>?

    @Query("SELECT * FROM employee WHERE id = :id")
    fun getById(id: Long): Employee?

    @Query(
        "SELECT employee.f_name, employee.l_name, specialties.name AS specialty_name " +
                "FROM employee, specialties " +
                "WHERE specialties.id == employee.specialty_id"
    )
    fun getEmployeeBySpeciality(): List<EmployeeSpeciality?>?

    @Query("SELECT * FROM employee WHERE id = :id")
    fun getBySpecialityId(id: Long): List<Employee?>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(employee: Employee)

    @Query("DELETE FROM employee")
     fun deleteAll()

    @Query("DELETE FROM employee WHERE id = :id")
    fun deleteById(id: Long)
}
