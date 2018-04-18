package br.com.etec.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;
import br.com.etec.persistence.JdbcUtil;
import br.com.etec.model.Horista;

public class HoristaJdbcDAO {


	private static Connection connection;
	
	
	public HoristaJdbcDAO(Connection connection) {
		HoristaJdbcDAO.connection = connection;	
	}
	
	public void inserir(Horista horista) throws SQLException{
		try {
			String sql = "INSERT INTO tbEmpregado (emNome, emSobrenome, emCpf, emHoraTrabalhada, emPrecoHora, idCatEmpregado) VALUES ('"+horista.getNome()+"','"+horista.getSobreNome()+"','"+horista.getCpf()+"',"+horista.getHorasTrabalhadas()+","+horista.getPrecoHora()+",3);";
			System.out.println(sql);
			PreparedStatement preparedStatement = HoristaJdbcDAO.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			HoristaJdbcDAO.connection.close();
		}
	}
	
	public void alterar(Horista horista) throws SQLException{
		String sql = "UPDATE tbEmpregado SET emNome='"+horista.getNome()+"', emSobrenome='"+horista.getSobreNome()+"', emCpf='"+horista.getCpf()+"', emHoraTrabalhada="+horista.getHorasTrabalhadas()+", emPrecoHora="+horista.getPrecoHora()+";";
		System.out.println(sql);
		try {
			PreparedStatement preparedStatement = HoristaJdbcDAO.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			HoristaJdbcDAO.connection.close();
		}
	}
	
	public void excluir(int id) throws SQLException {
		String sql = "DELETE FROM tbEmpregado WHERE idEmpregado = "+id+";";
		System.out.println(sql);
		try {
			PreparedStatement preparedStatement = HoristaJdbcDAO.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			HoristaJdbcDAO.connection.close();
		}
		
	}
	public List<Horista> listar() throws SQLException{
		String sql = "SELECT idEmpregado, emNome, emSobrenome, emCpf, emPrecoHora, emHoraTrabalhada FROM tbEmpregado WHERE idCatEmpregado = 3;";
		System.out.println(sql);
		List<Horista> horistas = new ArrayList<Horista>();
		try {
			PreparedStatement preparedStatement = HoristaJdbcDAO.connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("idEmpregado");
				String nome = resultSet.getString("emNome");
				String sobNome = resultSet.getString("emSobrenome");
				String cpf = resultSet.getString("emCpf");
				Float precoHora = resultSet.getFloat("emPrecoHora");
				Float horaTrabalhada = resultSet.getFloat("emHoraTrabalhada");
				
				Horista ass = new Horista();
				ass.setId(id);
				ass.setNome(nome);
				ass.setSobreNome(sobNome);
				ass.setCpf(cpf);
				ass.setPrecoHora(precoHora);
				ass.setHorasTrabalhadas(horaTrabalhada);
				
				horistas.add(ass);
			}
		}
		catch(Exception ex) {
			throw ex;
		}
		finally {
			HoristaJdbcDAO.connection.close();
		}
		return horistas;
	}
	
	public Horista findById(Integer id) {
		String sql = "SELECT * FROM tbEmpregado WHERE idEmpregado = "+id;
		System.out.println(sql);
		Horista horista = null;
		try {
			PreparedStatement preparedStatement = HoristaJdbcDAO.connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				horista = new Horista();
				int idCli = resultSet.getInt("idEmpregado");
				String nome = resultSet.getString("emNome");
				String sobNome = resultSet.getString("emSobrenome");
				String cpf = resultSet.getString("emCpf");
				float precoHora = resultSet.getFloat("emPrecoHora");
				float horaTrabalhada = resultSet.getFloat("emHoraTrabalhada");
				
				horista.setId(idCli);
				horista.setNome(nome);
				horista.setSobreNome(sobNome);
				horista.setCpf(cpf);
				horista.setPrecoHora(precoHora);
				horista.setHorasTrabalhadas(horaTrabalhada);
			}
			preparedStatement.close();
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return horista;
	}
	
	
}
