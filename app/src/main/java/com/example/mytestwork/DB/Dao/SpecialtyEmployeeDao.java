package com.example.mytestwork.DB.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mytestwork.DB.Entity.SpecialtyEmployee;

import java.util.List;

@Dao
public interface SpecialtyEmployeeDao {
    @Insert
    void insertSpecialtyEmployee(SpecialtyEmployee specialtyemployee);

    @Update
    void updateSpecialtyEmployee(SpecialtyEmployee specialtyemployee);

    @Delete
    void deleteSpecialtyEmployee(SpecialtyEmployee specialtyemployee);

    @Query("SELECT * FROM specialtyemployee")
    List<SpecialtyEmployee> getAllSpecialtyEmployee();
}
