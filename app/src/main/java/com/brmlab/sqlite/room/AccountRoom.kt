package com.brmlab.sqlite.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.brmlab.sqlite.model.AccountPOJO
import com.brmlab.sqlite.room.view.AccountDAO

@Database(entities = [AccountPOJO::class], version = 1, exportSchema = false)
abstract class AccountRoom: RoomDatabase() {
    abstract fun getAccountDAO(): AccountDAO

    companion object{


        @Volatile
        private var INSTANCE: AccountRoom? = null

        fun getDatabase(context: Context): AccountRoom{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AccountRoom::class.java,
                    "accountDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}