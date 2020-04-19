import java.util.Scanner;
public class pcShopping{
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		System.out.println("Digite seu nome: ");
		Scanner nome = new Scanner(System.in);
		cliente.setNome(nome.next());
		System.out.println(cliente.getNome() + ", digite o saldo da sua conta: ");
		Scanner quantia = new Scanner(System.in);
		cliente.setQuantia(quantia.nextDouble());
		System.out.println(cliente.getNome() + ", você selecionou comprar um PC Gamer I5 8400 - 8GB RAM DDR4 - SSD 480GB - GTX1660");
		System.out.println("Como deseja pagar?");
		Scanner tipo = new Scanner(System.in);
		cliente.setTipo(tipo.next());
		cliente.pagamento();
	}
}

abstract class Maquina{
	private String nome, tipo;
	private double quantia;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setQuantia(double quantia) {
		this.quantia = quantia;
	}
	
	public double getQuantia() {
		return this.quantia;
	}
	
	public void pagamento() {
		this.setQuantia(this.getQuantia() - 2300);
		System.out.println("Você ganhou desconto! \nSeu saldo é de " + this.getQuantia());	
	}
}

class Cliente extends Maquina{
	@Override
	public void pagamento() {
	if(this.getTipo().equals("boleto") && this.getQuantia() >= 2300 ) {		
		super.pagamento();
	}else if(this.getTipo().equals("cartao") && this.getQuantia() >= 3000) {
		this.setQuantia(this.getQuantia() - 3000);
		System.out.println("Você não ganhou desconto" + "\nSeu saldo é de " + this.getQuantia());
	}else {
		System.out.println("Ocorreu um erro, tente novamente");
		}
	}
}