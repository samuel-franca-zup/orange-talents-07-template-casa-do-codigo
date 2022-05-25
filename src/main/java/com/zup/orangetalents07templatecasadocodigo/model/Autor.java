package com.zup.orangetalents07templatecasadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String descricao;

    private LocalDateTime dataRegistro;

    public Autor() {
    }

    public Autor(String nome, String email, String descricao, LocalDateTime dataRegistro) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
}
