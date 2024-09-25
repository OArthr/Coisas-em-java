package p1;

import java.util.ArrayList;
import java.util.List;

public class Repositorioconsultorios {
	List<Consultorio> consultorios;
	
	public Repositorioconsultorios() {
		this.consultorios = new ArrayList<>();
	}
	
	public boolean addConsultorio(Consultorio consultorio) {
		if(consultorio!=null) {
			consultorios.add(consultorio);
			return true;
		}
		return false;
	}
	
	public Consultorio buscarConsultorio(String nome) {
		for (Consultorio consultorio : consultorios) {
			if (consultorio.getNome().equals(nome)) {
				return consultorio;
			}
		}
		return null;
	}
	
	public boolean removerConsultorio(String nome) {
		for (Consultorio consultorio : consultorios) {
			if (consultorio.getNome().equals(nome)) {
				consultorios.remove(consultorio);
				return true;
			}
		}
		return false;
	}
	
	public void printConsultorios() {
		System.out.println("+---------------------------------+");
		for(Consultorio c : consultorios) {
			System.out.printf(
					  "| Consultório %-20s|\n"
					+ "| Dr. %-28s|\n"
					+ "+---------------------------------+\n",c.getNome(),c.getDoutorResponsavel().getNome());
		}
	}
}
