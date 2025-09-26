package com.presentation.domain.service;

import com.presentation.infrastructure.file.FileReader;
import com.presentation.infrastructure.file.FileValidator;
import com.presentation.shared.exception.FileReadException;
import java.io.File;

public class FileService {
    
    private final FileReader fileReader;
    private final FileValidator fileValidator;
    
    public FileService() {
        this.fileReader = new FileReader();
        this.fileValidator = new FileValidator();
    }
    
    public String openFile(File file) throws FileReadException {
        fileValidator.validateFile(file);
        return fileReader.readFile(file);
    }
}
