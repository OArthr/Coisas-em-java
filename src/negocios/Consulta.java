package negocios;

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
		return "Consulta com "+ ((u instanceof Doutor)? paciente.getNome():consultorio.getDoutorResponsavel().getNome())
				+ " no consultório " + consultorio.getNome()
				+ " em " + dataHora;
	}
}
