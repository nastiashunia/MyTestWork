package com.example.mytestwork.DB.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mytestwork.DB.Entity.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert
    void insertEmployee(Employee employee);

    @Update
    void updateEmployee(Employee employee);

    @Delete
    void deleteEmployee(Employee employee);

    @Query("SELECT * FROM employee")
    List<Employee> getAllEmployee();

   /* @Query("SELECT * FROM employee WHERE id = :Id")
    Employee getEmployeeById(long Id);*/
}
