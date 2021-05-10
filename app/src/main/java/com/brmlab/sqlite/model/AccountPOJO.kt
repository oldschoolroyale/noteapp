package com.brmlab.sqlite.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account_table")
data class AccountPOJO(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String
)