package p1;

import java.util.ArrayList;
import java.util.List;

public class Doutor extends Usuario{
	private List<Consultorio> consultorios;
	
	public Doutor(String nome, String cpf) {
		super(nome, cpf);
		this.consultorios = new ArrayList<>();
	}
	public void cadastrarConsultorio(String nome, Repositorioconsultorios consRep) {
		Consultorio consultorio = new Consultorio(nome,this);
		consultorios.add(consultorio);
		consRep.addconsultorio(consultorio);
	}
	@Override
	public void verAgenda() {
		System.out.println("Consulta agendada para " + getNome() + ": ");
		for (Consultorio consultorio : consultorios) {
			System.out.println(consultorios);
			consultorio.verConsultas();
		}
	}
}
