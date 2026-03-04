package br.com.senai.api_e_commerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Avaliacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "É necessário informar uma quantidade.")
    @Positive
    @Min(value = 1, message = "A nota deve estar entre 1 e 5, sendo 1 a menor nota e 5 a maior nota.")
    @Max(value = 5, message = "A nota deve estar entre 1 e 5, sendo 1 a menor nota e 5 a maior nota.")
    private Integer nota;

    @Size(min = 3, max = 200, message = "Mínimo de 3 e máximo de 200 caracteres para um comentário.")
    private String comentario;

    //fk_cliente int not null
    //fk_produto int not null
}
