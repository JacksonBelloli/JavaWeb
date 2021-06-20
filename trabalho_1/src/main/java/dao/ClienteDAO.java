package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Jogo;

public class ClienteDAO {
	public void insert(Cliente cliente) {
		String query = "INSERT INTO clients (nome,data_nasc,pais,estado,cidade,endereco,email) VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = Conexao.getPreparedStatement(query);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getData_nasc());
			stmt.setString(3, cliente.getPais());
			stmt.setString(4, cliente.getEstado());
			stmt.setString(5, cliente.getCidade());
			stmt.setString(6, cliente.getEndereco());
			stmt.setString(7, cliente.getEmail());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Cliente> list(){
		String query = "SELECT * FROM clients";
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {			
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				clientes.add(new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nasc"), rs.getString("pais"), rs.getString("estado"), rs.getString("cidade"), rs.getString("endereco"), rs.getString("email")));
			}
			return clientes;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	public void update(Cliente cliente) {
		String query = "UPDATE clients SET nome = ?, data_nasc = ?, pais = ?, estado = ?, cidade = ?, endereco = ?, email = ? WHERE id = ?";
		try {
			PreparedStatement stmt = Conexao.getPreparedStatement(query);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getData_nasc());
			stmt.setString(3, cliente.getPais());
			stmt.setString(4, cliente.getEstado());
			stmt.setString(5, cliente.getCidade());
			stmt.setString(6, cliente.getEndereco());
			stmt.setString(7, cliente.getEmail());
			stmt.setInt(8, cliente.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void delete(int id) {
		String query = "DELETE FROM clients WHERE id = ?";
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
