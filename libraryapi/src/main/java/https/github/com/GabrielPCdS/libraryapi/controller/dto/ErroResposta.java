package https.github.com.GabrielPCdS.libraryapi.controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResposta (int status , String message, List<ErroCampo> erros) {

    public static  ErroResposta respostaPadrao(String message){
        return new ErroResposta(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }

    public static ErroResposta conflito(String message){
        return new ErroResposta(HttpStatus.CONFLICT.value(), message, List.of());
    }

}
