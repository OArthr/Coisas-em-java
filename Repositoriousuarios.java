package p1;

import java.util.ArrayList;
import java.util.List;

public class Repositoriousuarios {
	private List<Usuario> usuarios;
	
	public Repositoriousuarios() {
		usuarios = new ArrayList<>();
	}
	public void addusuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	public Usuario buscarUsuario(String cpf) {
		for(Usuario usuario : usuarios) {
			if (usuario.getCpf().equals(cpf)) {
				return usuario;
			}
		}
		return null;
	}
	public boolean removerUsuario(String cpf) {
		for (Usuario usuario : usuarios) {
			if (usuario.getCpf().equals(cpf)) {
				usuarios.remove(usuario);
				System.out.println("Usuário removido com sucesso");
				return true;
			}
		}
		System.out.println("Usuário não encontrado");
		return false;
	}
}
