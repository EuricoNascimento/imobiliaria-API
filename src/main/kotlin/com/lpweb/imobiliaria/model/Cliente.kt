package com.lpweb.imobiliaria.model

import org.hibernate.validator.constraints.br.CPF
import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "cliente")
class Cliente (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @field:NotNull
    @field:Size(min = 3, max = 200)
    var nome_cliente: String,

    @field:NotNull
    @field:CPF
    var cpf: String,

    @field:NotNull
    @field:Size(min = 11, max = 12)
    var telefone: String,

    @field:NotNull
    @field:Email
    var email: String,

    @field:NotNull
    var dt_nacimento: Date,
)