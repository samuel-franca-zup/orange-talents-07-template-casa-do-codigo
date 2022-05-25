package com.zup.orangetalents07templatecasadocodigo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDTO> handle(MethodArgumentNotValidException exception) {

        List<ErroDeFormularioDTO> erroListDTO = new ArrayList<>();

        List<FieldError> erroFields = exception.getBindingResult().getFieldErrors();

        erroFields.forEach(erro -> {

            Boolean fieldJaValidado = verificaSeFieldJaFoiValidado(erroListDTO, erro);

            if (Boolean.FALSE.equals(fieldJaValidado)) {
                String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
                ErroDeFormularioDTO erroDTO = new ErroDeFormularioDTO(erro.getField(), mensagem);

                erroListDTO.add(erroDTO);
            }
        });

        return erroListDTO;

    }

    private Boolean verificaSeFieldJaFoiValidado(List<ErroDeFormularioDTO> erroListDTO, FieldError erro) {
        for (ErroDeFormularioDTO erroDTO : erroListDTO) {
            if (erroDTO.getCampo().equals(erro.getField())) {
                return true;
            }
        }

        return false;
    }

}
