package dados;
import negocios.*;

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
	
	public String getConsultorios() {
		String result = "+---------------------------------+\n";
		for(Consultorio c : consultorios) {
			result += String.format("| Consultório %-20s|\n"
								  + "| %-32s|\n"
								  + "+---------------------------------+\n"
								  ,c.getNome()
								  ,c.getDoutorResponsavel().getNome());
		}
		return result;
	}
}
