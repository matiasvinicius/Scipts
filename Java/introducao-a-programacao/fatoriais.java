class Fatorial{
	
	static void calcularFatorial(int n){
		System.out.print(n + "! = ");
		
		int fatorialAtual = 1;
		
		while (n > 0){
			fatorialAtual *= n;
			n--;
		}
		System.out.print(fatorialAtual + "\n");
	}

	public static void main (String[] args){
		calcularFatorial(5);
	}
}