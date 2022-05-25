package com.zup.orangetalents07templatecasadocodigo.controller;

import com.zup.orangetalents07templatecasadocodigo.dto.AutorDTO;
import com.zup.orangetalents07templatecasadocodigo.model.Autor;
import com.zup.orangetalents07templatecasadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorDTO> cadastrar(@RequestBody @Valid AutorDTO autorDTO, UriComponentsBuilder uriComponentsBuilder) {

        Autor autor = autorDTO.converter();

        autorRepository.save(autor);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(new AutorDTO(autor));

    }
}
