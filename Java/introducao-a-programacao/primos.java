/*
Escreva um m�todo que receba como par�metro um inteiro positivo e verifique se esse
n�mero � primo
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
	
		if (primo) System.out.println("� Primo");
		else System.out.println("N�o � primo");
	}
	
	public static void main (String[] args){
		int num = 18;
		if(num > 0)	ehPrimo(num);
		else System.out.println(num + " n�o � um n�mero positivo");
	}
}