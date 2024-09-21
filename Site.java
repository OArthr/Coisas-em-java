package p1;

import java.util.Scanner;

public class Site {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Interface inter = new Interface();
		Usuario u = null;
		int tela = 0;
		//0=login 1=userArea 2=buscaCons 3=addCons
		
		//Repositorios
		Repositoriousuarios userRep = new Repositoriousuarios();
		Repositorioconsultorios consRep = new Repositorioconsultorios();
		
		while(tela>=0) {
			switch(tela) {
			case 0:
				u = inter.start(scan,userRep);
				tela = 1;
				continue;
			case 1:
				tela = inter.userPlace(scan, u, userRep);
				continue;
			case 2:
				inter.fazConsulta(scan, (Paciente)u, consRep);
				tela = 1;
				continue;
			case 3:
				inter.cadastrarConsultorio(scan, (Doutor)u, consRep);
				tela = 1;
				continue;
			case 4:
			}
		}
		
		
		scan.close();
	}
}
