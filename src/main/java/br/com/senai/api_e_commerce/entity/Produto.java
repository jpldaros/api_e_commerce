package br.com.senai.api_e_commerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "É necessário informar um nome.")
    @Size(min = 1, max = 50, message = "Mínimo de 1 e máximo de 50 caracteres para o nome.")
    private String nome;

    @NotNull(message = "É necessário informar um preço para o produto.")
    @Positive(message = "É necessário informar um preço positivo para o produto")
    private Double preco;

    //fk_categoria int not full

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    
}
