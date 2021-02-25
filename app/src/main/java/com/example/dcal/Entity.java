package com.example.dcal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName="RecentData",primaryKeys = {"uid"})
class User {

    @PrimaryKey(autoGenerate = true)
    public  int uid;
    @ColumnInfo(name = "History")
    public  String Recent;

}