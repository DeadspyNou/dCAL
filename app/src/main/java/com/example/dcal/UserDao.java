package com.example.dcal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
  @Query("SELECT * FROM RecentData")
  List<User> getAll();

   @Insert(onConflict=OnConflictStrategy.REPLACE)
   void insertAll(User users);
//
//    @Delete
//    void delete(User user);
}