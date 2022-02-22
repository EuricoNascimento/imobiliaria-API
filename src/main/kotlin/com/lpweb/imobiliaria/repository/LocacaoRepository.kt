package com.lpweb.imobiliaria.repository

import com.lpweb.imobiliaria.model.Locacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocacaoRepository: JpaRepository<Locacao, Int> {
}