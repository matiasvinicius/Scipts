/*
Escreva um programa (classe com main) que descubra um numero imaginado pelo
usuario entre 0 e n > 0. Para cada valor sugerido pelo programa como sendo o valor
imaginado pelo usuario, o usuario deve responder (honestamente) se o valor sugerido
pelo programa é igual, menor ou maior do que o valor imaginado. A execucao do programa
deve terminar assim que o programa "adivinhar"o valor imaginado pelo usuario.
(Dica: observe que isso pode ser resolvido com uma busca binaria num arranjo de n+1
elementos, de 0 a n).
*/


import java.util.Scanner;

class Descobre{

	static void interacao(Scanner entrada){
		int continua=0;
		String continuaS;
		System.out.println("Seu número deve estar entre 0 e 1000000");		
		
		//Cria o arranjo com n+1 posicoes e coloca os valores de 0 a 1000000 nele
		int[] numeros = new int[1000001];
		for(int i=0; i<numeros.length; i++){
			numeros[i] = i;
		}
		
		int fim = numeros.length;
		int ini = numeros[0];
		int meio = (fim+ini)/2;
		
		while (continua==0 || continua==1){			
			System.out.println("Digite \n0 se seu número for menor que "+ numeros[meio]);
			System.out.println("1 se seu número for maior que "+ numeros[meio]);
			System.out.println("2 se seu número for "+ numeros[meio]);
			
			continuaS = entrada.nextLine();
			continua = Integer.parseInt(continuaS);
						
			if (continua==0) fim = numeros[meio];
			if (continua==1) ini = numeros[meio];
			meio = (fim+ini)/2;
		}		
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		interacao(scan);
	}
}