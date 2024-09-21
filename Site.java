package p1;

import java.util.Scanner;

public class Site {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Repositorios
		Repositoriousuarios usuariorepo = new Repositoriousuarios();
		Repositorioconsultorios consultoriorepo = new Repositorioconsultorios();
		
		//Definir quantidade de médicos e pacientes
		System.out.println("Quanto médicos deseja cadastrar?");
		int numMedicos = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 1 ;i <= numMedicos; i++ ) {
			System.out.println("Digite o nome do médico " + i + ": ");
			String nomeDoutor = scanner.nextLine();
			System.out.println("Digite o cpf do médico " + i + ": ");
			String cpfDoutor = scanner.nextLine();
			
			Doutor doutor = new Doutor(nomeDoutor, cpfDoutor);
			usuariorepo.addusuario(doutor);
		}
		System.out.println("Quantos pacientes deseja cadastrar?");
		int numPacientes = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 1; i <= numPacientes; i++) {
			System.out.println("Digite o nome do Paciente " + i + ": ");
			String nomePaciente = scanner.nextLine();
			System.out.println("Digite o cpf do Paciente " + i + ": ");
			String cpfPaciente = scanner.nextLine();
			
			Paciente paciente = new Paciente(nomePaciente, cpfPaciente);
			usuariorepo.addusuario(paciente);
		}
	}
}
