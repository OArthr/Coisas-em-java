package userInterface;
import dados.*;
import negocios.*;

import java.util.Scanner;

public class Site {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Interface inter = new Interface();
		Usuario u = null;
		int tela = 0;
		//0=login 1=newUser 2=loginUser 3=userPlace 4=bucaCons 5=addCons
		
		//Repositories
		Repositoriousuarios userRep = new Repositoriousuarios();
		Repositorioconsultorios consRep = new Repositorioconsultorios();
		
		while(tela>=0) {
			switch(tela) {
			case 0:
				try{
					tela = inter.start(scan);
				}catch (Exception e) {
					tela = 0;
				}
				continue;
			case 1:
				u = inter.newUser(scan, userRep);
				tela = 3;
				continue;
			case 2:
				u = inter.loginUser(scan, userRep);
				tela = 3;
				continue;
			case 3:
				try{
					tela = inter.userPlace(scan, u);
				}catch (Exception e) {
					tela = 3;
				}
				continue;
			case 4:
				inter.fazConsulta(scan, (Paciente)u, consRep);
				tela = 3;
				continue;
			case 5:
				inter.cadastrarConsultorio(scan, (Doutor)u,consRep);
				tela = 3;
				continue;
			}
		scan.close();
		}
	}
}