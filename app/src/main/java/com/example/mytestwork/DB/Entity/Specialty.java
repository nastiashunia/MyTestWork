package com.example.mytestwork.DB.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Specialty {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String name;
}
