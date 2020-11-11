package com.gibittec.room2.repository

import androidx.lifecycle.LiveData
import com.gibittec.room2.model.User
import com.gibittec.room2.data.UserDao

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllDate();

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }


    suspend fun deleteUser(user: User){
     userDao.deleteUser(user)
    }

    suspend fun deleteAllUser(){
        userDao.deleteAllUser()
    }
}