import java.util.Scanner;

class Matriz {

	//Define o tabuleiro a ser usado no jogo
	static char[][] defineMatriz() {
		char[][] tabuleiro = new char[3][3];
		
		//Coloca o caractere ' ' em todas as posições da matriz
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 2; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
		
		return tabuleiro;
	}
	
	//Imprime todo o tabueleiro
	static void imprimeTabuleiroAtual(char[][] tabuleiro) {
		System.out.println(tabuleiro[0][0] + "|" + tabuleiro[0][1] + "|" + tabuleiro[0][2]);
		System.out.println("_____");
		System.out.println(tabuleiro[1][0] + "|" + tabuleiro[1][1] + "|" + tabuleiro[1][2]);
		System.out.println("_____");
		System.out.println(tabuleiro[2][0] + "|" + tabuleiro[2][1] + "|" + tabuleiro[2][2]);		
	}
	
	
	//verifica se completou uma linha
	static boolean completouLinha(char[][] tabuleiro, int linha, char jogadorAtual) {
		if(tabuleiro[linha][0] != jogadorAtual) return false;
		if(tabuleiro[linha][1] != jogadorAtual) return false;
		if(tabuleiro[linha][2] != jogadorAtual) return false;
		return true;
	}
	
	//verifica se completou uma coluna
	static boolean completouColuna(char[][] tabuleiro, int coluna, char jogadorAtual) {
		if(tabuleiro[0][coluna] != jogadorAtual) return false;
		if(tabuleiro[1][coluna] != jogadorAtual) return false;
		if(tabuleiro[2][coluna] != jogadorAtual) return false;
		return true;
	}	

	//verifica se completou uma diagonal
	static boolean completouDiagonal(char[][] tabuleiro, char jogadorAtual) {
		if(tabuleiro[1][1] != jogadorAtual) return false;
		
		if(tabuleiro[0][0] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) return true;
		if(tabuleiro[2][0] == jogadorAtual && tabuleiro[0][2] == jogadorAtual) return true;
		
		return false;
	}	
	
	
	static void rodaJogo(char[][] tabuleiro, Scanner scan) {
		int linhaAdicionar = -1;
		int colunaAdicionar = -1;
		char jogadorAtual = 'X';	
		boolean temVencedor = false;
		for(int rodadaAtual = 1; rodadaAtual <= 9; rodadaAtual++) {
			
			//Recebe a linha e a coluna da matriz onde vai ser adicionada a marca
			do {
				System.out.println("Jogador atual: " + jogadorAtual);
				imprimeTabuleiroAtual(tabuleiro);
				
				System.out.print("Digite a linha:");
				linhaAdicionar = scan.nextInt();
				
				System.out.print("Digite a coluna:");
				colunaAdicionar = scan.nextInt();
			}while(linhaAdicionar >= 3 || colunaAdicionar >= 3 || tabuleiro[linhaAdicionar][colunaAdicionar] != ' ');
			
			
			//Adiciona X ou O no tabuleiro
			tabuleiro[linhaAdicionar][colunaAdicionar] = jogadorAtual;

			
			if(completouLinha(tabuleiro, linhaAdicionar, jogadorAtual)) {
				temVencedor = true;
				break;
			}
			
			if(completouColuna(tabuleiro, colunaAdicionar, jogadorAtual)) {
				temVencedor = true;
				break;
			}
			
			if(completouDiagonal(tabuleiro, jogadorAtual)) {
				temVencedor = true;
				break;
			}
			
			//Troca o jogador pro próximo turno
			if(jogadorAtual == 'X') jogadorAtual = 'O';
			else jogadorAtual = 'X';
		}
		
		imprimeTabuleiroAtual(tabuleiro);
		if(temVencedor) System.out.println("Jogador " + jogadorAtual + " ganhou");
		else System.out.println("Velha");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int repetirJogo = 1; //enquanto for == 1 repete o jogo
		char[][] tabuleiro = defineMatriz();
		
		while(repetirJogo == 1) {
			rodaJogo(tabuleiro, scan);
			System.out.print("--------- \nDeseja continuar? \n1 para continuar \n2 para parar: ");
			repetirJogo = scan.nextInt();
			if(repetirJogo == 1) {
				tabuleiro = defineMatriz();
			}
		}
	}
}
