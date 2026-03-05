package br.com.senai.api_e_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.api_e_commerce.entity.Avaliacao;
import br.com.senai.api_e_commerce.exception.Response;
import br.com.senai.api_e_commerce.repository.AvaliacaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    @Autowired
    private AvaliacaoRepository repository;

    @PostMapping
    public Response cadastraAvaliacao( @Valid @RequestBody Avaliacao entity) {
        repository.save(entity);
        return new Response(201, "Avaliação criada com sucesso.");
    }

    @GetMapping
    public List<Avaliacao> retornaTodos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizaAvaliacao(@PathVariable Long id, @RequestBody Avaliacao entity) {

        if (!repository.existsById(id)) {
            return new Response(404, "Avaliação não encontrada.");
        }

        Avaliacao avaliacao = repository.findById(id).get();

        if (entity.getNota() != null) {
            avaliacao.setNota(entity.getNota());
        }

        if (entity.getComentario() != null) {
            avaliacao.setComentario(entity.getComentario());
        }

        repository.save(avaliacao);

        return new Response(200, "Avaliação atualizada!");
    }

    @DeleteMapping("/{id}")
    public Response deleteAvaliacao(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Avaliação não encontrada.");
        }

        repository.deleteById(id);

        return new Response(204, "Avaliação deletada.");
    }
}


