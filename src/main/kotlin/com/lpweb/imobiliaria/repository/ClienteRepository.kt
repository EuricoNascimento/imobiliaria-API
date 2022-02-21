package com.lpweb.imobiliaria.repository

import com.lpweb.imobiliaria.entitys.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository<Cliente,Int>{
}