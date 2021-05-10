package com.brmlab.sqlite.room.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.brmlab.sqlite.model.AccountPOJO
import com.brmlab.sqlite.room.AccountRoom
import com.brmlab.sqlite.room.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountViewModel(application: Application): AndroidViewModel(application) {
    private val accountDAO = AccountRoom.getDatabase(application).getAccountDAO()
    val getAllData: LiveData<List<AccountPOJO>>

    private val repository: AccountRepository

    init {
        repository = AccountRepository(accountDAO)
        getAllData = repository.getAllData
    }

    fun insertData(accountPOJO: AccountPOJO){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertData(accountPOJO)
        }
    }
    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
    fun deleteItem(accountPOJO: AccountPOJO){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteItem(accountPOJO)
        }
    }
}