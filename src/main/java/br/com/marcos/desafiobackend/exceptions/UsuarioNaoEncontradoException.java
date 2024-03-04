package br.com.marcos.desafiobackend.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
    
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNaoEncontradoException() {
        super();
    }
}
