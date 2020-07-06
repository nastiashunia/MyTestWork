package com.example.mytestwork.DB.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.mytestwork.DB.Entity.Specialty;

import java.util.List;

@Dao
public interface SpecialtyDao {
    @Insert
    void insertSpecialty(Specialty specialty);

    @Update
    void updateSpecialty(Specialty specialty);

    @Delete
    void deleteSpecialty(Specialty specialty);

    @Query("SELECT * FROM specialty")
    List<Specialty> getAllSpecialty();
}
