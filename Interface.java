package p1;


import java.util.Scanner;

public class Interface {
	private int escolha;
	
	public int start(Scanner scan) {
		escolha = 0;
		System.out.print(
				  "+=================================+\n"
				+ "|  Seja bem vindo ao SeConsult!   |\n"
				+ "+=================================+\n"
				+ "|\n"
				+ "| 1- Novo Usuário\n"
				+ "| 2- Conectar-se\n"
				+ "|\n"
				+ "| 3- Fechar Programa\n"
				+ "|\n"
				+ "|-> ");
		escolha = scan.nextInt();
		while(escolha<1||escolha>3) {
			System.out.print("|-> ");
			escolha = scan.nextInt();
		}
		scan.nextLine();
		if(escolha ==3)
			return -1;
		return escolha;
	}
	
	public Usuario newUser(Scanner scan,Repositoriousuarios userRep) {
		String nome,cpf;
		Usuario u;
		
		System.out.print(
				"+=================================+\n"
						+ "|         -Novo Usuário-\n"
						+ "|               __\n"
						+ "|             /. . \\ \n"
						+ "|             \\_- _/\n"
						+ "|             /____\\\n"
						+ "|\n"
						+ "|\tNome: ");
		nome = scan.nextLine();
		
		
		System.out.print("|\tCPF: ");
		cpf = scan.nextLine();
		
		System.out.print("|   É um Doutor?(s/n): ");
		
		u = (scan.nextLine().equals("s")) ? new Doutor("Dr. "+nome,cpf) : new Paciente(nome,cpf);
		
		userRep.addusuario(u);
		return u;
	}
	
	public Usuario loginUser(Scanner scan, Repositoriousuarios userRep) {
		String cpf;
		Usuario u;
		
		System.out.print(
				  "+=================================+\n"
				+ "|         -Log in-\n"
				+ "|               __\n"
				+ "|             /ô ó \\ \n"
				+ "|             \\_- _/\n"
				+ "|             /____\\\n"
				+ "|\n"
				+ "|\tCPF: ");
		
		u = userRep.buscarUsuario(scan.nextLine());
		
		while(u==null) {
			System.out.print(
				  "|  CPF não encontrado...\n"
				+ "|  Digite 'novo' se quiser criar um novo usuario.\n"
				+ "|\tCPF: ");
			
			cpf = scan.nextLine();
			if (cpf.equals("novo")) 
				return this.newUser(scan,userRep);
			u = userRep.buscarUsuario(cpf);
		}
		return u;
	}
	
	public int userPlace(Scanner scan, Usuario u) {
		escolha = 0;
		System.out.printf(
				  "+=================================+\n"
				+ "|    ==== Área do Usuário ====\n"
				+ "|               __\n"
				+ "|             /^ ^ \\ \n"
				+ "|             \\_u _/\n"
				+ "|             /____\\\n"
				+ "|\n"
				+ "|\tNome: %s\n"
				+ "|\t CPF: %s\n"
				+ "|\n", u.getNome(),u.getCpf(),0);
		if(u instanceof Paciente) 
			System.out.print("| 1- Ver agenda\n"
					+ "| 2- Buscar Consultórios\n");
		else
			System.out.print("| 1- Ver agenda e seus consultórios\n"
					+ "| 2- Adicionar Consultório\n");
		System.out.print("| 3- Desconectar\n"
				+ "|\n"
				+ "| 4- Fechar Programa\n"
				+ "|\n"
				+ "|-> ");
		
		escolha = scan.nextInt();
		while(escolha<1||escolha>4) {
			System.out.print("| Digite uma escolha válida.\n"
					+ "|-> ");
			escolha = scan.nextInt();
		}
		
		switch(escolha) {
		case 1:
			System.out.print(u.getAgenda());
			scan.nextLine();
			System.out.print("| Digite qualquer tecla para voltar: ");
			scan.nextLine();
			return 3;
		case 2:
			if (u instanceof Paciente) 
				return 4;
			else 
				return 5;
		case 3:
			return 0;
		default:
			return -1;
		}
	}
	
	 public void fazConsulta(Scanner scan, Paciente u, Repositorioconsultorios consRep)  {
		String data, nome;
		Consultorio c;
		
		System.out.print(
				  "+=================================+\n"
				+ "| --- Consultórios Cadastrados ---\n"
				+ "|\n");
		
		System.out.print(consRep.getConsultorios());
		
		System.out.print("| Nome do consultório: ");
		scan.nextLine();
		c = consRep.buscarConsultorio(scan.nextLine());
		while (c == null) {
			System.out.print("| Consultório não encontrado.\n"
					+ "| Digite 'voltar' se necessário.\n"
					+ "| Nome do consultório: ");
			
			nome = scan.nextLine();
			if(nome.equals("voltar"))
				return;
			c = consRep.buscarConsultorio(nome);
		}
		
		System.out.print("| Qual a data da consulta?: ");
		data = scan.nextLine();
		u.agendarConsulta(c, data);
	}
	
	public void cadastrarConsultorio(Scanner scan, Doutor u, Repositorioconsultorios consRep) {
		escolha = 0;
		
		System.out.print(
				  "+=================================+\n"
				+ "| --- Cadastro de Consultório ---\n"
				+ "|\n"
				+ "| Nome: ");
		scan.nextLine();
		u.cadastrarConsultorio(scan.nextLine(), consRep);
	}
}
