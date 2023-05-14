package com.ohbom.challenge

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class],version=1)
abstract class AppDB:RoomDatabase() {
    abstract fun memoDao():MemoDao

    companion object{
        private var appDB:AppDB?=null

        @Synchronized
        fun getInstance(context: Context):AppDB?{
            if(appDB==null){
                synchronized(AppDB::class.java){
                    appDB= Room.databaseBuilder(
                        context.applicationContext,AppDB::class.java,
                        "appDb"
                    ).allowMainThreadQueries().build()
                }
            }
            return appDB
        }

    }

}