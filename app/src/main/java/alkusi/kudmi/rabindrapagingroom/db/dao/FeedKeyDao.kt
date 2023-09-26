package alkusi.kudmi.rabindrapagingroom.db.dao

import alkusi.kudmi.rabindrapagingroom.model.FeedKey
import alkusi.kudmi.rabindrapagingroom.model.MyFeedData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FeedKeyDao {
    @Query("SELECT * FROM FeedKey WHERE id =:id")
    suspend fun getRemoteKeys(id: String): FeedKey

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<FeedKey>)

    @Query("DELETE FROM FeedKey")
    suspend fun deleteAllRemoteKeys()
}