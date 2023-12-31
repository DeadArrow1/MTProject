package com.example.mtproject.api

import com.example.mtproject.database.SubjectInfoDTO
import com.example.mtproject.domain.SubjectInfoDomain

data class SubjectInfoNetwork(
    val zkratka: String,
    val nazev: String,
    val kreditu: Int,
    val typZkousky: String,
    val vyucovaciJazyky: String,


)

fun SubjectInfoNetwork.mapToDatabase(): SubjectInfoDTO {
    return SubjectInfoDTO(
        nazev = this.nazev,
        zkratka = this.zkratka,
        kreditu = this.kreditu,
        typZkousky = this.typZkousky,
        vyucovaciJazyky = this.vyucovaciJazyky
    )
}