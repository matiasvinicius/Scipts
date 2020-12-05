class Funcao {
	/*
		Retorna o valor da função representada por essa classe em
		um ponto específico.
		
		A função aqui implementada é y = raiz(1-x^2) -> uma circunferência
		de raio 1, centrada em (0,0), mas qualquer outra pode ser implementada
		para testes, substituindo esta que aqui está.
	*/
	double valor(double ponto) {
		return(Math.sqrt(1-ponto*ponto));
	}
}
