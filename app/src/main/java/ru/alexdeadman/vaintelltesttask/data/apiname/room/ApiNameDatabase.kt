package ru.alexdeadman.vaintelltesttask.data.apiname.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LocalEntity::class],
    version = 1,
    exportSchema = true
)
abstract class ApiNameDatabase : RoomDatabase() {
    abstract fun apiNameDao(): ApiNameDao
}