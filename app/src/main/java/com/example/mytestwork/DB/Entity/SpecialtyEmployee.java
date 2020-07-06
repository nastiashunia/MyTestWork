package com.example.mytestwork.DB.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SpecialtyEmployee {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public long id;

    public long employee_id;

    public long specialy_id;
}
