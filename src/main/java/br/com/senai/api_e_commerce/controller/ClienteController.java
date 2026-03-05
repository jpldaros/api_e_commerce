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

import br.com.senai.api_e_commerce.entity.Cliente;
import br.com.senai.api_e_commerce.exception.Response;
import br.com.senai.api_e_commerce.repository.ClienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public Response cadastraCliente( @Valid @RequestBody Cliente entity) {
        
        boolean emailJaExiste = repository.existsByEmail(entity.getEmail());

        if (emailJaExiste){
            return new Response(409, "Já existe um cliente com esse e-mail.");
        }

        repository.save(entity);
        return new Response(201, "Cliente criado com sucesso.");
    }

    @GetMapping
    public List<Cliente> retornaTodos() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Response atualizaCliente(@PathVariable Long id, @RequestBody Cliente entity) {

        if (!repository.existsById(id)) {
            return new Response(404, "Cliente não encontrado.");
        }

        Cliente cliente = repository.findById(id).get();

        if (entity.getNome() != null) {
            cliente.setNome(entity.getNome());
        }

        if (entity.getEmail() != null) {
            cliente.setEmail(entity.getEmail());
        }

        if (entity.getEndereco() != null) {
            cliente.setEndereco(entity.getEndereco());
        }

        repository.save(cliente);

        return new Response(200, "Cliente atualizado!");
    }

    @DeleteMapping("/{id}")
    public Response deleteCliente(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Cliente não encontrado.");
        }

        repository.deleteById(id);

        return new Response(204, "Cliente deletado.");
    }


}
