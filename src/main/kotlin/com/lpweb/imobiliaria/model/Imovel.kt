package com.lpweb.imobiliaria.model

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "imovel")
class Imovel (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @field:NotNull
    @field:Size(max = 50)
    var tipo_imovel: String,

    @field:NotNull
    @field:Size(max = 255)
    var endereco: String,

    @field:NotNull
    @field:Size(max = 10)
    var cep: String,

    @field:NotNull
    var dormitorios: Int,

    @field:NotNull
    var banheiros: Int,

    @field:NotNull
    var suites: Int,

    @field:NotNull
    var metragem: Int,

    @field:Column(columnDefinition="TEXT")
    var obs: String
)