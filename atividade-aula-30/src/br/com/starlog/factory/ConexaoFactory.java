package br.com.starlog.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private static final String URL = "jdbc:sqlite:almoxarifado.db";

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
