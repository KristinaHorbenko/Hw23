package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileLoggerTest {
    @Test
    void testFileFirst() {

        FileLogger fileLogger = new FileLogger(new FileLoggerConfiguration().setPath("log.txt").setMaxFileSize(1024));

        assertDoesNotThrow(() -> {fileLogger.log(Level.INFO, "Test message");
        }, "Exception should not be thrown");
    }

    @Test
    void testFileSecond() {

        FileLogger fileLogger = new FileLogger(new FileLoggerConfiguration().setPath("log.txt").setMaxFileSize(1024));

        assertDoesNotThrow(() -> {fileLogger.log(Level.DEBUG, "Test message");
        }, "Exception should not be thrown");
    }

    @Test
    void testFileThird() throws FileMaxSizeReachedException {

        FileLogger fileLogger = new FileLogger(new FileLoggerConfiguration().setPath("temp.txt").setMaxFileSize(0));
        fileLogger.log(Level.DEBUG, "Debug message");
        assertTrue(fileLogger.exists());

    }

    @Test
    public void testFileAbsence() {

        FileLogger fileLogger = new FileLogger(new FileLoggerConfiguration().setPath("path/to/nonexistent/log/file.txt").
                setMaxFileSize(0));
        assertFalse(fileLogger.exists());
    }


    @Test
    void testThrowsFileMaxSizeReachedException() {
        FileLoggerConfiguration config = new FileLoggerConfiguration().setPath("log.txt").setMaxFileSize(10);
        FileLogger fileLogger = new FileLogger(config);
        assertThrows(FileMaxSizeReachedException.class, () -> {
            fileLogger.log(Level.INFO, "This is a long message exceeding the maximum file size limit");
        });
    }


}
