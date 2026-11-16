package br.com.autotech.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ============================================================================
 * FÁBRICA DE CONEXÕES • BANCO AUTOTECH.DB
 * ============================================================================
 * Centraliza a conexão JDBC com o arquivo SQLite local da oficina AutoTech.
 * ============================================================================
 */
public final class ConexaoFactory {

    private static final String URL = "jdbc:sqlite:autotech.db";

    private ConexaoFactory() {
        throw new UnsupportedOperationException("ConexaoFactory e utilitaria!");
    }

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
