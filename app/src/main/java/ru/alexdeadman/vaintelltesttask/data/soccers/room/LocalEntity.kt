package ru.alexdeadman.vaintelltesttask.data.soccers.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexdeadman.vaintelltesttask.data.soccers.room.LocalEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class LocalEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int
) {
    companion object {
        const val TABLE_NAME = "entity_table" // TODO temp name
    }
}