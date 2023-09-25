package alkusi.kudmi.rabindrapagingroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MyFeedData")
data class MyFeedData(val updatedAt:String?,val type:String?,val title:String?,val text:String?,val postViewedCount:String?,
val phone:String?, @PrimaryKey(autoGenerate = false) val id:String)