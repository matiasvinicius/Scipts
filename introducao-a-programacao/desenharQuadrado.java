/*
Escreva um m�todo que desenhe um quadrado de "*"de n X m (n linhas X m colunas),
n e m par�metros do m�todo.
*/
class Asteriscos{
	
	static void desenharQuadrado(int n, int m){
		int qtdAtual = 0;
		int qtdAsteriscos = n * m;
		
		while (qtdAtual < qtdAsteriscos){
			System.out.print("*");
			qtdAtual++;
			if (qtdAtual % m == 0) System.out.println();
		}
	}	
	
	public static void main (String[]args){
		desenhaQuadrado(10,30);
	}
}