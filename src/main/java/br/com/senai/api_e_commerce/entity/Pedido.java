package br.com.senai.api_e_commerce.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull(message = "É necessário informar uma data e um horário (AAAA-MM-DD HH:mm).")
    private LocalDateTime data_pedido;

    @NotNull(message = "É necessário informar uma quantidade.")
    @Positive(message = "É necessário informar uma quantidade positiva para o pedido.")
    private Integer quantidade;

    @NotBlank(message = "É necessário informar o status de pagamento.")
    @Size(min = 3, max = 20, message = "Mínimo de 3 e máximo de 20 caracteres para o status.")
    private String status;

    //fk_cliente int not null
    //fk_produto int not null

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDateTime data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
