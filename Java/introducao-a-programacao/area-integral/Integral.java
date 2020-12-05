// Classe que foi alterada
class Integral {
	/*
		Retorna a area sob a curva definida pela funcao f, entre os pontos
		a e b, pela regra dos trapezios, aproximando a curva por n trapezios.
	*/
	
	static double resolve(Funcao f, double a, double b, int n) {

		//Retorna caso seja recebido um valor invalido de trapezios
		if (n <= 0) return -1;
		
		//Altura de cada trapezio (ultimo 'x' - primeiro 'x' dividos pelo numero de trapezios) 
		final double altura = (b - a) / n;
		
		double areaIntegral = 0;
		
		double somatorio = 0;
		
		//Armazena o valor dos x's, comeca pelo x(0) = a e vai incrementando no loop
		double x = a;
		
		/*
			O loop do somatorio inicia no segundo x (a + altura) e vai ate o 
			penultimo x (a + n * altura)
		*/
		for (int i = 1; i <= n - 1; i++){
			
			//Cada valor de x recebe o valor anterior da variavel mais uma altura, sendo a altura constante
			x += altura;
			
			
			// Aplica-se o metodo 'valor' da classe Funcao em cada x do loop, representando alguma funcao
			somatorio += f.valor(x);
		}
		
		
		//Equacao final
		areaIntegral = (altura / 2) * ( (f.valor(a) + f.valor(b)) + (2 * somatorio) );
		
		return areaIntegral;
	}
}
