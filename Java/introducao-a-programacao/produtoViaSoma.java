/*
Suponha que seu computador consiga executar somente opera��es de soma e subtra��o.
Escreva m�todos que calculem, para dois n�meros inteiros positivos a e b, passados em
seus par�metros
O produto de a X b
*/

class Operacoes{
	
	static void calcularProduto(int a, int b){
		int prod = 0;
		
		for (int i = 0; i < b; i++){
			prod += a;
		}
		
		System.out.println(prod);
	}
		
	public static void main (String[] args){
		calcularProduto(9,10);
	}
}