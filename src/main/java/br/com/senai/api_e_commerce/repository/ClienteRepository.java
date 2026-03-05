package br.com.senai.api_e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.api_e_commerce.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmail(String email);
}
