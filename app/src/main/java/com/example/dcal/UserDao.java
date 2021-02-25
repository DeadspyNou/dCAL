package com.example.dcal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
  @Query("SELECT History FROM RecentData")
  List<User> getAll();

   @Insert
   void insertAll(String Recent);
//
//    @Delete
//    void delete(User user);
}