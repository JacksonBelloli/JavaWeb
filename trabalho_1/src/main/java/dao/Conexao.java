package dao;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
	private static final String host = "localhost";
	private static final String banco = "game_store";
	private static final String usuario = "admin";
	private static final String senha = "admin";
	private static final String url = "jdbc:mysql://" + host + "/" + banco;
	private static Connection con = null;
	
	public static Connection getConexao() {
		try {
			con = DriverManager.getConnection(url, usuario, senha);
		}catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}
		if (con != null) {
			System.out.println("Conectado com sucesso!");
		}else {
			System.out.println("Não foi possível realizar a conexão!!");
		}
		return con;
	}
	public static PreparedStatement getPreparedStatement(String sql){
        if (con == null){
            con = getConexao();
        }
        try {
            return con.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println("Erro de sql: "+
                    e.getMessage());
        }
        return null;
    }     
}
