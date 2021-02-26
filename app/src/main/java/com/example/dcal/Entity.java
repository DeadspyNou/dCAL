package com.example.dcal;

import androidx.room.*;

@Entity(tableName="RecentData",primaryKeys = {"uid"})
class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "History")
    public String Recent;
}