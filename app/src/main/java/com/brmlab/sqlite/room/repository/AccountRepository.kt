package com.brmlab.sqlite.room.repository

import androidx.lifecycle.LiveData
import com.brmlab.sqlite.model.AccountPOJO
import com.brmlab.sqlite.room.view.AccountDAO

class AccountRepository(private val accountDAO: AccountDAO) {
    val getAllData: LiveData<List<AccountPOJO>> = accountDAO.getAllData()

    suspend fun insertData(accountPOJO: AccountPOJO){
        accountDAO.insertData(accountPOJO)
    }

    suspend fun deleteAll(){
        accountDAO.deleteAll()
    }
    suspend fun deleteItem(accountPOJO: AccountPOJO){
        accountDAO.deleteItem(accountPOJO)
    }
}