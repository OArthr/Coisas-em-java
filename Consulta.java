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
	public String toString(Usuario u) {
		if(u instanceof Doutor)
			return "- Consulta com "+ paciente.getNome()
					+ " no consultório "+ consultorio.getNome()+" em "+ dataHora;
		else
			return "- Consulta com "+ consultorio.getDoutorResponsavel().getNome()
					+ " no consultório " + consultorio.getNome()+" em "+ dataHora;
	}
}
