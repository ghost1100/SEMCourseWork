package com.napier.sem;

public class DatabaseConfig {
    //Configuration Strings.
    private static final String jdbcurl = "jdbc:mysql://localhost:3306/world";
    private static final String username = "root";
    private static final String password = "BkQR7Aczt";

    //Methods to access the configuration.
    public static String jdbcurl(){
        return jdbcurl;
    }
    public static String username(){
        return username;
    }
    public static String password(){
        return password;
    }

}
