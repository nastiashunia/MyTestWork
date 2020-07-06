package com.example.mytestwork.DB.Entity;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String f_name;

    public String l_name;

    public long date_of_birth;

    public String avatr_url;

}
