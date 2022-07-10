package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;

import backend.Medico;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class ListarDeletMed {

	public JFrame LDMframe;
	private JTextField IdTextField;
	private JTextField textField_ModNomeMed;
	private String Especialidade = "Cardiologista"; 
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private ArrayList<JTextField> arraydetxt = new ArrayList<JTextField>(); //armazenará todos os campos de txt pro loop
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarDeletMed window = new ListarDeletMed();
					window.LDMframe.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarDeletMed() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LDMframe = new JFrame();
		LDMframe.setBounds(100, 100, 930, 496);
		LDMframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LDMframe.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		
		IdTextField = new JTextField();
		IdTextField.setColumns(10);
		
		JButton btn_DeletarMed = new JButton("Deletar");
		btn_DeletarMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Medico.Medicos.size(); i++ ) {
					if (Integer.parseInt(IdTextField.getText()) == (Medico.Medicos.get(i).getId())){
						Medico.Medicos.remove(i);
						break;
					}
				}
			}
		});
		btn_DeletarMed.setBackground(Color.RED);
		btn_DeletarMed.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_1 = new JLabel("Modificar Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField_ModNomeMed = new JTextField();
		textField_ModNomeMed.setColumns(10);
		
		JButton btn_ModNomeMed = new JButton("Modificar");
		btn_ModNomeMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Medico.Medicos.size(); i++) {
					if (Integer.parseInt(IdTextField.getText()) == (Medico.Medicos.get(i).getId())) {
						Medico.Medicos.get(i).setNome(textField_ModNomeMed.getText());
						JOptionPane.showMessageDialog(btn_ModNomeMed, "O nome foi modificado com sucesso!");
						break;
					}
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Modificar Especialidade");
		
		JComboBox comboBoxModEspecMed = new JComboBox();
		comboBoxModEspecMed.setModel(new DefaultComboBoxModel(new String[] {"Cardiologista", "Clinico Geral", "Dermatologista", "Genecologista", "Neurologista", "Oftalmologista", "Oncologista", "Ortopedista", "Pediatra", "Urologista"}));
		comboBoxModEspecMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialidade = (String) comboBoxModEspecMed.getSelectedItem();
				
			}
		});
		
		JButton btn_ModEspecMed = new JButton("Modificar");
		btn_ModEspecMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Medico.Medicos.size(); i++) {
					if (Integer.parseInt(IdTextField.getText()) == (Medico.Medicos.get(i).getId())) {
						Medico.Medicos.get(i).setEspecMedico(Especialidade);
						JOptionPane.showMessageDialog(btn_ModEspecMed, "A Especialidade foi modificada com sucesso!");
						break;
						}
				}
			}
		});
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel_3 = new JLabel("Pressione Update para iniciar");
		
		JButton btn_UpdateDisplayMed = new JButton("Update");
		btn_UpdateDisplayMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateComponentTreeUI(LDMframe);
				for (int i = 0; i < arraydetxt.size(); i++) {
					arraydetxt.get(i).setText(" ");
				}
				for (int i = 0; i < Medico.Medicos.size(); i++ ) {
					arraydetxt.get(i).setText("ID: "+ Medico.Medicos.get(i).getId()+", Nome: "+Medico.Medicos.get(i).getNome()+", Especialidade "+Medico.Medicos.get(i).getEspecMedico());
				}
			}
		});
		
		JButton btn_voltar = new JButton("Voltar");
		btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaOperador JOp = new JanelaOperador();
				JOp.JOpframe.setVisible(true);
				LDMframe.dispose();
				
			}
		});
		btn_voltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout groupLayout = new GroupLayout(LDMframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btn_DeletarMed, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
								.addComponent(IdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(62))
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_ModNomeMed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxModEspecMed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_ModEspecMed)
								.addComponent(btn_ModNomeMed)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_UpdateDisplayMed)
							.addGap(29)
							.addComponent(lblNewLabel_3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_voltar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(IdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_voltar))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_DeletarMed)
							.addGap(128)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_ModNomeMed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_ModNomeMed))
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxModEspecMed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_ModEspecMed))
							.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(btn_UpdateDisplayMed))
							.addGap(51))))
		);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.LEFT);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.LEFT);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.LEFT);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.LEFT);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.LEFT);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.LEFT);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.LEFT);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.LEFT);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.LEFT);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.LEFT);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setHorizontalAlignment(SwingConstants.LEFT);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setHorizontalAlignment(SwingConstants.LEFT);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setHorizontalAlignment(SwingConstants.LEFT);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.LEFT);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.LEFT);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setHorizontalAlignment(SwingConstants.LEFT);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.LEFT);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setHorizontalAlignment(SwingConstants.LEFT);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setHorizontalAlignment(SwingConstants.LEFT);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setHorizontalAlignment(SwingConstants.LEFT);
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setHorizontalAlignment(SwingConstants.LEFT);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setHorizontalAlignment(SwingConstants.LEFT);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setHorizontalAlignment(SwingConstants.LEFT);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setHorizontalAlignment(SwingConstants.LEFT);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setHorizontalAlignment(SwingConstants.LEFT);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setHorizontalAlignment(SwingConstants.LEFT);
		textField_31.setColumns(10);
		arraydetxt.add(textField_2);
		arraydetxt.add(textField_3);
		arraydetxt.add(textField_4);
		arraydetxt.add(textField_5);
		arraydetxt.add(textField_6);
		arraydetxt.add(textField_7);
		arraydetxt.add(textField_8);
		arraydetxt.add(textField_9);
		arraydetxt.add(textField_10);
		arraydetxt.add(textField_11);
		arraydetxt.add(textField_12);
		arraydetxt.add(textField_13);
		arraydetxt.add(textField_13);
		arraydetxt.add(textField_15);
		arraydetxt.add(textField_16);
		arraydetxt.add(textField_17);
		arraydetxt.add(textField_18);
		arraydetxt.add(textField_19);
		arraydetxt.add(textField_20);
		arraydetxt.add(textField_21);
		arraydetxt.add(textField_22);
		arraydetxt.add(textField_23);
		arraydetxt.add(textField_24);
		arraydetxt.add(textField_25);
		arraydetxt.add(textField_26);
		arraydetxt.add(textField_27);
		arraydetxt.add(textField_28);
		arraydetxt.add(textField_29);
		arraydetxt.add(textField_30);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_17, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_18, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_19, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_20, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_21, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_22, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_23, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_24, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_10, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_25, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_11, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_26, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_12, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_27, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_13, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_28, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_14, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_29, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_15, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_30, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_16, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(64)
							.addComponent(textField_31, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		LDMframe.getContentPane().setLayout(groupLayout);
	}
}
