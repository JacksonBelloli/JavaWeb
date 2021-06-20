package dao;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import models.Jogo;

public class JogoDAO {
	public void insert(Jogo jogo) {
		String query = "INSERT INTO games (nome,descricao,genero,preco) VALUES (?,?,?,?)";
		try {
			PreparedStatement stmt = Conexao.getPreparedStatement(query);
			stmt.setString(1, jogo.getNome());
			stmt.setString(2, jogo.getDescricao());
			stmt.setString(3, jogo.getGenero());
			stmt.setString(4, jogo.getPreco());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Jogo> list(){
		String query = "SELECT * FROM games";
		List<Jogo> jogos = new ArrayList<Jogo>();
		try {			
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				jogos.add(new Jogo(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getString("genero"), rs.getString("preco")));
			}
			return jogos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	public void update(Jogo jogo) {
		String query = "UPDATE games SET nome = ?, descricao = ?, genero = ?, preco = ? WHERE id = ?";
		try {
			PreparedStatement stmt = Conexao.getPreparedStatement(query);
			stmt.setString(1, jogo.getNome());
			stmt.setString(2, jogo.getDescricao());
			stmt.setString(3, jogo.getGenero());
			stmt.setString(4, jogo.getPreco());
			stmt.setInt(5, jogo.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void delete(int id) {
		String query = "DELETE FROM games WHERE id = ?";
		try {
			PreparedStatement stmt = Conexao.getPreparedStatement(query);			
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
