package com.github.fiap.java_mysql_ci_cd.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNaoEncontrado extends RuntimeException{

    public UserNaoEncontrado(String mensagem){super(mensagem);}

}
