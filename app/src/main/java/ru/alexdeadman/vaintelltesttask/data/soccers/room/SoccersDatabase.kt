package ru.alexdeadman.vaintelltesttask.data.soccers.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LocalEntity::class],
    version = 1,
    exportSchema = true
)
abstract class SoccersDatabase : RoomDatabase() {
    abstract fun soccersDao(): SoccersDao
}