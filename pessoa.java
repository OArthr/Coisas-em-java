package theSimsSim;

public class pessoa {
	private int vida;
	private int alegria;
	private int energia;
	private int dinheiro;
	
	public void comer(int dif) {
		this.vida+=2;
		this.energia++;
		this.dinheiro-=dif;
	}
	public void jogar(int dif) {
		this.alegria+=2;
		this.dinheiro-=dif;
	}
	public void dormir(int dif) {
		this.energia+=2;
		this.alegria++;
	}
	public void trabalhar(int dif) {
		this.energia--;
		this.alegria-=2;
		this.vida--;
		this.dinheiro+=2+dif;
	}
	
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAlegria() {
		return alegria;
	}
	public void setAlegria(int alegria) {
		this.alegria = alegria;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	
}
