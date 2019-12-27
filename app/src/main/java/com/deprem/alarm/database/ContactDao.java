package com.deprem.alarm.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.deprem.alarm.model.Contact;

import java.util.List;

@Dao
public interface ContactDao {

    @Query("SELECT * FROM Contact")
    List<Contact> getAllContacts();

    @Query("SELECT mobileNumber FROM contact")
    List<String> getAllContactsNumber();

    @Query("SELECT * FROM Contact WHERE id = :id")
    Contact getContactById(int id);

    @Insert
    void insertContact(Contact contact);

    @Delete
    void Delete(Contact contact);

}
