package com.kts6056.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kts6056.data.model.entity.RemoteKeyEntity

@Dao
internal interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: RemoteKeyEntity)

    @Query("SELECT * FROM remote_key WHERE `query` = :query")
    suspend fun getNextKey(query: String): RemoteKeyEntity?

    @Query("DELETE FROM remote_key WHERE `query`= :query")
    suspend fun delete(query: String)
}
