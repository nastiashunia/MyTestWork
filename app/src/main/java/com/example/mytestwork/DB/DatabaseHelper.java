package com.example.mytestwork.DB;

import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.mytestwork.DB.Dao.EmployeeDao;
import com.example.mytestwork.DB.Dao.SpecialtyDao;
import com.example.mytestwork.DB.Dao.SpecialtyEmployeeDao;
import com.example.mytestwork.DB.Entity.Employee;
import com.example.mytestwork.DB.Entity.Specialty;
import com.example.mytestwork.DB.Entity.SpecialtyEmployee;

@Database(entities = { Employee.class, Specialty.class, SpecialtyEmployee.class}, version = 1, exportSchema = false)
public abstract class DatabaseHelper extends RoomDatabase {

    public abstract EmployeeDao getEmployeeDao();

    public abstract SpecialtyDao getSpecialtyDao();

    public abstract SpecialtyEmployeeDao getSpecialtyEmployeeDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }




}