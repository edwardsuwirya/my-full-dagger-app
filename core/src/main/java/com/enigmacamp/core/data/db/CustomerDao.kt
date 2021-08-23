package com.enigmacamp.core.data.db

import androidx.room.Dao
import androidx.room.Query
import com.enigmacamp.core.data.entity.Customer

@Dao
interface CustomerDao : BaseDao<Customer> {
    @Query("select * from m_customer where customer_id=:id")
    fun findById(id: Int): Customer
}