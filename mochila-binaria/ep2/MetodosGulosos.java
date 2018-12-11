package ep2;

//Deve se executar a classe ExecutaGulosos
public abstract class MetodosGulosos {
	
	//Método merge que é usado no mergeSort, com adição da variavel tipo que identifica o problema
	static void merge(Objeto[] A, int p, int q, int r, int tipo) {
		int tamseq1 = q - p + 1;
		int tamseq2 = r - q;
		Objeto [] seq1 = new Objeto [tamseq1];
		for(int i=0; i < seq1.length; i++) seq1[i] = A[p+i];
		Objeto [] seq2 = new Objeto [tamseq2];
		for(int j=0; j < seq2.length; j++) seq2[j] = A[q+1+j];
	
		int k = p; 
		int i = 0; 
		int j = 0;
		
		//Ordenar pelo menor peso
		if(tipo==1){
			while (i < seq1.length && j < seq2.length) {
				if(seq2[j].getPeso() < seq1[i].getPeso() || (seq2[j].getPeso() == seq1[i].getPeso() && seq2[j].getValor() > seq1[i].getValor())) {
					A[k] = seq2[j];
					j++;
				}
				else {
					A[k] = seq1[i];
					i++;
				}
				k++;
			}
		}
		
		//Ordenar pelo maior valor
		else if(tipo==2){
			while (i < seq1.length && j < seq2.length) {
				if(seq2[j].getValor() > seq1[i].getValor() || (seq2[j].getValor() == seq1[i].getValor() && seq2[j].getPeso() < seq1[i].getPeso())) {
					A[k] = seq2[j];
					j++;
				}
				else {
					A[k] = seq1[i];
					i++;
				}
				k++;	
			}
		}
		
		//Ordenar pelo maior valor dividido pelo peso
		else if(tipo==3){			
			while (i < seq1.length && j < seq2.length) {
				if((seq2[j].getValor()/seq2[j].getPeso()) > (seq1[i].getValor()/seq1[i].getPeso()) || ((seq2[j].getValor()/seq2[j].getPeso()) == (seq1[i].getValor()/seq1[i].getPeso()) && seq2[j].getPeso() > seq1[i].getPeso()) ) {
					A[k] = seq2[j];
					j++;
				}
				else {
					A[k] = seq1[i];
					i++;
				}
				k++;
			}
		}
		
		while (i < seq1.length) {
			A[k] = seq1[i];
			k++;
			i++;
		}
		while (j < seq2.length) {
			A[k] = seq2[j];
			k++;
			j++;
		}
	}
	
	//divide em problemas menores, trata-os e une-os
	static void mergeSort(Objeto[] A, int ini, int fim, int tipo) {
		if(ini < fim) {
			int meio = (ini + fim)/2;
			mergeSort(A, ini, meio, tipo);
			mergeSort(A, meio+1, fim, tipo);
			merge(A, ini, meio, fim, tipo);
		}
	}//O(nlogn)
	
	
	//Método que se comunica com a mochila e modifica as variáveis dessa classe
	static void abasteceMochila(Mochila mochila, Objeto[] listaDeObjetosDisponiveis){
		for(int i=0; i<listaDeObjetosDisponiveis.length; i++){
			if(listaDeObjetosDisponiveis[i].getPeso() <= mochila.getPesoMaximo() - mochila.getPesoUsado()){
				mochila.setNumObjetosNaMochila(mochila.getNumObjetosNaMochila() + 1);
				mochila.setPesoUsado(mochila.getPesoUsado() + listaDeObjetosDisponiveis[i].getPeso());
				mochila.setValorDentroDaMochila(mochila.getValorDentroDaMochila() + listaDeObjetosDisponiveis[i].getValor());
			}
		}
	}
	
	//Problema tipo 1
	public static Mochila utilizaMenorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);
				
		mergeSort(listaDeObjetosDisponiveis, 0, listaDeObjetosDisponiveis.length-1, 1);
		
		abasteceMochila(mochila, listaDeObjetosDisponiveis);
			
		return mochila;
	}
	
	//Problema tipo 2
	public static Mochila utilizaMaiorValor(double pesoMaximoDaMochila,	Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);
		
		mergeSort(listaDeObjetosDisponiveis, 0, listaDeObjetosDisponiveis.length-1, 2);
		
		abasteceMochila(mochila, listaDeObjetosDisponiveis);

		return mochila;
	}

	//Problema tipo 3
	public static Mochila utilizaMaiorValorDivididoPorPeso(double pesoMaximoDaMochila, Objeto[] listaDeObjetosDisponiveis) {
		Mochila mochila = new Mochila(pesoMaximoDaMochila);

		mergeSort(listaDeObjetosDisponiveis, 0, listaDeObjetosDisponiveis.length-1, 3);
		
		abasteceMochila(mochila, listaDeObjetosDisponiveis);

		return mochila;
	}
}
