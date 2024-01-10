package com.example.mtproject.DB.RoomDB

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface PatchDao {

    @Query("select * from PatchTable LIMIT 1")
    fun getPatchesFromDatabase(): Flow<PatchDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( subject: PatchDTO)
}

@Database(entities = [PatchDTO::class], version = 2)
abstract class MyRoomDatabase: RoomDatabase() {
    abstract val patchDao: PatchDao
}

private lateinit var INSTANCE: MyRoomDatabase

fun getDatabase(context: Context): MyRoomDatabase {
    synchronized(MyRoomDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                MyRoomDatabase::class.java,
                "my_room_database").fallbackToDestructiveMigration().build()
        }
    }
    return INSTANCE
}