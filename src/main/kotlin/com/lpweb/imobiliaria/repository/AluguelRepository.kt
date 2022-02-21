package com.lpweb.imobiliaria.repository

import com.lpweb.imobiliaria.entitys.Aluguel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AluguelRepository:JpaRepository<Aluguel, Int> {
}