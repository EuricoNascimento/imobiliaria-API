package com.lpweb.imobiliaria.controller

import com.lpweb.imobiliaria.entitys.Imovel
import com.lpweb.imobiliaria.entitys.Locacao
import com.lpweb.imobiliaria.repository.LocacaoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
class LocacaoController {
    @Autowired
    lateinit var repository: LocacaoRepository

    @GetMapping
    fun index(): List<Locacao>{
        return repository.findAll()
    }

    @PostMapping
    fun create(@RequestBody locacao: Locacao): Locacao {
        return repository.save(locacao)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Int): Locacao {
        return repository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody newLocacao: Locacao): Locacao {
        val locacao = repository.findById(id).orElseThrow { EntityNotFoundException() }

        locacao.apply {
            this.imovel = newLocacao.imovel
            this.inquilino = newLocacao.inquilino
            this.ativo = newLocacao.ativo
            this.data_inicio = newLocacao.data_inicio
            this.data_fim = newLocacao.data_fim
            this.perc_multa = newLocacao.perc_multa
            this.valor_aluguel = newLocacao.valor_aluguel
            this.obs = newLocacao.obs
        }

        return repository.save(locacao)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int){
        val locacao = repository.findById(id).orElseThrow { EntityNotFoundException() }

        repository.delete(locacao)
    }
}