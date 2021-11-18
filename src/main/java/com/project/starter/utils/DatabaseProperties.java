package com.project.starter.utils;

public class DatabaseProperties {

    private DatabaseProperties() {
        throw new UnsupportedOperationException("Properties class!");
    }

    public static String getDatabaseURL() {
        return System.getenv("DATABASE_URL");
    }

    public static String getDatabasePassword() {
        return System.getenv("DATABASE_PASSWORD");
    }

    public static String getDatabaseUser() {
        return System.getenv("DATABASE_USER");
    }
}
