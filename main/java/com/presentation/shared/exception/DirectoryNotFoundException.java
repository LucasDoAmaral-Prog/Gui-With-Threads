package com.presentation.shared.exception;

/**
 * Exceção lançada quando o diretório padrão não é encontrado
 */
public class DirectoryNotFoundException extends Exception {

    public DirectoryNotFoundException(String message) {
        super(message);
    }

    public DirectoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}