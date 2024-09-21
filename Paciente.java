package p1;

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
	public void verAgenda() {
		System.out.println("Consultas para " + getNome() + ": ");
		for (Consulta consulta : consultasAgendadas) {
			System.out.println(consulta);
		}
	}
}
