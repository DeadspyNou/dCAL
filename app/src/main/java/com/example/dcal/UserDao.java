package com.example.dcal;

import androidx.room.*;

import java.util.List;

@Dao
public interface UserDao {
  @Query("SELECT History FROM RecentData")
  List<User> getAll();
   @Insert
   void insertAll(User Recent);
//
//    @Delete
//    void delete(User user);
}