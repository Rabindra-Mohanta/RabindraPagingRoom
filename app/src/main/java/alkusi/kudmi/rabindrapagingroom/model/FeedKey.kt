package alkusi.kudmi.rabindrapagingroom.model
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "FeedKey")
data class FeedKey (
    @PrimaryKey(autoGenerate = false)
    val id:Int,val prePage:Int,val nextPage:Int)