package com.brmlab.sqlite.room.view

import androidx.lifecycle.LiveData
import androidx.room.*
import com.brmlab.sqlite.model.AccountPOJO

@Dao
interface AccountDAO {

@Query("SELECT * FROM account_table")
 fun getAllData(): LiveData<List<AccountPOJO>>

@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun insertData(accountPOJO: AccountPOJO)

@Query("DELETE FROM account_table")
suspend fun deleteAll()

 @Delete
 suspend fun deleteItem(accountPOJO: AccountPOJO)
}