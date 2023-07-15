package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class FileLogger {
    private FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void log(Level level, String message) throws FileMaxSizeReachedException {
        File logFile = new File(config.getPath());
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Failed to create log file: " + e.getMessage());
                return;
            }
        }

        if (level.equals(Level.INFO) || level.equals(Level.DEBUG)) {
            String log = String.format("%s %s Message: %s ", DateTransformer.convert(), level, message);
            if (config.getMaxFileSize() > 0 && log.length() > config.getMaxFileSize()) {
                throw new FileMaxSizeReachedException(config.getMaxFileSize(), log.length(), config.getPath());

            }

            try (FileWriter writer = new FileWriter(logFile, true)) {
                writer.write(log + "\n");
                writer.flush();
                System.out.println(log);
            } catch (IOException e) {
                System.out.println("Failed to write to log file: " + e.getMessage());
            }

        }
    }

    public boolean exists() {
        File fileLogger = new File(config.getPath());
        return fileLogger.exists();
    }

}












