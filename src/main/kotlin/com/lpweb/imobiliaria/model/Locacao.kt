package com.lpweb.imobiliaria.model

import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "locacao")
class Locacao (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @field:NotNull
    @field:ManyToOne
    var imovel: Imovel,

    @field:NotNull
    @field:ManyToOne
    var inquilino: Cliente,

    @field:NotNull
    var ativo: Short,

    @field:NotNull
    var data_inicio: Date,

    @field:NotNull
    var data_fim: Date,

    @field:NotNull
    var perc_multa: Double,

    @field:NotNull
    var valor_aluguel: Double,

    @field:Column(columnDefinition="TEXT")
    var obs: String
)