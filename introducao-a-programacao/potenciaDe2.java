/*
Escreva um m�todo que verifique se um n�mero inteiro positivo � pot�ncia de 2. Em caso
afirmativo, o m�rtodo deve fornecer o valor da pot�ncia. No programa principal devem
ser lidos v�rios n�meros at� que o usu�rio indique que n~ao deseja repetir a verifica��o
para nenhum outro n�mero.
*/

import java.util.Scanner;

class Pot{
	
	static int verificaPot2(int n){
		for(int i = 1; Math.pow(2, i) <= n; i++){
			if (Math.pow(2, i) == n) return i;
		}
		return -1;
	}
	
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		String numeroString = null;
		double pot = 0;
		String continuarString = null;
		int continuar = 1;
		
		while (continuar == 1){
			
			System.out.println("Digite um n�mero para a verifica��o");
			numeroString = entrada.nextLine();
			pot = verificaPot2(Integer.parseInt(numeroString));
			
			System.out.println("----------");
			if (pot == -1) System.out.println("N�o � pot�ncia de 2");
			else System.out.println("Potencia: "+pot);
				
			System.out.println("Deseja continuar?\n0 -> N�o\n1 -> Sim");
			continuarString = entrada.nextLine();
			continuar = Integer.parseInt(continuarString);
		}
	}
}