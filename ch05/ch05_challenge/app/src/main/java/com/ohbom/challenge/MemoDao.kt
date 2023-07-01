package com.ohbom.challenge

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao

interface MemoDao {
    @Insert
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)

    @Query("UPDATE Memo SET like= :like WHERE memoId= :memoId")
    fun updateLikeByMemoId(memoId:Int,like:Boolean)

    @Query("SELECT * FROM Memo")
    fun selectAll(): LiveData<List<Memo>>

}