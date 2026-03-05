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

import br.com.senai.api_e_commerce.entity.Categoria;
import br.com.senai.api_e_commerce.exception.Response;
import br.com.senai.api_e_commerce.repository.CategoriaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    public Response cadastraCategoria( @Valid @RequestBody Categoria entity) {
        repository.save(entity);
        return new Response(201, "Categoria criada com sucesso.");
    }
    
    @GetMapping
    public List<Categoria> retornaTodos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizaCategoria(@PathVariable Long id, @RequestBody Categoria entity) {

        if (!repository.existsById(id)) {
            return new Response(404, "Categoria não encontrada.");
        }

        Categoria categoria = repository.findById(id).get();

        if (entity.getNome() != null) {
            categoria.setNome(entity.getNome());
        }

        if (entity.getDescricao() != null) {
            categoria.setDescricao(entity.getDescricao());
        }

        repository.save(categoria);

        return new Response(200, "Categoria atualizada!");
    }

    @DeleteMapping("/{id}")
    public Response deleteCategoria(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Categoria não encontrada.");
        }

        repository.deleteById(id);

        return new Response(204, "Categoria deletada.");
    }
}
