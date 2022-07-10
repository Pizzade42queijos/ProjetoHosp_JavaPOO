package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import backend.Paciente;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ListarDeletPac {

	public JFrame LDPframe;
	private JTextField IdTextField;
	private JTextField NomeTextField;
	private JTextField IdadeTextField;
	private String SexoPac = "Masculino"; //variavel sexopac dessa classe, diferente da de cadastro, n tornar publica. Também inicia como masculino em caso do usuário n selecionar nada
	private JTextField textField;
	private JTextField textField_1;
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
	private JTextField textField_32;
	private JTextField textField_33;
	private String Especialidade = "Cardiologista"; //inicia como Cardiologista pro caso de ninguém selecionar nada..
	private ArrayList<JTextField> arraydetxt = new ArrayList<JTextField>(); //armazenará todos os campos de txt pro loop
	private JButton btn_voltar;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarDeletPac window = new ListarDeletPac();
					window.LDPframe.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarDeletPac() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LDPframe = new JFrame();
		LDPframe.setBounds(100, 100, 930, 496);
		LDPframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LDPframe.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		IdTextField = new JTextField();
		IdTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Deletar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Paciente.Pacientes.size(); i++ ) {
					if (Integer.parseInt(IdTextField.getText()) == (Paciente.Pacientes.get(i).getId())){
						Paciente.Pacientes.remove(i);
						break;
					}
				}
				
			}
		});
		btnNewButton.setBackground(Color.RED);
		
		JLabel lblNewLabel_1 = new JLabel("Modifica\u00E7\u00F5es:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		NomeTextField = new JTextField();
		NomeTextField.setColumns(10);
		
		IdadeTextField = new JTextField();
		IdadeTextField.setColumns(10);
		
		JButton btn_ModNomePac = new JButton("Modificar");
		btn_ModNomePac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Paciente.Pacientes.size(); i++) {
					if (Integer.parseInt(IdTextField.getText()) == (Paciente.Pacientes.get(i).getId())) {
						Paciente.Pacientes.get(i).setNome(NomeTextField.getText());
						JOptionPane.showMessageDialog(btn_ModNomePac, "O nome foi modificado com sucesso!");
						break;
					}
				}
			}
		});
		
		JButton btn_ModIdadePac = new JButton("Modificar");
		btn_ModIdadePac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Paciente.Pacientes.size(); i++) {
					if (Integer.parseInt(IdTextField.getText()) == (Paciente.Pacientes.get(i).getId())) {
						Paciente.Pacientes.get(i).setIdadePaciente(Integer.parseInt(IdadeTextField.getText()));
						JOptionPane.showMessageDialog(btn_ModIdadePac, "A idade foi modificada com sucesso!");
						break;
					}
			}
			}
		});
		
		JButton btn_ModSexPac = new JButton("Modificar");
		btn_ModSexPac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < Paciente.Pacientes.size(); i++) {
					if (Integer.parseInt(IdTextField.getText()) == (Paciente.Pacientes.get(i).getId())) {
						Paciente.Pacientes.get(i).setSexoPaciente(SexoPac);
						JOptionPane.showMessageDialog(btn_ModSexPac, "O sexo foi modificado com sucesso!");
						break;
						}
				}
			}
		});
		
		JComboBox ComboboxModSexoPac = new JComboBox();
		ComboboxModSexoPac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ComboboxModSexoPac.getSelectedItem().equals("Masc")) {
					SexoPac = "Masculino";
				}else {
					SexoPac = "Feminino";
				}
			}
		});
		ComboboxModSexoPac.setModel(new DefaultComboBoxModel(new String[] {"Masc", "Fem"}));
		ComboboxModSexoPac.setMaximumRowCount(2);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel_2 = new JLabel("Modificar Nome");
		
		JLabel lblNewLabel_3 = new JLabel("Modificar Idade");
		
		JLabel lblNewLabel_4 = new JLabel("Modificar Sexo");
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateComponentTreeUI(LDPframe);
				for (int i = 0; i < arraydetxt.size(); i++) {
					arraydetxt.get(i).setText(" ");
				}
				for (int i = 0; i < Paciente.Pacientes.size(); i++ ) {
					arraydetxt.get(i).setText("ID: "+ Paciente.Pacientes.get(i).getId()+", Nome: "+Paciente.Pacientes.get(i).getNome()+", Idade: "+Paciente.Pacientes.get(i).getIdadePaciente()+", Sexo: "+Paciente.Pacientes.get(i).getSexoPaciente());
				}
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Pressione Update para iniciar");
		
		btn_voltar = new JButton("Voltar");
		btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaOperador JOp = new JanelaOperador();
				JOp.JOpframe.setVisible(true);
				LDPframe.dispose();
			}
		});
		btn_voltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_voltar.setForeground(Color.BLACK);
		
		GroupLayout groupLayout = new GroupLayout(LDPframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(ComboboxModSexoPac, 0, 41, Short.MAX_VALUE)
							.addGap(37)
							.addComponent(btn_ModSexPac, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addGap(210))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(IdadeTextField, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_ModIdadePac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(210))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(NomeTextField, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_ModNomePac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(210))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(13)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(IdTextField, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
							.addGap(190)
							.addComponent(btn_voltar)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2)
							.addGap(296))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3)
							.addGap(295))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_4)
							.addGap(299))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_update)
							.addGap(25)
							.addComponent(lblNewLabel_5)
							.addGap(138)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
					.addGap(9))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(IdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_voltar))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addGap(31)
							.addComponent(lblNewLabel_1)
							.addGap(16)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(NomeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_ModNomePac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(44)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(IdadeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_ModIdadePac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(36)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(ComboboxModSexoPac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_ModSexPac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_update)
								.addComponent(lblNewLabel_5))
							.addGap(64))))
		);
		for (int i = 0; i < Paciente.Pacientes.size(); i++ ) {
			
		}
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		
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
		
		textField_32 = new JTextField();
		textField_32.setHorizontalAlignment(SwingConstants.LEFT);
		textField_32.setColumns(10);
		
		textField_33 = new JTextField();
		textField_33.setHorizontalAlignment(SwingConstants.LEFT);
		textField_33.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setHorizontalAlignment(SwingConstants.LEFT);
		textField_25.setColumns(10);
		arraydetxt.add(textField);
		arraydetxt.add(textField_1);
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
		arraydetxt.add(textField_14);
		arraydetxt.add(textField_15);
		arraydetxt.add(textField_16);
		arraydetxt.add(textField_17);
		arraydetxt.add(textField_18);
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
		arraydetxt.add(textField_31);
		arraydetxt.add(textField_31);
		arraydetxt.add(textField_32);
		arraydetxt.add(textField_33);
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_17, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_18, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_19, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_20, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_21, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_22, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_23, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_24, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_25, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_26, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_10, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_27, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_11, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_28, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_12, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_29, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_13, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_30, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_14, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_31, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_15, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_32, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(textField_16, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(textField_33, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_32, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_33, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		LDPframe.getContentPane().setLayout(groupLayout);
	}
}
