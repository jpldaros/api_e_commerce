package br.com.senai.api_e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.api_e_commerce.entity.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    
}
