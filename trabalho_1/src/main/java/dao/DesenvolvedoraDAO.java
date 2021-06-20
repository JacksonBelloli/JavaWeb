package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Desenvolvedora;
import models.Jogo;

public class DesenvolvedoraDAO {
	public void insert(Desenvolvedora desenv) {
		String query = "INSERT INTO developer (nome,descricao) VALUES (?,?)";
		try {
			PreparedStatement stmt = Conexao.getPreparedStatement(query);
			stmt.setString(1, desenv.getNome());
			stmt.setString(2, desenv.getDescricao());			
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Desenvolvedora> list(){
		String query = "SELECT * FROM developer";
		List<Desenvolvedora> desenvs = new ArrayList<Desenvolvedora>();
		try {			
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				desenvs.add(new Desenvolvedora(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao")));
			}
			return desenvs;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	public void update(Desenvolvedora desenv) {
		String query = "UPDATE developer SET nome = ?, descricao = ? WHERE id = ?";
		try {
			PreparedStatement stmt = Conexao.getPreparedStatement(query);
			stmt.setString(1, desenv.getNome());
			stmt.setString(2, desenv.getDescricao());
			stmt.setInt(3, desenv.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void delete(int id) {
		String query = "DELETE FROM developer WHERE id = ?";
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
