/*
Escreva um método que receba por parâmetro um inteiro positivo M >= 1 e calcule seu
cubo, somando os M ímpares consecutivos a partir de M * (M - 1) + 1. Por exemplo,
para M = 5,
M * (M - 1) + 1 = 5 * 4 + 1 = 21
M^3 = 21 + 23 + 25 + 27 + 29 = 125
*/

class Calculo{
	
	static int calculaCubo(int m){
		int cubo = 0;
		int imparAtual = m * (m - 1) + 1; //primeiro impar
		int cont = 1;
		
		//realiza o loop m vezes
		while(cont <= m){
			cubo += imparAtual;
			imparAtual += 2;
			cont++;
		}
		
		return cubo;
	}
	
	public static void main(String[] args){
		System.out.println(calculaCubo(100));
	}
}