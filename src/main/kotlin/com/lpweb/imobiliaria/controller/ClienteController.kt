package com.lpweb.imobiliaria.controller

import com.lpweb.imobiliaria.entitys.Cliente
import com.lpweb.imobiliaria.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
class ClienteController {

    @Autowired
    lateinit var repository: ClienteRepository

    @GetMapping
    fun index(): List<Cliente>{
        return repository.findAll()
    }

    @PostMapping
    fun create(@RequestBody cliente: Cliente): Cliente{
        return repository.save(cliente)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Int): Cliente{
        return repository.findById(id).orElseThrow {EntityNotFoundException()}
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody newCliente: Cliente): Cliente{
        val cliente = repository.findById(id).orElseThrow {EntityNotFoundException()}

        cliente.apply {
            this.nome_cliente = newCliente.nome_cliente
            this.cpf = newCliente.cpf
            this.telefone = newCliente.telefone
            this.email = newCliente.email
            this.dt_nacimento = newCliente.dt_nacimento
        }

        return repository.save(cliente)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int){
        val cliente = repository.findById(id).orElseThrow {EntityNotFoundException()}

        repository.delete(cliente)
    }
}