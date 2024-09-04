package theSimsSim;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		pessoa p = new pessoa();
		Scanner scan = new Scanner(System.in);
		
		p.setVida(10);
		p.setEnergia(10);
		p.setAlegria(10);
		p.setDinheiro(10);
		
		int n = 0;
		int dia = 0;
		int dif = 0;
		while(p.getVida()>0 && p.getAlegria()>0 && p.getDinheiro()>=0) {
			System.out.format("Dia: %d  Dificulade: %d \nVida: %d | Alegria: %d | Energia: %d | Dinheiro: RS %d \n",dia,dif,p.getVida(),p.getAlegria(),p.getEnergia(),p.getDinheiro());
			
			if(p.getEnergia()==0) {
				p.dormir(dif);
				continue;
			}
			
			System.out.println("Comer(1)  Jogar(2)  Dormir(3)  Trabalhar(4)");
			n = scan.nextInt();
			while (n<1 || n>4) 
				n = scan.nextInt();
			
			switch (n) {
			case 1:
				p.comer(dif);
				break;
			case 2:
				p.jogar(dif);
				break;
			case 3:
				p.dormir(dif);
				break;
			case 4:
				p.trabalhar(dif);
				break;
			}
			
			dia++;
			if (dia%5==0)
				dif++;
			
			p.setDinheiro(p.getDinheiro()-1);
			
		}
		if(p.getVida()==0)
			System.out.println("Voce morreu");
		else if (p.getAlegria()==0)
			System.out.println("Voce ficou depressivo");
		else if (p.getDinheiro()<0)
			System.out.println("Voce foi preso por nao pagar imposto");
	}
}
