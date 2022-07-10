package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class JanelaPConsultas {

	public JFrame JPCframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPConsultas window = new JanelaPConsultas();
					window.JPCframe.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPConsultas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPCframe = new JFrame();
		JPCframe.setResizable(false);
		JPCframe.setBounds(100, 100, 450, 300);
		JPCframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPCframe.getContentPane().setLayout(null);
		JPCframe.setLocationRelativeTo(null);
		
		JButton btn_CDC = new JButton("Criar/ Deletar Consultas"); //janela paciente
		btn_CDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPaciente JP = new JanelaPaciente();
				JP.LDCframe.setVisible(true);
				JPCframe.dispose();
			}
		});
		btn_CDC.setBounds(46, 101, 161, 136);
		JPCframe.getContentPane().add(btn_CDC);
		
		JButton btnLDC = new JButton("Listar/ Editar Consultas");
		btnLDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaEditConsultas JEC = new janelaEditConsultas();
				JEC.JECframe.setVisible(true);
				JPCframe.dispose();
				
			}
		});
		btnLDC.setBounds(227, 101, 161, 136);
		JPCframe.getContentPane().add(btnLDC);
		
		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPrincipal JP = new JanelaPrincipal();
				JP.JPframe.setVisible(true);
				JPCframe.dispose();
				
			}
		});
		btn_Voltar.setBounds(335, 11, 89, 23);
		JPCframe.getContentPane().add(btn_Voltar);
		
		JLabel lblNewLabel = new JLabel("Consultas");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(154, 48, 142, 44);
		JPCframe.getContentPane().add(lblNewLabel);
	}
}
