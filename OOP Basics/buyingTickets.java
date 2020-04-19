public class buyingTickets{
	
	public static void main(String []args) {
		System.out.println("Comprar ingressos para show do Elton John! \n");
		Rico rico = new Rico();
		Pobre pobre = new Pobre();
		
		rico.setNome("Carlos");
		rico.setSaldo(3000);
		
		pobre.setNome("José");
		pobre.setSaldo(1500);
		
		rico.pagamento(rico);
		pobre.pagamento(pobre);
	}
	
}

abstract class Pessoa{
	private double saldo;
	private String nome;
	
	public abstract void pagamento(Pessoa pessoa);
	
	public void setSaldo(double quantia) {
		this.saldo = quantia;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
		
}

class Pobre extends Pessoa{
	
	public void pagamento(Pessoa pobre) {
		System.out.println(pobre.getNome() + " você paga meia por estar em situação de vulnerabilidade econômica!");
		pobre.setSaldo(pobre.getSaldo() - 500);		
		System.out.println("Seu saldo é: " + pobre.getSaldo() + "\n");
	}
	
	
}

class Rico extends Pessoa{
	
	public void pagamento(Pessoa rico) {
		System.out.println(rico.getNome() + " você pagará a inteira do ingresso!");
		rico.setSaldo(rico.getSaldo() - 1000);
		System.out.println("Seu saldo é: " + rico.getSaldo() + "\n");
	}
}