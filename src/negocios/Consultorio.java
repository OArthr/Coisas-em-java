package negocios;

import java.util.ArrayList;
import java.util.List;

public class Consultorio {
	private String nome;
	private Doutor doutorResponsavel;
	private List<Consulta> consultas;
	
	public Consultorio(String nome, Doutor doutorResponsavel) {
		this.nome = nome;
		this.doutorResponsavel = doutorResponsavel;
		this.consultas = new ArrayList<>();
	}
	public String getNome() {
		return nome;
	}
	public Doutor getDoutorResponsavel() {
		return doutorResponsavel;
	}
	public void adicionarConsulta(Consulta consulta) {
		consultas.add(consulta);
	}
	public String getConsultas() {
		String result = "";
		for (Consulta consulta : consultas) {
			result += "| - "+consulta.toString((Usuario)doutorResponsavel)+"\n";
		}
		return result;
	}
}