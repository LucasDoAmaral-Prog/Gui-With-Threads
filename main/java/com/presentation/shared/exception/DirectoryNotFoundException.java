package com.presentation.shared.exception;

/**
 * Exceção lançada quando o diretório padrão não é encontrado
 */
public class DirectoryNotFoundException extends Exception {
    
    private final String requestedDirectory;
    private final String fallbackDirectory;
    
    public DirectoryNotFoundException(String requestedDirectory, String fallbackDirectory) {
        super(String.format("Directory not found: %s. Using fallback: %s", 
              requestedDirectory, fallbackDirectory));
        this.requestedDirectory = requestedDirectory;
        this.fallbackDirectory = fallbackDirectory;
    }
    
    public String getRequestedDirectory() {
        return requestedDirectory;
    }
    
    public String getFallbackDirectory() {
        return fallbackDirectory;
    }
}