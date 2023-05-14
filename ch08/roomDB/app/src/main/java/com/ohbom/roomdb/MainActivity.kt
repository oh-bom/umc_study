package com.ohbom.roomdb

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ch08 sharedPreference 추가
        val sharedPrefs=getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val editor=sharedPrefs.edit()

        editor.putString("name","ohBom")

        val beforeapplyvalue=sharedPrefs.getString("name","?")
        Log.d("sp","${beforeapplyvalue}") //?

        editor.apply()

        val spvalue=sharedPrefs.getString("name","error")
        Log.d("sp","${spvalue}") //ohbom

        //ch08 room db
        val roomDb=AppDatabase.getInstance(this)
        if(roomDb!=null){
            val user=User("ohbom",24)
            val user2=User("hw",22)
//            roomDb.userDao().insert(user)
//            roomDb.userDao().insert(user2)


            val userList=roomDb.userDao().selectAll()
            Log.d("db","${userList}")

            roomDb.userDao().updateNameByUserId(1,"oh_bom")

            val deleteUser=User("",22)
            roomDb.userDao().delete(deleteUser)

        }
    }
}