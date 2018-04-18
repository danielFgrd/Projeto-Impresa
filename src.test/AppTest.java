import br.com.etec.control.*;
import br.com.etec.model.*;
import br.com.etec.persistence.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

import javax.accessibility.AccessibleAttributeSequence;

public class AppTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int opcoes = 0;
		int objetos = 0;
//		variaveis de empregados
		String nome = null;
		int id = 0;
		String cpf = null;
		String sobreNome = null;
		
		
		
		Scanner scanner = new Scanner(System.in);
		Connection connection = JdbcUtil.getConnection();
		
		
		System.out.println("#################Testando os Métodos######################");
		
		System.out.println("Escolha o objeto que desejas manipular: 1=Assalariado 2=Comissionado 3=Horista");
		objetos = scanner.nextInt();
		
		switch(objetos) {
		case 1:
//		valiaveis assalariados
			float salario = (float) 0000.0;
//			MANIPULANDO ASSALARIADOS
			AssalariadoJdbcDAO assalariadoJdbcDAO = new AssalariadoJdbcDAO(connection);
			Assalariado assalariado = new Assalariado();
			
			System.out.println("Escolha alguma operação para fazer no banco. \n1=insert 2=update 3=delete 4=select");
			opcoes = scanner.nextInt();
			
			switch(opcoes) {
			case 1:
	//			SALVAR
				String salvarOuAterar = "salvar";
				
				System.out.println("Digite o nome: ");
				nome = scanner.next();
				System.out.println("Digite o sobrenome: ");
				sobreNome = scanner.next();
				System.out.println("Digite o cpf");
				cpf = scanner.next();
				System.out.println("Digite o salario: ");
				salario = scanner.nextFloat();
				
				assalariado.setNome(nome);
				assalariado.setSobreNome(sobreNome);
				assalariado.setCpf(cpf);
				assalariado.setSalario(salario);
				
				assalariadoJdbcDAO.inserir(assalariado);
			break;
			
			case 2:
				
	//			ALTERAR
				id = 0;
				System.out.println("Digite o ID  a ser alterado");
				id = Integer.parseInt(scanner.nextLine());
				System.out.println("Digite o nome ou enter se não for alterar: ");
				nome = scanner.nextLine();
				System.out.println("Digite o sobrenome ou enter se não for alterar:");
				sobreNome = scanner.nextLine();
				System.out.println("Digite o salario ou enter se não for alterar:");
				salario = scanner.nextFloat();
				
				
				assalariado.setId(id);
				assalariado.setNome(nome);
				assalariado.setSobreNome(sobreNome);
				assalariado.setCpf(cpf);
				assalariado.setSalario(salario);
				
				assalariadoJdbcDAO.alterar(assalariado);
				
			case 3:
	//			Excluir
				System.out.println("Digite o id a ser apagado.");
				id = 0;
				id= scanner.nextInt();
				
				assalariadoJdbcDAO.excluir(id);
				break;
			case 4:
	//			LISTAR
				System.out.println("Dados encontrados.");
	
				List<Assalariado> list = assalariadoJdbcDAO.listar();
				int tamanho = list.size();
				if(list != null) {
					for(int i = 0 ;tamanho > i; i++) {
						assalariado = list.get(i);
						System.out.println("Id: "+ assalariado.getId());
						System.out.println("Nome: "+ assalariado.getNome());
						System.out.println("Sobrenome: "+assalariado.getSobreNome());
						System.out.println("Cpf: "+assalariado.getCpf());
						System.out.println("Salario: "+assalariado.getSalario());
						System.out.println("#############Empregado Número"+(i+1)+"##############");
					}
				}
				else {
					System.out.println("Usuario desconhecido;");
				}
				break;
				
			}
			break;
			
			
			
			
			
			
		case 2:			
//		variaveis comissionados
			float totalVendas =(float) 0.0;
			float totalComissao =(float) 0.0;
			
//			MANIPULA OS COMISSIONADOS
			ComissionadoJdbcDAO comissionadoJdbcDAO = new ComissionadoJdbcDAO(connection);
			Comissionado comissionado = new Comissionado();
			
			System.out.println("Escolha alguma operação para fazer no banco. \n1=insert 2=update 3=delete 4=select");
			opcoes = scanner.nextInt();
			
			switch(opcoes) {
			case 1:
	//			SALVAR
				String salvarOuAterar = "salvar";
				
				System.out.println("Digite o nome: ");
				nome = scanner.next();
				System.out.println("Digite o sobrenome: ");
				sobreNome = scanner.next();
				System.out.println("Digite o cpf");
				cpf = scanner.next();
				System.out.println("Digite o total de comissão: ");
				totalComissao = scanner.nextFloat();
				System.out.println("Digite o total das vendas: ");
				totalVendas = scanner.nextFloat();
				
				
				comissionado.setNome(nome);
				comissionado.setSobreNome(sobreNome);
				comissionado.setCpf(cpf);
				comissionado.setTaxaComissao(totalComissao);
				comissionado.setTotalVendas(totalVendas);
				
				comissionadoJdbcDAO.inserir(comissionado);
			break;
			
			case 2:
				
	//			ALTERAR
				id = 0;
				System.out.println("Digite o ID  a ser alterado");
				id = Integer.parseInt(scanner.nextLine());
				System.out.println("Digite o nome ou enter se não for alterar: ");
				nome = scanner.nextLine();
				System.out.println("Digite o sobrenome ou enter se não for alterar:");
				sobreNome = scanner.nextLine();
				System.out.println("Digite o total da comissão ou enter se não for alterar:");
				totalComissao = scanner.nextFloat();
				System.out.println("Digite o total das vendas ou enter se não for alterar:");
				totalVendas = scanner.nextFloat();
				
				
				comissionado.setId(id);
				comissionado.setNome(nome);
				comissionado.setSobreNome(sobreNome);
				comissionado.setCpf(cpf);
				comissionado.setTaxaComissao(totalComissao);
				comissionado.setTotalVendas(totalVendas);
				
				comissionadoJdbcDAO.alterar(comissionado);
				
			case 3:
	//			Excluir
				System.out.println("Digite o id a ser apagado.");
				id = 0;
				id= scanner.nextInt();
				
				comissionadoJdbcDAO.excluir(id);
				break;
			case 4:
	//			LISTAR
				System.out.println("Dados encontrados.");
	
				List<Comissionado> list = comissionadoJdbcDAO.listar();
				int tamanho = list.size();
				if(list != null) {
					for(int i = 0 ;tamanho > i; i++) {
						comissionado = list.get(i);
						System.out.println("Id: "+ comissionado.getId());
						System.out.println("Nome: "+ comissionado.getNome());
						System.out.println("Sobrenome: "+comissionado.getSobreNome());
						System.out.println("Cpf: "+comissionado.getCpf());
						System.out.println("Total comissão: "+comissionado.getTaxaComissao());
						System.out.println("Total vendas: "+comissionado.getTotalVendas());
						System.out.println("#############Empregado Número"+(i+1)+"##############");
					}
				}
				else {
					System.out.println("Usuario desconhecido;");
				}
				break;
				
			}
			break;
			
			
			
			
			
			
			
		case 3:
//			variavel horistas
			float horasTrabalhadas = 0;
			float precoHora = 0;
			
//			MANIPULA OS HORISTAS
			HoristaJdbcDAO horistaJdbcDAO = new HoristaJdbcDAO(connection);
			Horista horista = new Horista();
			
			System.out.println("Escolha alguma operação para fazer no banco. \n1=insert 2=update 3=delete 4=select");
			opcoes = scanner.nextInt();
			
			switch(opcoes) {
			case 1:
	//			SALVAR
				String salvarOuAterar = "salvar";
				
				System.out.println("Digite o nome: ");
				nome = scanner.next();
				System.out.println("Digite o sobrenome: ");
				sobreNome = scanner.next();
				System.out.println("Digite o cpf");
				cpf = scanner.next();
				System.out.println("Digite o preco da hora: ");
				precoHora = scanner.nextFloat();
				System.out.println("Digite o total de horas trabalhadas: ");
				horasTrabalhadas = scanner.nextFloat();
				
				
				horista.setNome(nome);
				horista.setSobreNome(sobreNome);
				horista.setCpf(cpf);
				horista.setPrecoHora(precoHora);
				horista.setHorasTrabalhadas(horasTrabalhadas);
				
				horistaJdbcDAO.inserir(horista);
			break;
			
			case 2:
				
	//			ALTERAR
				id = 0;
				System.out.println("Digite o ID  a ser alterado");
				id = Integer.parseInt(scanner.nextLine());
				System.out.println("Digite o nome ou enter se não for alterar: ");
				nome = scanner.nextLine();
				System.out.println("Digite o sobrenome ou enter se não for alterar:");
				sobreNome = scanner.nextLine();
				System.out.println("Digite o total de horas trabalhadas ou enter se não for alterar:");
				horasTrabalhadas = scanner.nextFloat();
				System.out.println("Digite o preço da hora ou enter se não for alterar:");
				precoHora = scanner.nextFloat();
				
				
				horista.setId(id);
				horista.setNome(nome);
				horista.setSobreNome(sobreNome);
				horista.setCpf(cpf);
				horista.setPrecoHora(precoHora);
				horista.setHorasTrabalhadas(horasTrabalhadas);
				
				horistaJdbcDAO.alterar(horista);
				
			case 3:
	//			Excluir
				System.out.println("Digite o id a ser apagado.");
				id = 0;
				id= scanner.nextInt();
				
				horistaJdbcDAO.excluir(id);
				break;
			case 4:
	//			LISTAR
				System.out.println("Dados encontrados.");
	
				List<Horista> list = horistaJdbcDAO.listar();
				int tamanho = list.size();
				if(list != null) {
					for(int i = 0 ;tamanho > i; i++) {
						horista = list.get(i);
						System.out.println("Id: "+ horista.getId());
						System.out.println("Nome: "+ horista.getNome());
						System.out.println("Sobrenome: "+horista.getSobreNome());
						System.out.println("Cpf: "+horista.getCpf());
						System.out.println("Total horas trabalhadas: "+horista.getHorasTrabalhadas());
						System.out.println("Total preço das horas: "+horista.getPrecoHora());
						System.out.println("#############Empregado Número"+(i+1)+"##############");
					}
				}
				else {
					System.out.println("Usuario desconhecido;");
				}
				break;
				
			}
		}	
		
	}

}
