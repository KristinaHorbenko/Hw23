package org.example;

public class Main {
    public static void main(String[] args) {

        FileLogger fileLogger = new FileLogger(new FileLoggerConfiguration().setPath("log.txt").setMaxFileSize(1024));
        fileLogger.log(Level.DEBUG, "Debug message");
        fileLogger.log(Level.INFO, "Info message");
        System.out.println(DateTransformer.convert());


    }
}
