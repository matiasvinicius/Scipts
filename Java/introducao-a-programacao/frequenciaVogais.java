import java.util.Scanner;

class FreqVogais{

	float calculaFreq(String s){
		char[] str = s.toCharArray();//String do parametro vira arranjo de caracteres
		char[] vogais = {'a','e','i','o','u','A','E','I','O','U'};//Arranjo de vogais
		float x = 0;//Variavel que armazena o numero de vogais
		
		/*
			Para cada caractere em 'str' sera verificado se ele e igual a uma vogal
			Se for igual, 'x' acrescenta 1
		*/
		for (int i=0; i<str.length; i++){
			for(int p=0; p<vogais.length; p++){
				if (str[i]==vogais[p]) x++;
			}
		}
		
		//Divide as vogais da String pelo numero total de caracteres e retorna o resultado
		return x/str.length;
	}

	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		System.out.print("Frase: ");
		String s = entrada.nextLine();
		
		FreqVogais f = new FreqVogais();
		System.out.println("Frequencia relativa de vogais: "+f.calculaFreq(s));
	}
}
