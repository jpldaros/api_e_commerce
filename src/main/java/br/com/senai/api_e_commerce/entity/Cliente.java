package br.com.senai.api_e_commerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "É necessário informar um nome.")
    @Size(min = 1, max = 50, message = "Mínimo de 1 e máximo de 50 caracteres para o nome.")
    private String nome;

    @NotBlank(message = "É necessário informar um e-mail.")
    @Size(min = 1, max = 50, message = "Mínimo de 1 e máximo de 50 caracteres para o e-mail.")
    @Column (unique = true)
    private String email;

    @NotBlank(message = "É necessário informar um endereço.")
    @Size(min = 1, max = 1000, message = "Mínimo de 1 e máximo de 100 caracteres para o endereço.")
    private String endereco;
    
}
