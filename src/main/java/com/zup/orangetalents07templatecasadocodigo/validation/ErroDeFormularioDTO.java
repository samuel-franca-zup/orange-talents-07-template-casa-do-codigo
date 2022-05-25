package com.zup.orangetalents07templatecasadocodigo.validation;

public class ErroDeFormularioDTO {

    private String campo;

    private String mensagem;

    public ErroDeFormularioDTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
