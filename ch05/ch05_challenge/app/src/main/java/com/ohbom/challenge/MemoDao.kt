package com.ohbom.challenge

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao

interface MemoDao {
    @Insert
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)

    @Query("SELECT * FROM Memo")
    fun selectAll(): LiveData<List<Memo>>

}