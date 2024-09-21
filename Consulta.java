package p1;

public class Consulta {
	private Paciente paciente;
	private Consultorio consultorio;
	private String dataHora;
	
	public Consulta(Paciente paciente, Consultorio consultorio, String dataHora) {
		this.paciente = paciente;
		this.consultorio = consultorio;
		this.dataHora = dataHora;
	}
	@Override
	public String toString() {
		return "Consulta com " + paciente.getNome() + " no consultório " + consultorio.getNome() +
				" em " + dataHora;
	}
}
