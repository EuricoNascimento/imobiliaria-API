package com.lpweb.imobiliaria.controller

import com.lpweb.imobiliaria.entitys.Imovel
import com.lpweb.imobiliaria.repository.ImovelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
class ImovelController {
    @Autowired
    lateinit var repository: ImovelRepository

    @GetMapping
    fun index(): List<Imovel>{
        return repository.findAll()
    }

    @PostMapping
    fun create(@RequestBody imovel: Imovel): Imovel {
        return repository.save(imovel)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Int): Imovel {
        return repository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody newImovel: Imovel): Imovel {
        val imovel = repository.findById(id).orElseThrow { EntityNotFoundException() }

        imovel.apply {
            this.tipo_imovel = newImovel.tipo_imovel
            this.endereco = newImovel.endereco
            this.cep = newImovel.cep
            this.dormitorios = newImovel.dormitorios
            this.banheiros = newImovel.banheiros
            this.suites = newImovel.suites
            this.metragem = newImovel.metragem
            this.obs = newImovel.obs
        }

        return repository.save(imovel)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int){
        val imovel = repository.findById(id).orElseThrow { EntityNotFoundException() }

        repository.delete(imovel)
    }
}