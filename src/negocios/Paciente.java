package negocios;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {
	private List<Consulta> consultasAgendadas;
	
	public Paciente (String nome, String cpf) {
		super(nome, cpf);
		this.consultasAgendadas = new ArrayList<>();
	}
	public void agendarConsulta(Consultorio consultorio, String dataHora) {
		Consulta consulta = new Consulta(this, consultorio, dataHora);
		consultasAgendadas.add(consulta);
		consultorio.adicionarConsulta(consulta);
	}
	@Override
	public String getAgenda() {
		String result = "+=================================+\n"
					  + "|         -Sua Agenda-\n"
					  + "|\n";
		for (Consulta consulta : consultasAgendadas) {
			result += "| - "+consulta.toString((Usuario)this)+"\n|\n";
		}
		return result;
	}
}
