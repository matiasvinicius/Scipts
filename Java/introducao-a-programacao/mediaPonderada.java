/*
Escreva um método que receba como parâmetro um arranjo de n números xi e um
arranjo de n pesos pi, calculando ent~ao sua média ponderada:
*/

import java.util.Scanner;

class MediaPonderada{
	
	static int qtdCasos(Scanner scan){
		System.out.print("Digite a quantidade de números que deseja adicionar:");
		return scan.nextInt();
	}
	
	static double[] armazenaNumeros(Scanner scan, int qtdCasos){
		double[] x = new double[qtdCasos];
		
		for(int i = 0; i < qtdCasos; i++){
			System.out.print((i+1) + "° valor: ");
			x[i] = scan.nextInt();
		}
		
		return x;
	}
	
	static double[] armazenaPesos(Scanner scan, int qtdCasos){
		double[] p = new double[qtdCasos];
		
		for(int i = 0; i < qtdCasos; i++){
			System.out.print((i+1) + "° peso: ");
			p[i] = scan.nextInt();
		}
		
		return p;
	}
	
	static double calculaMedia (double[] n, double[] p){
		double med=0;
		double deno=0;
		double nume=0;
		
		for (int i = 0;  i < n.length; i++){
			nume += n[i] * p[i];
			deno += p[i];
		}	
		
		med = nume / deno;
			
		return med;
	}
	
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		
		int numeroDeCasos = qtdCasos(entrada);

		double[] numeros = armazenaNumeros(entrada, numeroDeCasos);
		double[] pesos = armazenaPesos(entrada, numeroDeCasos);
		
		System.out.println("Média: "+calculaMedia(numeros,pesos));
	}
}