package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal {

	public JFrame JPframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.JPframe.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPframe = new JFrame();
		JPframe.setBackground(new Color(240, 240, 240));
		JPframe.setResizable(false);
		JPframe.setBounds(100, 100, 450, 300);
		JPframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPframe.getContentPane().setLayout(new BorderLayout(0, 0));
		JPframe.setLocationRelativeTo(null);
		
		JToolBar toolBar = new JToolBar();
		JPframe.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		JPframe.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btn_Pac = new JButton("Consultas");
		btn_Pac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPConsultas JP = new JanelaPConsultas();
				JP.JPCframe.setVisible(true);
				JPframe.dispose();
			}
		});
		btn_Pac.setBounds(29, 186, 131, 23);
		panel.add(btn_Pac);
		
		JButton btn_toListCad = new JButton("Usu\u00E1rios");
		btn_toListCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaOperador window = new JanelaOperador(); //para as funções relativas a um operador
				window.JOpframe.setVisible(true);
				JPframe.dispose();
			}
		});
		btn_toListCad.setBounds(269, 186, 131, 23);
		panel.add(btn_toListCad);
		
		JLabel lblNewLabel = new JLabel("HOSPITAL");
		lblNewLabel.setFont(new Font("Microsoft Tai Le", Font.BOLD, 54));
		lblNewLabel.setBounds(80, -18, 344, 148);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione Op\u00E7\u00E3o para cadastrar, editar ou deletar");
		lblNewLabel_1.setBounds(91, 164, 240, 14);
		panel.add(lblNewLabel_1);
	}
}
