package com.lpweb.imobiliaria.model

import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "aluguel")
class Aluguel(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @field:NotNull
    @field:OneToMany
    var locacao: Locacao,

    @field:NotNull
    var dt_vencimento: Date,

    @field:Column(columnDefinition="TEXT")
    var obs: String
)