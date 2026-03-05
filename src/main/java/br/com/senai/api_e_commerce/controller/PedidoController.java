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

import br.com.senai.api_e_commerce.entity.Pedido;
import br.com.senai.api_e_commerce.exception.Response;
import br.com.senai.api_e_commerce.repository.PedidoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public Response cadastraPedido( @Valid @RequestBody Pedido entity) {
        repository.save(entity);
        return new Response(201, "Pedido criado com sucesso.");
    }

    @GetMapping
    public List<Pedido> retornaTodos() {
        return repository.findAll();
    }

     @PutMapping("/{id}")
    public Response atualizaPedido(@PathVariable Long id, @RequestBody Pedido entity) {

        if (!repository.existsById(id)) {
            return new Response(404, "Pedido não encontrado.");
        }

        Pedido pedido = repository.findById(id).get();

        if (entity.getDataPedido() != null) {
            pedido.setDataPedido(entity.getDataPedido());
        }

        if (entity.getQuantidade() != null) {
            pedido.setQuantidade(entity.getQuantidade());
        }

        if (entity.getStatus() != null) {
            pedido.setStatus(entity.getStatus());
        }

        repository.save(pedido);

        return new Response(200, "Pedido atualizado!");
    }

    @DeleteMapping("/{id}")
    public Response deletePedido(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new Response(404, "Pedido não encontrado.");
        }

        repository.deleteById(id);

        return new Response(204, "Pedido deletado.");
    }
}
