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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
