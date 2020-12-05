import ep2.*;

/**
	Classe dada para testar os algoritmos implementados em MetodosGulosos.java
	MetodosGulosos.java deve ser modificada pelo aluno
*/
public class ExecutaGuloso {

	public static void main(String[] args) {
		Objeto[] listaDeObjetos = new Objeto[100];
		
		for(int i=0; i<listaDeObjetos.length; i++){
			int a = (int)(Math.random()*10);
			if(a==0) a=20;
			listaDeObjetos[i] = new Objeto(a, (int)(Math.random()*10));
		}
		
		
		System.out.println("Testando Criterio de Selecao: 'Menor Peso'");
		Mochila mochila = MetodosGulosos.utilizaMenorPeso(50, listaDeObjetos);
		mochila.imprimirDados();
		
		
		listaDeObjetos = new Objeto[7];
		listaDeObjetos[0] = new Objeto(7,7);
		listaDeObjetos[1] = new Objeto(4,6);
		listaDeObjetos[2] = new Objeto(3,6);
		listaDeObjetos[3] = new Objeto(2,3);
		listaDeObjetos[4] = new Objeto(2,4);
		listaDeObjetos[5] = new Objeto(1,1);
		listaDeObjetos[6] = new Objeto(2,1);
		
		
		System.out.println();
		System.out.println("Testando Criterio de Selecao: 'Maior Valor'");
		mochila = MetodosGulosos.utilizaMaiorValor(9, listaDeObjetos);
		mochila.imprimirDados();
		
		listaDeObjetos = new Objeto[7];
		listaDeObjetos[0] = new Objeto(7,7);
		listaDeObjetos[1] = new Objeto(4,6);
		listaDeObjetos[2] = new Objeto(3,6);
		listaDeObjetos[3] = new Objeto(2,3);
		listaDeObjetos[4] = new Objeto(2,4);
		listaDeObjetos[5] = new Objeto(1,1);
		listaDeObjetos[6] = new Objeto(2,1);
		
		System.out.println();
		System.out.println("Testando Criterio de Selecao: 'Maior Valor Dividido pelo Peso'");
		mochila = MetodosGulosos.utilizaMaiorValorDivididoPorPeso(9, listaDeObjetos);
		mochila.imprimirDados();
		
		
	}
}
