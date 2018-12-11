/*Defina uma classe IntervaloDeTempo cujos objetos representam um intervalo de tempo
em número de horas, minutos e segundos. O construtor de objetos dessa classe deve
receber como argumento um número inteiro positivo, representando o número de segundos
decorridos desde o instante inicial 00:00:00 horas e retornar um objeto da classe
IntervaloDeTempo correspondente.
Por exemplo, a expressão new IntervaloDeTempo(3500) deve retornar um objeto que
represente 0 horas, 58 minutos e 20 segundos. Crie também uma classe para testar a
classe definida*/

class IntervaloDeTempo{
	
	/*
		Como os dois atributos da classe sao utlizados recorrentemente no codigo, mantive-os como static
		O arranjo 'horario' vai armazenar as horas(posicao 0), os minutos(posicao 1) e os segundos(posicao 2)
		'arg' vai conter o argumento que e utilizado como parametro no construtor (a quantidade de segundos)
	*/
	static int[] horario = new int[3];
	static int arg = 0;
	
	/*
		Construtor da Classe IntervaloDeTempo
		Armazena no atributo 'arg' o valor passado por parametro
		Como sao variaveis de mesmo nome, utliliza-se o 'this' para diferenciar uma da outra
	*/
	IntervaloDeTempo(int arg){
		this.arg = arg;
	}
	
	/*
		O metodo 'relogio' incrementa as horas enquanto o valor de 'arg' for maior que uma hora(3600 segundos)
		Na mesma logica, incrementa os minutos enquanto 'arg' for maior que um minuto (60 segundos)
		a posicao dos segundos recebe o resto de 'arg' e eh retornado o arranjo 'horario'
	*/
	
	int[] relogio(){
		while(arg>=3600){
			horario[0]++;
			arg -= 3600;
		}
		while(arg>=60){
			horario[1]++;
			arg -= 60;
		}

		horario[2]= arg;
		
		return horario;
	}
}

//Classe que executa
class Main{
	
	public static void main(String[] args){
		//Criacao do Objeto
		IntervaloDeTempo idt = new IntervaloDeTempo(3600);
		
		int[] horario = idt.relogio();

		System.out.print(horario[0] +":"+ horario[1]+":"+ horario[2]+"\n");
	}
}