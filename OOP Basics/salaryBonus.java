import java.util.Scanner;
public class salaryBonus{
	
	public static void main(String[] args) {
		
		controleAbono controle = new controleAbono();
		Funcionario funcionario01 = new Funcionario();
		funcionario01.setNome("Jacinto Pinto");
		funcionario01.setSalario(1500);
		funcionario01.setCPF("66273684563");
		controle.registra(funcionario01);

		Gerente funcionario02 = new Gerente();
		funcionario02.setNome("Deyde Costa");
		funcionario02.setSalario(3000);
		funcionario02.setCPF("68697223622");
		funcionario02.getAbono();
		funcionario02.setSenha(14140500);
		controle.registra(funcionario02);
		
		System.out.println("Digite sua senha, gerente: ");
		Scanner senha = new Scanner(System.in);
		if(funcionario02.autentica(senha.nextInt())) {
			System.out.println(funcionario01.nome + "\n" + funcionario01.salario
					+ "\n" + funcionario01.cpf + "\n" + funcionario01.getAbono() + "\n");
			System.out.println(funcionario02.nome + "\n" + funcionario02.salario
					+ "\n" + funcionario02.cpf + "\n" + funcionario02.getAbono() + "\n");
			System.out.println("Total de abonos: " + controle.getTotalAbonos());
		}
}
}
class controleAbono{
	private double totalAbonos = 0;
	
	public void registra(Funcionario funcionario) {
		this.totalAbonos += funcionario.getAbono();
	}
	
	double getTotalAbonos() {
		return this.totalAbonos;
	}
}

class Funcionario{
	protected String nome;
	protected String cpf;
	protected double salario;
	
	void setNome(String nome) {
		this.nome = nome;
	}
	String getNome() {
		return this.nome;
	}
	void setCPF(String cpf) {
		this.cpf = cpf;
	}
	String getCPF() {
		return this.cpf;
	}
	void setSalario(double salario) {
		this.salario = salario;
	}
	double getSalario() {
		return this.salario;
	}
	
	double getAbono() {
		return this.salario * 0.10;
	}
}
class Gerente extends Funcionario{
	private int senha;
	private int numeroDeFuncionariosGerenciados;
	
	public boolean autentica(int senha) {
		if(this.senha == senha) {
			System.out.println("Acesso garantido!");
			return true;
		}else {
			System.out.println("Acesso negado!");
			return false;
		}
	}
	
	void setSenha(int senha) {
		this.senha = senha;
	}
	
	int getSenha() {
		return this.senha;
	}
	
	@Override
	public double getAbono() {
		return super.getAbono() + (this.salario * 0.05);
	}
}