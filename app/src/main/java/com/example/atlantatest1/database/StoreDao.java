package com.example.atlantatest1.database;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface StoreDao {

    /*get all data from database*/
    @Query("SELECT * FROM store" )
    Store[] totalStoreUserData();

    /*insert data into database*/
    @Query("INSERT INTO store ( name, email, phone) VALUES (:name, :email, :phone )" )
    long insertIntoTable( String name, String email, String phone);


    
}
