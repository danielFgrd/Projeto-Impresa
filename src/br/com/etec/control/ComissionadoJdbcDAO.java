package br.com.etec.control;


import br.com.etec.persistence.JdbcUtil;
import br.com.etec.model.Comissionado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;


public class ComissionadoJdbcDAO {

	private static Connection connection;
	
	
	public ComissionadoJdbcDAO(Connection connection) {
		ComissionadoJdbcDAO.connection = connection;	
	}
	
	public void inserir(Comissionado comissionado) throws SQLException{
		try {
			String sql = "INSERT INTO tbEmpregado (emNome, emSobrenome, emCpf, emTotalComissao, emTotalVenda, idCatEmpregado) VALUES ('"+comissionado.getNome()+"','"+comissionado.getSobreNome()+"','"+comissionado.getCpf()+"',"+comissionado.getTaxaComissao()+","+comissionado.getTotalVendas()+",2);";
			System.out.println(sql);
			PreparedStatement preparedStatement = ComissionadoJdbcDAO.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			ComissionadoJdbcDAO.connection.close();
		}
	}
	
	public void alterar(Comissionado comissionado) throws SQLException{
		String sql = "UPDATE tbEmpregado SET emNome='"+comissionado.getNome()+"', emSobrenome='"+comissionado.getSobreNome()+"', emCpf='"+comissionado.getCpf()+"', emTotalComissao="+comissionado.getTaxaComissao()+",emTotalVendas="+comissionado.getTotalVendas()+";";
		System.out.println(sql);
		try {
			PreparedStatement preparedStatement = ComissionadoJdbcDAO.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			ComissionadoJdbcDAO.connection.close();
		}
	}
	
	public void excluir(int id) throws SQLException {
		String sql = "DELETE FROM tbEmpregado WHERE idEmpregado = "+id+";";
		System.out.println(sql);
		try {
			PreparedStatement preparedStatement = ComissionadoJdbcDAO.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			ComissionadoJdbcDAO.connection.close();
		}
		
	}
	public List<Comissionado> listar() throws SQLException{
		String sql = "SELECT idEmpregado, emNome, emSobrenome, emCpf, emTotalComissao, emTotalVenda FROM tbEmpregado WHERE idCatEmpregado = 2;";
		System.out.println(sql);
		List<Comissionado> comissionados = new ArrayList<Comissionado>();
		try {
			PreparedStatement preparedStatement = ComissionadoJdbcDAO.connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idEmpregado");
				String nome = resultSet.getString("emNome");
				String sobNome = resultSet.getString("emSobrenome");
				String cpf = resultSet.getString("emCpf");
				Float totc = resultSet.getFloat("emTotalComissao");
				Float tocv = resultSet.getFloat("emTotalVenda");
				
				
				Comissionado ass = new Comissionado();
				ass.setId(id);
				ass.setNome(nome);
				ass.setSobreNome(sobNome);
				ass.setCpf(cpf);
				ass.setTaxaComissao(totc);
				ass.setTotalVendas(tocv);
				
				comissionados.add(ass);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		finally {
			ComissionadoJdbcDAO.connection.close();
		}
		return comissionados;
	}
	
	public Comissionado findById(Integer id) {
		String sql = "SELECT * FROM tbEmpregado WHERE idEmpregado = "+id;
		System.out.println(sql);
		Comissionado comissionado = null;
		try {
			PreparedStatement preparedStatement = ComissionadoJdbcDAO.connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				comissionado = new Comissionado();
				int idCli = resultSet.getInt("idEmpregado");
				String nome = resultSet.getString("emNome");
				String sobNome = resultSet.getString("emSobrenome");
				String cpf = resultSet.getString("emCpf");
				float salario = resultSet.getFloat("emSalario");
				float taxaComissao = resultSet.getFloat("emTotalComissao");
				float totalVendas = resultSet.getFloat("emTotalVendas");
				
				comissionado.setId(idCli);
				comissionado.setNome(nome);
				comissionado.setSobreNome(sobNome);
				comissionado.setCpf(cpf);
				comissionado.setTaxaComissao(taxaComissao);
				comissionado.setTotalVendas(totalVendas);
			}
			preparedStatement.close();
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return comissionado;
	}
	
	
}
