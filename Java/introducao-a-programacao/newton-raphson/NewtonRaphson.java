class NewtonRaphson {
	
	/*
		O programa serve para calcular os juros mensais que devem ser aplicados em uma quantidade
		 especifica de depositos e em determinados meses para gerar um montante que sera informado
		 na ultima posicao do arranjo depositos.
		Para os calculos sera utilizado o metodo de newton raphson que serve para calcular o zero da funcao, ou seja,
		 com que  valor de juros devera ser aplicados nos depositos para aproximar-se do valor saldo.
	*/
	
	//Depositos realizados, com saldo final
	static double[] depositos;
	
	//Datas correspondentes aos depositos feitos e saldo final
	static int[] datas;
	
		
	//Metodo que retorna o valor da funcao f(j) para um valor j (juros), sendo aplicado no metodo de Newton-Raphson
	static double funcao (double j){
		
		double resultado = 0;
		
		/* 
		  O 'for' realiza a soma das funcoes de acordo com metodo de Newton-Raphson e armazena na variavel resultado
		  Lembra-se que o ultimo valor de data deve ser o mes em que foi verificado o saldo, portanto, esta fora da conta
		*/
		for (int i=0; i<depositos.length-1; i++){
			resultado += depositos[i] * Math.pow( (1+j) , datas[datas.length-1] - datas[i]);
		}
		
		resultado -= depositos[depositos.length-1];
		
		return resultado;
	}
		
	/*
	   Metodo que calcula a funcao derivada de f(j)
	   Assim como o metodo funcao, os ultimos valores do arranjo estao fora do resultado final
	    por serem o saldo (que nao precisa ser subtraido) e o mes que eh verificado o saldo
	*/	
	static double derivada (double j){
		double resultado=0;
		
		for (int i=0; i<depositos.length-1; i++){
			resultado += (datas[datas.length-1] - datas[i]) *depositos[i] *Math.pow( (1+j), (datas[datas.length-1] - datas[i] - 1));
		}
		
		return resultado;
	}
	
	static double modulo(double n){
		if (n < 0) return n - 2 * n;	
		else return n;
	}	
	
	static double newton(double epsilon) {	
	    
		double[] j = new double[2]; //Arranjo que armazenara as mudancas entre os juros ate o resultado correto
		
		j[0] = 0.5; //Palpite inicial para os juros, valor que pode variar entre 0 e 1
		
		j[1] = 0; //Intermedia o loop
		
		double condicao = j[1] - j[0]; //Condicao para realizar o loop do Newton Raphson
		
		double relacaoFuncoes = 0; //Armazena o valor da divisao entre a funcao f(j) e a funcao derivada f'(j)
		
		//Verifica se o epsilon e viavel
		if (epsilon <= 0 || epsilon >= 1) return -1;

		while(modulo(condicao) >= epsilon) {
			
			relacaoFuncoes = ( funcao(j[0]) / derivada(j[0]) );
			
			/*
				A variavel j[1] susbstitui seu valor anterior pelos 
				 juros atuais subtraidos da divisao das funcoes
			*/
			j[1] = j[0] - relacaoFuncoes;
			
    		condicao = j[1] - j[0];
			
			//O j[0]  sera igualado ao j[1] para o proximo loop, sem interferir na condicao
    		j[0] = j[1];
			
		}
		
		return j[0];
	}
	
	public static void main(String[] args) {		
		
		/*exemplo de uso para o teste:
		4 depositos, nos meses 1, 3, 5 e 6, com valores de 2000, 123.5, 358.5 e 23
		o 3500.68 e o saldo no mes 10
		*/
		depositos = new double[5];
		depositos[0] = 2000;
		depositos[1] = 123.5;
		depositos[2] = 358.5;
		depositos[3] = 23;
		depositos[4] = 3500.68;
		
		datas = new int[5];
		datas[0] = 1;
		datas[1] = 3;
		datas[2] = 5;
		datas[3] = 6;
		datas[4] = 10;
		
    	System.out.println(newton(0.001));
	}
}
