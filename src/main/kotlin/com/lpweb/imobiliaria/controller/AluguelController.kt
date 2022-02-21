package com.lpweb.imobiliaria.controller

import com.lpweb.imobiliaria.entitys.Aluguel
import com.lpweb.imobiliaria.repository.AluguelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
class AluguelController {
    @Autowired
    lateinit var repository: AluguelRepository

    @GetMapping
    fun index(): List<Aluguel>{
        return repository.findAll()
    }

    @PostMapping
    fun create(@RequestBody aluguel: Aluguel): Aluguel {
        return repository.save(aluguel)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Int): Aluguel {
        return repository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody newAluguel: Aluguel): Aluguel {
        val aluguel = repository.findById(id).orElseThrow { EntityNotFoundException() }

        aluguel.apply {
            this.locacao = newAluguel.locacao
            this.dt_vencimento = newAluguel.dt_vencimento
            this.obs = newAluguel.obs
        }

        return repository.save(aluguel)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int){
        val aluguel = repository.findById(id).orElseThrow { EntityNotFoundException() }

        repository.delete(aluguel)
    }
}