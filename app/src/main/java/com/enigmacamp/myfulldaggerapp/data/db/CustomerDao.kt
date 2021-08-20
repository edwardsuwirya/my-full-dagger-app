package com.enigmacamp.myfulldaggerapp.data.db

import androidx.room.Dao
import com.enigmacamp.myfulldaggerapp.data.entity.Customer

@Dao
interface CustomerDao : BaseDao<Customer>