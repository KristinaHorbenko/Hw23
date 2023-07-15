package org.example;

public class FileMaxSizeReachedException extends RuntimeException{
    public FileMaxSizeReachedException(Integer maxSize, Integer currentSize, String path) {
        super(String.format("File size reached max size: %d, current size: %d, path: %s", maxSize, currentSize, path));
    }
}
