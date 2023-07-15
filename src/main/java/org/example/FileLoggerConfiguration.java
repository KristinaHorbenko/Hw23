package org.example;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FileLoggerConfiguration {
    private String path;
    private Level level;
    private Integer maxFileSize;
    private String logFormat;

    public FileLoggerConfiguration() {

    }

}


