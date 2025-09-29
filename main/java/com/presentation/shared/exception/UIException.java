package com.presentation.shared.exception;

public class UIException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor padrão
     */
    public UIException() {
        super();
    }

    /**
     * Construtor com mensagem
     * @param message Mensagem da exceção
     */
    public UIException(String message) {
        super(message);
    }

    /**
     * Construtor com mensagem e causa
     * @param message Mensagem da exceção
     * @param cause Causa da exceção
     */
    public UIException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construtor com causa
     * @param cause Causa da exceção
     */
    public UIException(Throwable cause) {
        super(cause);
    }
}
