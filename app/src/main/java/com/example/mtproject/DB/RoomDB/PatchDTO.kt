package com.example.mtproject.DB.RoomDB

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mtproject.Domain.PatchDomain



@Entity(tableName = "PatchTable")
data class PatchDTO(
    val description: String,
    @PrimaryKey
    val id: String,
    val image: String,
    val name: String,
    val rarityColor: String,
    val rarityId: String,
    val rarityName: String
)

fun PatchDTO.mapToDomain(): PatchDomain {
    return PatchDomain(
        description = this.description,
        id = this.id,
        image = this.image,
        name = this.name,
        rarityColor = this.rarityColor,
        rarityId = this.rarityId,
        rarityName = this.rarityName
    )
}