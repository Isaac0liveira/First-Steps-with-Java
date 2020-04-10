package testes;

public class teste01{
	
	public static void main(String[] args) {
		Carro Celta = new Carro();
		Celta.modelo = "Celta";
		Celta.cor = "Vermelho";
		Celta.velocidadeMax = 200;
		Celta.acelera(60);
		
		System.out.println("Pai tá de " + Celta.modelo + "\n" + Celta.cor);
		System.out.println("Velocidade atual: " + Celta.velocidadeAtual + "\nMarcha: " + Celta.marcha());
		
		Celta.acelera(150);
	}
}
class Carro{
	String cor, modelo;
	double velocidadeAtual, velocidadeMax;
	
	void acelera(double quantidade) {
		double nova_velocidadeAtual = this.velocidadeAtual + quantidade;
		if(nova_velocidadeAtual > this.velocidadeMax) {
			System.out.println("Você atingiu o limite de velocidade");
		}else {
			this.velocidadeAtual = nova_velocidadeAtual; 
		}
	}
	
	void desascelera(double quantidade) {
			this.velocidadeAtual -= quantidade;			
	}
	
	int marcha() {
		if(this.velocidadeAtual < 0) {
			return  -1;
		}else if(this.velocidadeAtual >= 0 && this.velocidadeAtual < 40) {
			return 1;
		}else if(this.velocidadeAtual >= 40 && this.velocidadeAtual < 80) {
			return 2;
		}
			return 3;
	}
}