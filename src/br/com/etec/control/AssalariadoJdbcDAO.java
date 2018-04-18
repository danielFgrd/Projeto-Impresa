package br.com.etec.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;

import br.com.etec.persistence.JdbcUtil;
import br.com.etec.model.Assalariado;

public class AssalariadoJdbcDAO {


	private static Connection connection;
	
	
	public AssalariadoJdbcDAO(Connection connection) {
		AssalariadoJdbcDAO.connection = connection;	
	}
	
	public void inserir(Assalariado assalariado) throws SQLException{
		try {
			String sql = "INSERT INTO tbEmpregado (emNome, emSobrenome, emCpf, emSalario, idCatEmpregado) VALUES ('"+assalariado.getNome()+"','"+assalariado.getSobreNome()+"','"+assalariado.getCpf()+"',"+assalariado.getSalario()+",1);";
			System.out.println(sql);
			PreparedStatement preparedStatement = AssalariadoJdbcDAO.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			AssalariadoJdbcDAO.connection.close();
		}
	}
	
	public void alterar(Assalariado assalariado) throws SQLException{
		String sql = "UPDATE tbEmpregado SET emNome='"+assalariado.getNome()+"', emSobrenome='"+assalariado.getSobreNome()+"', emCpf='"+assalariado.getCpf()+"', emSalario="+assalariado.getSalario()+";";
		System.out.println(sql);
		try {
			PreparedStatement preparedStatement = AssalariadoJdbcDAO.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			AssalariadoJdbcDAO.connection.close();
		}
	}
	
	public void excluir(int id) throws SQLException {
		String sql = "DELETE FROM tbEmpregado WHERE idEmpregado = "+id+";";
		System.out.println(sql);
		try {
			PreparedStatement preparedStatement = AssalariadoJdbcDAO.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			AssalariadoJdbcDAO.connection.close();
		}
		
	}
	public List<Assalariado> listar() throws SQLException{
		String sql = "SELECT idEmpregado, emNome, emSobrenome, emCpf, emSalario FROM tbEmpregado WHERE idCatEmpregado = 1;";
		System.out.println(sql);
		List<Assalariado> assalariados = new ArrayList<Assalariado>();
		try {
			PreparedStatement preparedStatement = AssalariadoJdbcDAO.connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idEmpregado");
				String nome = resultSet.getString("emNome");
				String sobNome = resultSet.getString("emSobrenome");
				String cpf = resultSet.getString("emCpf");
				Float sal = resultSet.getFloat("emSalario");
				
				Assalariado ass = new Assalariado();
				ass.setId(id);
				ass.setNome(nome);
				ass.setSobreNome(sobNome);
				ass.setCpf(cpf);
				ass.setSalario(sal);
				
				assalariados.add(ass);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		finally {
			AssalariadoJdbcDAO.connection.close();
		}
		return assalariados;
	}
	
	public Assalariado findById(Integer id) {
		String sql = "SELECT * FROM tbEmpregado WHERE idEmpregado = "+id;
		System.out.println(sql);
		Assalariado assalariado = null;
		try {
			PreparedStatement preparedStatement = AssalariadoJdbcDAO.connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				assalariado = new Assalariado();
				int idCli = resultSet.getInt("idEmpregado");
				String nome = resultSet.getString("emNome");
				String sobNome = resultSet.getString("emSobrenome");
				String cpf = resultSet.getString("emCpf");
				float salario = resultSet.getFloat("emSalario");
				
				assalariado.setId(idCli);
				assalariado.setNome(nome);
				assalariado.setSobreNome(sobNome);
				assalariado.setCpf(cpf);
				assalariado.setSalario(salario);
			}
			preparedStatement.close();
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return assalariado;
	}
	
	
}
