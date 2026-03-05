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

import br.com.senai.api_e_commerce.entity.Produto;
import br.com.senai.api_e_commerce.exception.Response;
import br.com.senai.api_e_commerce.repository.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public Response cadastraProduto( @Valid @RequestBody Produto entity) {
        repository.save(entity);
        return new Response(201, "Produto criado com sucesso.");
    }

    @GetMapping
    public List<Produto> retornaTodos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizaProduto(@PathVariable Long id, @RequestBody Produto entity) {

        if (!repository.existsById(id)) {
            return new Response(404, "Produto não encontrado.");
        }

        Produto produto = repository.findById(id).get();

        if (entity.getNome() != null) {
            produto.setNome(entity.getNome());
        }

        if (entity.getPreco() != null) {
            produto.setPreco(entity.getPreco());
        }

        repository.save(produto);

        return new Response(200, "Produto atualizado!");
    }

    @DeleteMapping("/{id}")
    public Response deleteProduto(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Produto não encontrado.");
        }

        repository.deleteById(id);

        return new Response(204, "Produto deletado.");
    }
}
