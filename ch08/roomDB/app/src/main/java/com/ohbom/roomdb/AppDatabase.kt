package com.ohbom.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [User::class],version=1)

abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao():UserDao

    //전역적으로 사용 가능
    companion object{
        private var appDatabase:AppDatabase?=null//null허용 가능


        @OptIn(InternalCoroutinesApi::class)
        @Synchronized //여러부분에서 하나에 접근하려할때 나 쓰는중이다~
        fun getInstance(context: Context):AppDatabase?{
            if(appDatabase==null){
                synchronized(AppDatabase::class.java){
                    appDatabase= Room.databaseBuilder(
                        context.applicationContext,AppDatabase::class.java,
                        "app-database"
                    ).allowMainThreadQueries().build()

                }

            }
            return appDatabase
        }
    }
}