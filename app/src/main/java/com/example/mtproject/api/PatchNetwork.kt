package com.example.mtproject.api

import com.example.mtproject.DB.RoomDB.PatchDTO


class PatchNetwork : ArrayList<Patch>()

    data class Patch(
        val description: String,
        val id: String,
        val image: String,
        val name: String,
        val rarity: Rarity
    )

    data class Rarity(
        val color: String,
        val id: String,
        val name: String

    )

fun Patch.mapToDatabase(): PatchDTO {
    return PatchDTO(
        description = this.description,
        id = this.id,
        image = this.image,
        name = this.name,
        rarityColor = this.rarity.color,
        rarityId = this.rarity.id,
        rarityName = this.rarity.name
    )
}
