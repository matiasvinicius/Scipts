/*
Escreva um programa que leia primeiramente um valor n >= 0 do usuário e, a seguir, três
números por linha, nas n linhas que se seguem. Para cada grupo de três caracteres o
programa deve informar se o grupo está com três números iguais, ordenados em ordem
crescente, ordenados em ordem decrescente ou desordenados
*/

import java.util.Scanner;

class Linhas{
	public static void main(String[] args){
		int[] car = new int[3];
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o numero de linhas");
		String n = entrada.nextLine();
		int num = Integer.parseInt(n);

		for (int i = 1; i <= num; i++){
			for (int j = 0; j <= 2; j++){
				System.out.println("Digite o numero "+ (j+1) +" da linha "+ i);
				String m = entrada.nextLine();
				car[j] = Integer.parseInt(m);
			}
			
			//verifica as únicas condições possíveis
			if (car[0] == car[1] && car[1] == car[2]) System.out.println("Caracteres iguais");
			else if (car[0] < car[1] && car[1] < car[2]) System.out.println("Ordem Crescente");
			else if (car[0] > car[1] && car[1] > car[2]) System.out.println("Ordem Decrescente");
			else System.out.println("Desordenados");
		}
	}
}