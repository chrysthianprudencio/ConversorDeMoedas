import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ConversorDeMoedas extends JFrame {
	 
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		static ConversorDeMoedas frame = new ConversorDeMoedas();
		

		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			boolean continua = true;
			do {
				String[] opcoes = {"Conversor de Moeda", "Conversor de Temperatura"};
				
				String n = (String)JOptionPane.showInputDialog(frame, "Escolha uma opçãoo:", "Menu", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
				if (n == null) {
					System.exit(0);
				}
				
				do {
					if(n.equals("Conversor de Temperatura")) {
						JOptionPane.showMessageDialog(frame, "Funcionalidade em construção", "Funcionalidade em construção", JOptionPane.ERROR_MESSAGE);
						continua = true;
		
						n = (String)JOptionPane.showInputDialog(frame, "Escolha uma opção:", "Menu", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
						if (n == null) {
							System.exit(0);
						}
					}
				} while(n.equals("Conversor de Temperatura"));
				System.out.println(n);
				
				ImageIcon imageIcon = new ImageIcon("src/img/money-icon.png");
				Image imagem = imageIcon.getImage();
				Image novaimagem = imagem.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(novaimagem);
				String[] opcoes2 = {"De Reais a Dolares", "De Reais a Euros", "De Reais a Libras", "De Reais a Yens", "De Reais a Won Coreano", "De Dolares a Reais", "De Euros a Reais", "De Libras a Reais", "De Yens a Reais", "De Won Coreano a Reais"};
				String p = (String)JOptionPane.showInputDialog(frame, "Escolha a moeda para a qual você deseja girar seu dinheiro:", "Menu", JOptionPane.QUESTION_MESSAGE, imageIcon, opcoes2, opcoes2[0]);
				if (p == null) {
					System.exit(0);
				}
				System.out.println(p);
				
				String input;
				double valor = 0;
				do {
					input = (JOptionPane.showInputDialog(frame, "Insira um valor:"));
					if (input == null) {
						System.exit(0);
					}
					if (input.matches("^[Z0-9]*$")) {
		                    valor = Float.parseFloat(input); 
		                    System.out.println("Valor:" + valor);
					} else {
							JOptionPane.showMessageDialog(frame, "Por favor, entre apenas com numeros positivos", "Por favor, entre apenas com n�meros positivos", JOptionPane.ERROR_MESSAGE);
							JOptionPane.showMessageDialog(frame, String.format("Conversão de reais para dolares: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
					}	
				} while (!input.matches("^[Z0-9]*$"));
				
				if(p.equals("De Reais a Dolares")) {
					reais_para_dolares(valor);
				} else if(p.equals("De Reais a Euros")) {
					reais_para_euros(valor);
				} else if(p.equals("De Reais a Libras")) {
					reais_para_libras(valor);
				} else if(p.equals("De Reais a Yens")) {
					reais_para_yens(valor);
				} else if(p.equals("De Reais a Won Coreano")) {
					reais_para_won_coreano(valor);
				} else if(p.equals("De D0lares a Reais")) {
					dolares_para_reais(valor);
				} else if(p.equals("De Euros a Reais")) {
					euros_para_reais(valor);
				} else if(p.equals("De Libras a Reais")) {
					libras_para_reais(valor);
				} else if(p.equals("De Yens a Reais")) {
					yens_para_reais(valor);
				} else if(p.equals("De Won Coreano a Reais")) {
					won_coreano_para_reais(valor);
				}
				
				int opcao = JOptionPane.showConfirmDialog(frame,
			             "Deseja continuar?", "Escolha uma opção:", JOptionPane.YES_NO_CANCEL_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					continua = true;
					System.out.println(continua);
				} else if (opcao == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(frame, "Programa finalizado");
					continua = false;
					System.out.println(continua);
					System.exit(0);
				} else if (opcao == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(frame, "Programa concluido");
					continua = false;
					System.out.println(continua);
					System.exit(0);
				}
			} while (continua = true);
		}
		public ConversorDeMoedas() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(200, 100, 500, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
		}	
		
		public static double reais_para_dolares(double valor) {
			double cotacao_dollar = 0.21;
			valor = valor * cotacao_dollar;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de reais para doláres: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
		
		public static double reais_para_euros(double valor) {
			double cotacao_euro = 0.20;
			valor = valor * cotacao_euro;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de reais para euros: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
		
		public static double reais_para_libras(double valor) {
			double cotacao_libra = 0.17;
			valor = valor * cotacao_libra;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de reais para libras: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
		
		public static double reais_para_yens(double valor) {
			double cotacao_yens = 26.63;
			valor = valor * cotacao_yens;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de reais para yens: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
		
		public static double reais_para_won_coreano(double valor) {
			double cotacao_won_coreano = 263.78;
			valor = valor * cotacao_won_coreano;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de reais para won coreano: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
		
		public static double dolares_para_reais(double valor) {
			double cotacao_real = 4.99;
			valor = valor * cotacao_real;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de dolares para reais: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
		
		public static double euros_para_reais(double valor) {
			double cotacao_real = 5.13;
			valor = valor * cotacao_real;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de euros para reais: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
		
		public static double libras_para_reais(double valor) {
			double cotacao_real = 6.02;
			valor = valor * cotacao_real;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de libras para reais: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
		
		public static double yens_para_reais(double valor) {
			double cotacao_real = 0.038;
			valor = valor * cotacao_real;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de yens para reais: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
		
		public static double won_coreano_para_reais(double valor) {
			double cotacao_real = 0.0038;
			valor = valor * cotacao_real;
			JOptionPane.showMessageDialog(frame, String.format("Conversão de won coreano para reais: %.2f", valor), "Conversor", JOptionPane.PLAIN_MESSAGE);
			return valor;
		}
	}

