/*
Suponha que seu computador consiga executar somente operações de soma e subtração.
Escreva métodos que calculem, para dois números inteiros positivos a e b, passados em
seus parâmetros
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