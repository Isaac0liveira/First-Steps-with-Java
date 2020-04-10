package testes;

public class teste01{
	
	public static void main(String [] args) {
		Fibonacci  fibonacci = new Fibonacci();
		int resultado = 1;
		for(int i = 1; i < 10; i++) {
			resultado = fibonacci.fibonacci(resultado);
			System.out.println(resultado);		
		}
	}
	
}

class Fibonacci{
	int inicial = 0;
	int fibonacci(int resultado) {
		int guarda = resultado;
		resultado += this.inicial;
		this.inicial = guarda;
		return resultado;
	}
	
}