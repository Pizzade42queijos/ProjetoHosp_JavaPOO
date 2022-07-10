package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaOperador {

	public JFrame JOpframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaOperador window = new JanelaOperador(); //para as funções relativas a um operador
					window.JOpframe.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaOperador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JOpframe = new JFrame();
		JOpframe.setBounds(100, 100, 450, 300);
		JOpframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOpframe.getContentPane().setLayout(null);
		JOpframe.setLocationRelativeTo(null);
		
		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPrincipal JP = new JanelaPrincipal();
				JP.JPframe.setVisible(true);
				JOpframe.dispose();
			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_Voltar.setBounds(224, 59, 167, 90);
		JOpframe.getContentPane().add(btn_Voltar);
		
		JButton btn_Cadastro = new JButton("Cadastrar");
		btn_Cadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCadastro JC = new JanelaCadastro();
				JC.JCad.setVisible(true); 
				JOpframe.dispose();
			}
		});
		btn_Cadastro.setFont(new Font("Dialog", Font.PLAIN, 11));
		btn_Cadastro.setBounds(47, 59, 167, 90);
		JOpframe.getContentPane().add(btn_Cadastro);
		
		JButton btn_ListaPac = new JButton("Listar / Deletar Pacientes");
		btn_ListaPac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarDeletPac LDP = new ListarDeletPac();
				LDP.LDPframe.setVisible(true);
				JOpframe.dispose();
			}
		});
		btn_ListaPac.setFont(new Font("Dialog", Font.PLAIN, 10));
		btn_ListaPac.setBounds(47, 160, 167, 90);
		JOpframe.getContentPane().add(btn_ListaPac);
		
		JButton btn_Listamed = new JButton("Listar / Deletar Medicos");
		btn_Listamed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarDeletMed LDM = new ListarDeletMed();
				LDM.LDMframe.setVisible(true);
				JOpframe.dispose();
			}
		});
		btn_Listamed.setFont(new Font("Dialog", Font.PLAIN, 10));
		btn_Listamed.setBounds(224, 160, 167, 90);
		JOpframe.getContentPane().add(btn_Listamed);
		
		JLabel lblNewLabel = new JLabel("OPERADOR");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.BOLD, 27));
		lblNewLabel.setBounds(138, 11, 167, 37);
		JOpframe.getContentPane().add(lblNewLabel);
	}
}
