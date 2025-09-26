package com.presentation.infrastructure.file;

import com.presentation.shared.constants.FileConstants;
import com.presentation.shared.exception.FileReadException;
import java.io.File;


public class FileValidator {
    
    public void validateFile(File file) throws FileReadException {
        if (file == null) {
            throw new FileReadException("No file was selected.");
        }
        
        if (!file.exists()) {
            throw new FileReadException("File does not exist: " + file.getAbsolutePath() + ".");
        }
        
        if (!file.isFile()) {
            throw new FileReadException("Selected item is not a file: " + file.getAbsolutePath() + ".");
        }
        
        if (!file.canRead()) {
            throw new FileReadException("Cannot read file. Check permissions: " + file.getName() + ".");
        }
        
        validateFileSize(file);
        
        validateFileExtension(file);
    }
    
    private void validateFileSize(File file) throws FileReadException {
        long fileSize = file.length();
        
        if (fileSize == 0) {
            throw new FileReadException("File is empty: " + file.getName() + ".");
        }
        
        if (fileSize > FileConstants.MAX_FILE_SIZE_BYTES) {
            throw new FileReadException(
                String.format("File is too large (%.2f MB). Maximum allowed size: %s.", 
                    fileSize / (1024.0 * 1024.0), 
                    FileConstants.MAX_FILE_SIZE_DISPLAY)
            );
        }
    }
    

    private void validateFileExtension(File file) throws FileReadException {

        String fileName = file.getName().toLowerCase();
        
        for (String extension : FileConstants.TEXT_EXTENSIONS) {
            if (fileName.endsWith("." + extension)) {
                return; 
            }
        }
        
        throw new FileReadException("File type not supported: " + file.getName() + 
                                   ". Supported types: " + String.join(", ", FileConstants.TEXT_EXTENSIONS) + ".");
    }
}
