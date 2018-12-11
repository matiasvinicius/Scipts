//Faça um método que receba um string como parâmetro e o inverta.

class Inversao{
	
	String inverte(String s){
		char[] str = s.toCharArray();
		int n = str.length;
		char[] inv = new char[n]; //Armazena as letras invertidas da string de parametro
		
		for (int i=0; i<n; i++){
			// Cada posicao de inv recebera o valor localizado na posicao n-1(ultimo valor com algo em str) menos a posicao do contador
			inv[i] = str[n-1-i];
		}
		
		String palavra = String.copyValueOf(inv); //Transforma um char[] em String

		return palavra;
	}
	
	public static void main(String[] args){
		Inversao i = new Inversao();
		String s  = "Hello World";
		
		System.out.println(i.inverte(s));
	}
}