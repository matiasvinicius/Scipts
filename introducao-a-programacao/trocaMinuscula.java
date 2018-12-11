/*
Escreva um programa que leia uma string digitada pelo usuário e coloque todas as
primeiras letras de cada palavra nesse string em maiuscula. Assim, se a entrada for \a
casa azul" a saída será A Casa Azul".
*/

import java.util.Scanner;

class Maiuscula{
	
	//Vetor com as letras do alfabeto
	static char chrVetor[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
	'R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n',
	'o','p','q','r','s','t','u','v','w','x','y','z'};
	
	static String colocaMaiusculas(String s){
		String strMaiusculas = null;
		char[] parametroChar = s.toCharArray();
		
		//econtra o a letra do do primeiro caractere e seu correspondente maiusculo
		for(int p = 26; p < chrVetor.length; p++){					
			if(chrVetor[p] == parametroChar[0]){
				parametroChar[0] = chrVetor[p - 26];
				p = 70;
			}
		}		
		
		//Encontra o correspondente maiusculo de toda letra após um espaço
		for(int i = 1; i < parametroChar.length; i++){
			if(parametroChar[i] == ' '){
				for(int p = 26; p < chrVetor.length; p++){					
					if(chrVetor[p] == parametroChar[i + 1]){
						parametroChar[i+1] = chrVetor[p - 26];
						i++;
						p = 70;
					}
				}
			}
		}
		
		strMaiusculas = String.copyValueOf(parametroChar);
		
		return strMaiusculas;
	}

	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Frase: ");
		String s = entrada.nextLine();
		System.out.println("------------------");
		System.out.print("Frase: "+ colocaMaiusculas(s));
	}
}