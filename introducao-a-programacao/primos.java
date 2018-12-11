/*
Escreva um método que receba como parâmetro um inteiro positivo e verifique se esse
número é primo
*/

class Primos{
	static void ehPrimo(int n){
		boolean primo = true;
	
		for (int i = 2; i < n; i++){
			if(n % i==0){
				primo = false;
				break;
			}
		}
	
		if (primo) System.out.println("É Primo");
		else System.out.println("Não é primo");
	}
	
	public static void main (String[] args){
		int num = 18;
		if(num > 0)	ehPrimo(num);
		else System.out.println(num + " não é um número positivo");
	}
}