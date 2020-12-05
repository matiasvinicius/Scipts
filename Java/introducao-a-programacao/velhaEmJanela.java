import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

class JogoEmJanela extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	//Variáveis globais utilizadas na programação
	private static String jogadorAtual = "X"; //X ou O
	private String[][] botoes = new String[3][3]; //captura o texto de cada um dos botões
	private boolean alguemVenceu = false;
	private static int rodadaAtual = 0;
	
	private void marcaPosicao(JButton botaoClicado) {
		if(botaoClicado.getText() == "") {
			botaoClicado.setText(jogadorAtual);
			rodadaAtual++;
		}
	}
	
	private boolean marcouLinha(){
		for(int linha = 0; linha <=2; linha++) {
				if(botoes[linha][0] == jogadorAtual && botoes[linha][0] == botoes[linha][1] && botoes[linha][1] == botoes[linha][2]) return true;
		}
		return false;
	}
	
	private boolean marcouColuna(){
		for(int coluna = 0; coluna <=2; coluna++) {
			if(botoes[0][coluna] == jogadorAtual && botoes[0][coluna] == botoes[1][coluna] && botoes[1][coluna] == botoes[2][coluna]) return true;
		}
	return false;
	}	

	private boolean marcouDiagonal(){
		if(botoes[0][0] == jogadorAtual && botoes[0][0] == botoes[1][1] && botoes[1][1] == botoes[2][2]) return true;
		if(botoes[0][2] == jogadorAtual && botoes[0][2] == botoes[1][1] && botoes[1][1] == botoes[2][0]) return true;
		return false;
	}	
	
	private boolean ganhou() {
		if(marcouLinha() || marcouColuna() || marcouDiagonal()) {
			alguemVenceu = true;
			return true;
		}
		return false;
	}	
	
	private static void imprimirSituacao(JLabel labelSituacao, boolean ganhou) {
		if(ganhou) labelSituacao.setText("Jogador " + jogadorAtual + " ganhou");
		else if(rodadaAtual >= 9) labelSituacao.setText("Velha");
		else {
			if(jogadorAtual == "X") jogadorAtual = "O";
			else jogadorAtual = "X";
			labelSituacao.setText("Vez do jogador " + jogadorAtual);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoEmJanela frame = new JogoEmJanela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JogoEmJanela() {
		//Janela
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Label que informa como está o jogo
		JLabel lblSituacao = new JLabel("Vez do Jogador X");
		lblSituacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSituacao.setBounds(10, 284, 260, 31);
		contentPane.add(lblSituacao);		
		
		//Botões (9 no total)
		JButton btnLinha1Coluna1 = new JButton("");
		btnLinha1Coluna1.addActionListener(new ActionListener() {
			//Acionado no clique
			public void actionPerformed(ActionEvent e) {
				if(!alguemVenceu && btnLinha1Coluna1.getText()=="") {
					marcaPosicao(btnLinha1Coluna1);
					botoes[0][0] = btnLinha1Coluna1.getText();
					imprimirSituacao(lblSituacao, ganhou());
				}
			}
		});
		btnLinha1Coluna1.setFont(new Font("Tahoma", Font.PLAIN, 30));		
		btnLinha1Coluna1.setBounds(10, 11, 80, 80);
		contentPane.add(btnLinha1Coluna1);
		
		
		JButton btnLinha1Coluna2 = new JButton("");
		btnLinha1Coluna2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alguemVenceu && btnLinha1Coluna2.getText()=="") {
					marcaPosicao(btnLinha1Coluna2);
					botoes[0][1] = btnLinha1Coluna2.getText();
					imprimirSituacao(lblSituacao, ganhou());
				}
			}
		});
		btnLinha1Coluna2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLinha1Coluna2.setBounds(100, 11, 80, 80);
		contentPane.add(btnLinha1Coluna2);
		
		JButton btnLinha1Coluna3 = new JButton("");
		btnLinha1Coluna3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alguemVenceu && btnLinha1Coluna3.getText()=="") {
					marcaPosicao(btnLinha1Coluna3);
					botoes[0][2] = btnLinha1Coluna3.getText();
					imprimirSituacao(lblSituacao, ganhou());
				}
			}
		});
		btnLinha1Coluna3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLinha1Coluna3.setBounds(190, 11, 80, 80);
		contentPane.add(btnLinha1Coluna3);
		
		JButton btnLinha2Coluna1 = new JButton("");
		btnLinha2Coluna1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alguemVenceu && btnLinha2Coluna1.getText()=="") {
					marcaPosicao(btnLinha2Coluna1);
					botoes[1][0] = btnLinha2Coluna1.getText();
					imprimirSituacao(lblSituacao, ganhou());
				}
			}
		});
		btnLinha2Coluna1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLinha2Coluna1.setBounds(10, 102, 80, 80);
		contentPane.add(btnLinha2Coluna1);
		
		JButton btnLinha2Coluna2 = new JButton("");
		btnLinha2Coluna2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alguemVenceu && btnLinha2Coluna2.getText()=="") {
					marcaPosicao(btnLinha2Coluna2);
					botoes[1][1] = btnLinha2Coluna2.getText();
					imprimirSituacao(lblSituacao, ganhou());
				}
			}
		});
		btnLinha2Coluna2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLinha2Coluna2.setBounds(100, 102, 80, 80);
		contentPane.add(btnLinha2Coluna2);
		
		JButton btnLinha2Coluna3 = new JButton("");
		btnLinha2Coluna3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alguemVenceu && btnLinha2Coluna3.getText()=="") {
					marcaPosicao(btnLinha2Coluna3);
					botoes[1][2] = btnLinha2Coluna3.getText();
					imprimirSituacao(lblSituacao, ganhou());
				}
			}
		});
		btnLinha2Coluna3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLinha2Coluna3.setBounds(190, 102, 80, 80);
		contentPane.add(btnLinha2Coluna3);
		
		JButton btnLinha3Coluna1 = new JButton("");
		btnLinha3Coluna1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alguemVenceu && btnLinha3Coluna1.getText()=="") {
					marcaPosicao(btnLinha3Coluna1);
					botoes[2][0] = btnLinha3Coluna1.getText();
					imprimirSituacao(lblSituacao, ganhou());
				}
			}
		});
		btnLinha3Coluna1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLinha3Coluna1.setBounds(10, 193, 80, 80);
		contentPane.add(btnLinha3Coluna1);
		
		JButton btnLinha3Coluna2 = new JButton("");
		btnLinha3Coluna2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alguemVenceu && btnLinha3Coluna2.getText()=="") {
					marcaPosicao(btnLinha3Coluna2);
					botoes[2][1] = btnLinha3Coluna2.getText();
					imprimirSituacao(lblSituacao, ganhou());
				}
			}
		});
		btnLinha3Coluna2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLinha3Coluna2.setBounds(100, 193, 80, 80);
		contentPane.add(btnLinha3Coluna2);
		
		JButton btnLinha3Coluna3 = new JButton("");
		btnLinha3Coluna3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alguemVenceu && btnLinha3Coluna3.getText()=="") {
					marcaPosicao(btnLinha3Coluna3);
					botoes[2][2] = btnLinha3Coluna3.getText();
					imprimirSituacao(lblSituacao, ganhou());
				}
			}
		});
		btnLinha3Coluna3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLinha3Coluna3.setBounds(190, 193, 80, 80);
		contentPane.add(btnLinha3Coluna3);
	}
}