package com.dev_app.buyforme.database

import androidx.room.*
import com.dev_app.buyforme.models.Products

@Dao
interface SearchDao {

    @Query("SELECT * FROM products")
    fun getAllProducts(): List<Products>

    @Query(
        "SELECT * FROM products WHERE name LIKE '%' || :name  || '%'"
    )
    fun findByName(name: String): List<Products>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllProducts(list: List<Products>)
}