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
		consRep.addConsultorio(consultorio);
	}
	
	@Override
	public void verAgenda() {
		System.out.print(
				  "+=================================+\n"
				+ "|         -Seus Consultórios-\n"
				+ "|\n");
		for (Consultorio consultorio : consultorios) {
			System.out.printf(
					  "+---------------------------------+\n"
					+ "| Consultório: %-19s|\n"
					+ "+---------------------------------+\n",consultorio.getNome());
			consultorio.verConsultas();
		}
	}
}
