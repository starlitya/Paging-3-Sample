package com.training.pagingsample.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.training.pagingsample.data.model.RemoteKeys

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveKeys(keys: List<RemoteKeys>)

    @Query("SELECT * FROM remote_keys WHERE movieId = :movieId")
    suspend fun remoteKeysMovieId(movieId: Int) : RemoteKeys?

    @Query("DELETE FROM remote_keys")
    suspend fun clearRemoteKeys()
}