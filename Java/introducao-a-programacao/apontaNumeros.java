/*
Escrever um programa que aponte para os dígitos (se existirem) em uma linha de texto
fornecida pelo usuário. Isto é, o programa deve gerar uma linha logo abaixo da linha
fornecida pelo usuário que, em cada posição equivalente a um dígito na linha original,
tenha um caractere `^' e um espaço nas demais. Exemplo:
Mariazinha comprou 3 goiabas, 1 melancia e 15 bananas na feira.
                   ^          ^            ^^                  
*/

import java.util.Scanner;

class Aponta{
	
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite sua frase");
		String s  = entrada.nextLine();
		
		char[] str = s.toCharArray();
		char[] apontadores = new char[str.length];

		//Verifica se o determinado valor do char[] é um inteiro e coloca um '^' no 'apontadores'
		for(int i=0; i<str.length; i++){
			if(Character.isDigit(str[i])) apontadores[i] = '^';
		}
		
		String aponta = String.copyValueOf(apontadores); //Transforma um char[] em um única String
		System.out.println(aponta);
	}
}
/*
	Código para substituir o copyValueOf
	for (int i=0; i<apontadores.length; i++){
		System.out.print(apontadores[i]);
	}
*/