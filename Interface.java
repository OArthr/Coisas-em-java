package p1;


import java.util.Scanner;

public class Interface {
	private int escolha;
	
	public static void clear() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}
	
	public Usuario start(Scanner scan, Repositoriousuarios userRep) {
		clear();
		escolha = 0;
		System.out.println("\tSeja bem vindo ao SeConsult!\n\nNovo Usuário(1) ou Entrar(2)");
		escolha = scan.nextInt();
		String nome,cpf;
		Usuario u = null;
		clear();
		
		if (escolha==1){
			System.out.print("\t---Novo Usuário---\nNome: ");
			scan.nextLine();
			nome = scan.nextLine();
			System.out.print("\nCPF: ");
			cpf = scan.nextLine();
			System.out.print("\nÉ um Doutor?(s/n): ");
			if (scan.nextLine().equals("s")) 
				u = new Doutor(nome,cpf);
			else 
				u = new Paciente(nome,cpf);
			userRep.addusuario(u);
		}
		else {
			System.out.println("\t---Entrar---");
			while(u==null) {
				System.out.print("CPF: ");
				scan.nextLine();
				cpf = scan.nextLine();
				u = userRep.buscarUsuario(cpf);
			}
		}
		return u;
	}
	
	public int userPlace(Scanner scan, Usuario u, Repositoriousuarios userRep) {
		clear();
		escolha = 0;
		System.out.print(String.format("\t---Área do Usuário---\n\nNome: %s\nCPF: %s\n\n(1)Ver Agenda ",u.getNome(),u.getCpf()));
		if(u instanceof Paciente) 
			System.out.print("(2)Buscar Consultórios ");
		else
			System.out.print("(2)Adicionar Consultório ");
		System.out.println("(3)Desconectar (4)Sair");
		
		escolha = scan.nextInt();
		switch(escolha) {
		case 1:
			u.verAgenda();
			scan.next();
			return 1;
		case 2:
			if (u instanceof Paciente) 
				return 2;
			else 
				return 3;
		case 3:
			return 0;
		default:
			return -1;
		}
	}
	 public void fazConsulta(Scanner scan, Paciente u, Repositorioconsultorios consRep)  {
		escolha = 0;
		clear();
		System.out.println("\t---Consultorios Cadastrados---");
		consRep.printConsultorios();
		
		Consultorio ct=null;
		while (ct == null) {
			System.out.println("Voltar?(s/n):");
			scan.nextLine();
			if(scan.nextLine().equals("s"))
				return;
			System.out.print("Nome do Consultorio:");
			ct = consRep.buscarConsultorio(scan.nextLine());
		}
		ct.toString();
		String data;
		System.out.print("Qual a data da consulta?: ");
		data = scan.nextLine();
		u.agendarConsulta(ct, data);
	}
	
	public void cadastrarConsultorio(Scanner scan, Doutor u, Repositorioconsultorios consRep) {
		escolha = 0;
		clear();
		System.out.print("\t---Cadastro de Consultório---\nNome do Consutório: ");
		scan.nextLine();
		u.cadastrarConsultorio(scan.nextLine(), consRep);
	}
	
}
