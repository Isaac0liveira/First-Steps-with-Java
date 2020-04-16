package testes;
import java.util.Scanner;
public class teste2{
	public static void main(String[] args) {
		namorada L = new namorada();
		System.out.println("Hello World!");
		System.out.println("Qual o nome dela?");
		Scanner nome = new Scanner(System.in);
		L.nome = nome.next();
		System.out.println("Idade?");
		Scanner idade = new Scanner(System.in);
		L.idade = idade.nextInt();
		System.out.println("Altura: ");
		Scanner altura = new Scanner(System.in);
		L.altura = altura.nextFloat();
		L.mudarSentimento();
		L.sentimento = "Ódio";
	}
}

class namorada{
	String nome, cabelo;
	int idade;
	float altura;
	private String sentimento;
	
	public void mudarSentimento() {
		this.sentimento = "Amor";
		System.out.println("É impossível você mudar esse sentimento, você sente " + this.sentimento);
	}
}