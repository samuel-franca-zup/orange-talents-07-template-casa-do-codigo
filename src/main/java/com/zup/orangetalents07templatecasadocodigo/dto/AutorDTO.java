package com.zup.orangetalents07templatecasadocodigo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.orangetalents07templatecasadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AutorDTO {

    @NotNull(message = "Nome é obrigatório")
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Email é obrigatório")
    @NotEmpty(message = "Email é obrigatório")
    @Email(message = "Email tem que ter formato válido")
    private String email;

    @NotNull(message = "Descrição é obrigatória")
    @NotEmpty(message = "Descrição é obrigatória")
    @Length(max = 400, message = "Descrição não pode passar de 400 caracteres")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataRegistro;

    public AutorDTO() {
    }

    public AutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataRegistro = autor.getDataRegistro();
    }

    public Autor converter() {
        Autor autor = new Autor(nome, email, descricao, LocalDateTime.now());
        return autor;
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
