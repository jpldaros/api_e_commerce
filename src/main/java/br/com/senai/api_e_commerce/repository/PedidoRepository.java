package br.com.senai.api_e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.api_e_commerce.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
