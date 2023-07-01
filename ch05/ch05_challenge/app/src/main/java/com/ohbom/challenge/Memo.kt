package com.ohbom.challenge

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @ColumnInfo(name="content") val content:String,
    @ColumnInfo(name="like") val like:Boolean=false,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="memoId") val memoId:Int=0,
)
