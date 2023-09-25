package alkusi.kudmi.rabindrapagingroom.db

import alkusi.kudmi.rabindrapagingroom.db.dao.FeedKeyDao
import alkusi.kudmi.rabindrapagingroom.db.dao.MyFeedDataDao
import alkusi.kudmi.rabindrapagingroom.model.FeedKey
import alkusi.kudmi.rabindrapagingroom.model.MyFeedData
import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = arrayOf(MyFeedData::class,FeedKey::class), version = 1)
abstract class MyRoomDb:RoomDatabase() {
   abstract fun getFeedKeyDao():FeedKeyDao
   abstract fun getMyFeedDataDao():MyFeedDataDao
}