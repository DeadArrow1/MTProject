package com.example.mtproject.model

class Patches : ArrayList<Patch>()

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
