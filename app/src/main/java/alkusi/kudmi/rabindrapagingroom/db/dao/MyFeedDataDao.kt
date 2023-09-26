package alkusi.kudmi.rabindrapagingroom.db.dao

import alkusi.kudmi.rabindrapagingroom.model.MyFeedData
import alkusi.kudmi.rabindrapagingroom.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import javax.inject.Inject

@Dao
interface MyFeedDataDao {
    @Query("SELECT * FROM MyFeedData")
    fun getQuotes(): androidx.paging.PagingSource<Int, MyFeedData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotes(quotes: List<MyFeedData>)

    @Query("DELETE FROM MyFeedData")
    suspend fun deleteQuotes()
}
