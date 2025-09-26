package com.presentation.infrastructure.file;

import com.presentation.shared.exception.FileReadException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileReader {
    
    public String readFile(File file) throws FileReadException { 
    // você coloca o "throws FileReadException" na declaração do método para deixar explicito que
    // esse método pode lamçar uma excessão e isso força as classes que chamam a utilizar nessa
    // chamada uma estrutura try-cath

        if (file == null) {
            throw new FileReadException("File cannot be null.");
        }
        
        try {
            Path path = file.toPath();
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes, StandardCharsets.UTF_8);
            
        } catch (IOException e) {
            throw new FileReadException("Error reading file: " + e.getMessage() + ".", e);
        } catch (OutOfMemoryError e) {
            throw new FileReadException("File too large to load into memory.", e);
        }
    }
}
