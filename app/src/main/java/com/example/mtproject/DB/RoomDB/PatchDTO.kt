package com.example.mtproject.DB.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.mtproject.Domain.PatchDomain
import org.jetbrains.annotations.Nullable


@Entity(tableName = "PatchTable")
data class PatchDTO(
    @PrimaryKey(autoGenerate = true) val recordId: Int = 0,
    val description: String?,
    val id: String,
    val image: String,
    val name: String,
    val rarityColor: String,
    val rarityId: String,
    val rarityName: String
)

//fun PatchDTO.mapToDomain(): PatchDomain {
//    return PatchDomain(
//        description = this.description,
//        id = this.id,
//        image = this.image,
//        name = this.name,
//        rarityColor = this.rarityColor,
//        rarityId = this.rarityId,
//        rarityName = this.rarityName
//    )
//}