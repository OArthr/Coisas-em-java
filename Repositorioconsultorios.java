package p1;

import java.util.ArrayList;
import java.util.List;

public class Repositorioconsultorios {
	List<Consultorio> consultorios;
	
	public Repositorioconsultorios() {
		this.consultorios = new ArrayList<>();
	}
	public void addconsultorio(Consultorio consultorio) {
		consultorios.add(consultorio);
		System.out.println("Consultório cadastrado com sucesso!");
	}
	
	public Consultorio buscarConsultorio(String nome) {
		for (Consultorio consultorio : consultorios) {
			if (consultorio.getNome().equals(nome)) {
				System.out.println("Consultório encontrado: ");
				return consultorio;
			}
		}
		return null;
	}
	
	public boolean removerConsultorio(String nome) {
		for (Consultorio consultorio : consultorios) {
			if (consultorio.getNome().equals(nome)) {
				consultorios.remove(consultorio);
				System.out.println("Consultório removido com sucesso!");
				return true;
			}
		}
		System.out.println("Consultório não encontrado!");
		return false;
		
	}
}
