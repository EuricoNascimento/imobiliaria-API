package com.lpweb.imobiliaria.repository

import com.lpweb.imobiliaria.model.Imovel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImovelRepository: JpaRepository<Imovel, Int> {
}