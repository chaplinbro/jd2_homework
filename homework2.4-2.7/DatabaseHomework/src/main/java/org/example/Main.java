package org.example;


import java.sql.SQLException;

public class Main {

    private static Config config;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Config config = new Config();
        config.addInDb(args);
        config.meme();

    }
}