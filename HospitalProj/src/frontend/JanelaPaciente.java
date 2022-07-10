package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import backend.Consulta;
import backend.Medico;
import backend.Paciente;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class JanelaPaciente { //para ações relativas a um paciente

	public JFrame LDCframe;
	private String Data; //variavel para armazenar a string vinda do combobox, se ela for nula setado inicialmente como Hoje pelo construtor
	private String Especialidade; //variavel para armazenar a string vinda do combobox, se ela for nula setado inicialmente como cardio pelo construtor
	private int IdCon; //variaveis para cadastro de consulta
	private Paciente PacCon;
	private Medico MedCon;
	private JTextField textFieldIdMedJP;
	private JTextField textField_IdConsulta;
	private JTextField textField_1;
	private JTextField textField_165;
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
	private int NumerodeCamposTexto = 32;
	private ArrayList<JTextField> arraydetxt = new ArrayList<JTextField>();
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btn_VisuMedicos;
	private JButton btn_VisuConsul;
	private JTextField textFieldIdPac;
	private JLabel lblNewLabel_8;
	
	
	public String getEspecialidade() {
		return Especialidade;
	}

	public void setEspecialidade(String especialidade) {
		Especialidade = especialidade;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPaciente window = new JanelaPaciente();
					window.LDCframe.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPaciente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LDCframe = new JFrame();
		LDCframe.setBounds(100, 100, 930, 496);
		LDCframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LDCframe.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Marcar Consulta");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JComboBox comboBoxSelecEspecMedJP = new JComboBox();
		comboBoxSelecEspecMedJP.setModel(new DefaultComboBoxModel(new String[] {"Cardiologista", "Clinico Geral", "Dermatologista", "Genecologista", "Neurologista", "Oftalmologista", "Oncologista", "Ortopedista", "Pediatra", "Urologista"}));
		comboBoxSelecEspecMedJP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Especialidade = (String) comboBoxSelecEspecMedJP.getSelectedItem();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Consultas por Especialidade:");
		
		JLabel lblNewLabel_2 = new JLabel("Id M\u00E9dico:");
		
		textFieldIdMedJP = new JTextField();
		textFieldIdMedJP.setColumns(10);
		
		JButton btn_MarcarIdMedJP = new JButton("Marcar");
		btn_MarcarIdMedJP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateComponentTreeUI(LDCframe);
				for (int i = 0; i < arraydetxt.size(); i++) {
					arraydetxt.get(i).setText(" ");
				}
				if (Consulta.Consultas.size() >= NumerodeCamposTexto ) { 
					JOptionPane.showMessageDialog(btn_MarcarIdMedJP, "Número Máximo de Consultas possíveis já cadastrado!");
				} else if (Consulta.Consultas.size() >0) {
				 IdCon = (Consulta.Consultas.get(Consulta.Consultas.size() -1).getId()) + 1;  
				} else {
					IdCon = 0; 
				}
				for (int i = 0; i < Paciente.Pacientes.size(); i++) {
					if (Paciente.Pacientes.get(i).getId() == Integer.parseInt(textFieldIdPac.getText())) {
						PacCon = Paciente.Pacientes.get(i);
						break;
					}
				}
				for (int i = 0; i < Medico.Medicos.size(); i++) {
					if (Medico.Medicos.get(i).getId() == Integer.parseInt(textFieldIdMedJP.getText())) {
						MedCon = Medico.Medicos.get(i);
						break;
					}
				}
				if(Consulta.Consultas.size() <= 32) {
					try { Consulta novaconsulta = new Consulta(IdCon, PacCon, MedCon , Data);
					Consulta.Consultas.add(novaconsulta);
					JOptionPane.showMessageDialog(btn_MarcarIdMedJP, "Nova consulta Marcada com sucesso! Pressione Visualisar para ver as consultas!");
					} catch (Exception ErroConvIntString){
					JOptionPane.showMessageDialog(btn_MarcarIdMedJP, "Erro, certifique-se de que digitou os campos corretamente.");
						}
				} else {
					JOptionPane.showMessageDialog(btn_MarcarIdMedJP, "Numero Máximo de Consultas Cadastradas");
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Desmarcar");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		textField_IdConsulta = new JTextField();
		textField_IdConsulta.setColumns(10);
		
		JButton btn_IdConsulta = new JButton("Desmarcar");
		btn_IdConsulta.setBackground(Color.RED);
		btn_IdConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateComponentTreeUI(LDCframe);
				for (int i = 0; i < arraydetxt.size(); i++) {
					arraydetxt.get(i).setText(" ");
				}
				for (int i = 0; i < Consulta.Consultas.size(); i++) {
				if ((Integer.parseInt(textField_IdConsulta.getText()) == Consulta.Consultas.get(i).getId())) {
					Consulta.Consultas.remove(i);
					SwingUtilities.updateComponentTreeUI(LDCframe);
					break;
				}
				}
			}
		});
		
		JButton btn_VoltarJP = new JButton("Voltar");
		btn_VoltarJP.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_VoltarJP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPConsultas JPC = new JanelaPConsultas();
				JPC.JPCframe.setVisible(true);
				LDCframe.dispose();
			}
		});
		
		JButton btn_UpdateJP = new JButton("Update");
		btn_UpdateJP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateComponentTreeUI(LDCframe);
			}
		});
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel_4 = new JLabel("Selecione a data e os Ids antes de marcar.");
		
		JLabel lblNewLabel_5 = new JLabel("Por Id Consulta");
		
		JComboBox comboBoxData = new JComboBox();
		comboBoxData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data = (String) comboBoxData.getSelectedItem();
			}
		});
		comboBoxData.setModel(new DefaultComboBoxModel(new String[] {"Hoje", "Amanh\u00E3", "Depois"}));
		
		lblNewLabel_6 = new JLabel("Visualizar");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblNewLabel_7 = new JLabel("Todas as Consultas");
		
		btn_VisuMedicos = new JButton("Visualizar"); //consultas por especialidade
		btn_VisuMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateComponentTreeUI(LDCframe);
				for (int i = 0; i < arraydetxt.size(); i++) {
					arraydetxt.get(i).setText(" ");
				}
				
				String Especvisumed = (String) comboBoxSelecEspecMedJP.getSelectedItem();
				if (Especvisumed == null) {
					Especvisumed = "Cardiologista";
				}
				
				for (int i = 0; i< Consulta.Consultas.size(); i++) {
					int arraypos = 0;
					if (Consulta.Consultas.get(i).getMedico().getEspecMedico().equals(Especvisumed)) {
						arraydetxt.get(arraypos).setText("Id Consulta: "+Consulta.Consultas.get(i).getId()+"Id Medico: "+Consulta.Consultas.get(i).getMedico().getId()+" Nome Med: "+Consulta.Consultas.get(i).getMedico().getNome()+" Nome Pac: "+Consulta.Consultas.get(i).getPaciente().getNome() +" Dia: "+Consulta.Consultas.get(i).getData() );
						arraypos += 1;
					}
				}
				SwingUtilities.updateComponentTreeUI(LDCframe);
			}
		});
		
		btn_VisuConsul = new JButton("Visualizar");
		btn_VisuConsul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.updateComponentTreeUI(LDCframe);
				for (int i = 0; i < arraydetxt.size(); i++) {
					arraydetxt.get(i).setText(" ");
				}
				for (int i = 0; i< Consulta.Consultas.size(); i++) {
					arraydetxt.get(i).setText("Id-C: "+Consulta.Consultas.get(i).getId()+" Medico(a): "+Consulta.Consultas.get(i).getMedico().getNome()+" Id-M: "+Consulta.Consultas.get(i).getMedico().getId()+" Paciente: "+Consulta.Consultas.get(i).getPaciente().getNome()+" Id-P: "+Consulta.Consultas.get(i).getPaciente().getId());
					
				}
				SwingUtilities.updateComponentTreeUI(LDCframe);
			}
		});
		
		textFieldIdPac = new JTextField();
		textFieldIdPac.setColumns(10);
		
		lblNewLabel_8 = new JLabel("ID Pac.");
		GroupLayout groupLayout = new GroupLayout(LDCframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textFieldIdMedJP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btn_MarcarIdMedJP, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBoxData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_4))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(204)
							.addComponent(lblNewLabel_3))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(87)
							.addComponent(textField_IdConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btn_IdConsulta))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(212)
							.addComponent(lblNewLabel_6))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(93)
							.addComponent(comboBoxSelecEspecMedJP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_VisuMedicos))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(lblNewLabel_8)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldIdPac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btn_UpdateJP, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(224)
							.addComponent(lblNewLabel_2))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(200)
							.addComponent(lblNewLabel_5))
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(181)
							.addComponent(lblNewLabel_7))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(197)
							.addComponent(btn_VisuConsul))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(207)
							.addComponent(btn_VoltarJP)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 672, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn_VoltarJP)
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_UpdateJP)
								.addComponent(textFieldIdPac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(comboBoxData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2)
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldIdMedJP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_MarcarIdMedJP))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3)
							.addGap(11)
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_IdConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_IdConsulta))
							.addGap(36)
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxSelecEspecMedJP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_VisuMedicos))
							.addGap(18)
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_VisuConsul)))
					.addContainerGap())
		);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		
		textField_165 = new JTextField();
		textField_165.setHorizontalAlignment(SwingConstants.LEFT);
		textField_165.setColumns(10);
		
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
		arraydetxt.add(textField_165);
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
		arraydetxt.add(textField_31);
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_165, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_23, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_25, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_26, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_27, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_28, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_29, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_30, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField_31, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_165, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
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
					.addPreferredGap(ComponentPlacement.RELATED)
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
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		LDCframe.getContentPane().setLayout(groupLayout);
	}
}
