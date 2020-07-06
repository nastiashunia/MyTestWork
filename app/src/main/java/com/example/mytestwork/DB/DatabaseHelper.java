package com.example.mytestwork.DB;

import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.mytestwork.DB.Entity.Employee;
import com.example.mytestwork.DB.Entity.Specialty;
import com.example.mytestwork.DB.Entity.SpecialtyEmployee;

@Database(entities = { Employee.class, Specialty.class, SpecialtyEmployee.class}, version = 1, exportSchema = false)
public abstract class DatabaseHelper extends RoomDatabase {

    public abstract Employee getEmployeeDao();

    public abstract Specialty getSpecialtyDao();

    public abstract SpecialtyEmployee getSpecialtyEmployeeDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }




}