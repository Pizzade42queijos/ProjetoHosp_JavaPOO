package frontend;

import java.awt.EventQueue;

import backend.Medico;
import backend.Paciente;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class JanelaCadastro {
	
	private int idPac;
	private int idMed;
	private int Idadeint;
	private String SexoPac = "Masculino"; //se nenhuma ação for feita no Combobox a condição natural da variavel é essa
	private String Especialidade; //variavel para armazenar a string, se ela for nula setado inicialmente como cardio pelo construtor
	public JFrame JCad;
	private JTextField textFieldNomePac;
	private JTextField textFieldNomeMed;
	private JTextField TextFieldIdadePac;
	private int CamposdeTextoPac = 34;
	private int CamposdetextoMed = 30;
	Boolean IdadeValidada;
	public void setIdadeint(int idadeint) {
		Idadeint = idadeint;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastro window = new JanelaCadastro();
					window.JCad.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JCad = new JFrame();
		JCad.setBounds(100, 100, 1015, 622);
		JCad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JCad.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		JCad.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 200));
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro M\u00E9dico:");
		panel.add(lblNewLabel_1);
		JLabel lblNewLabel_5 = new JLabel("Nome:");
		panel.add(lblNewLabel_5);
		
		textFieldNomeMed = new JTextField();
		panel.add(textFieldNomeMed);
		textFieldNomeMed.setColumns(20);
		
		JLabel lblNewLabel_6 = new JLabel("Especialidade");
		panel.add(lblNewLabel_6);
		
		JComboBox CB_EspecialidadeMed = new JComboBox(); 
		CB_EspecialidadeMed.addActionListener(new ActionListener() { //combobox seleção da especialidade do médico
			public void actionPerformed(ActionEvent e) {
				Especialidade = (String) CB_EspecialidadeMed.getSelectedItem();
			}
		});
		CB_EspecialidadeMed.setModel(new DefaultComboBoxModel(new String[] {"Cardiologista", "Clinico Geral", "Dermatologista", "Genecologista ", "Neurologista", "Oftalmologista", "Oncologista", "Ortopedista", "Pediatra", "Urologista "}));
		panel.add(CB_EspecialidadeMed);
		
		JButton btn_CadMed = new JButton("Cadastrar M\u00E9dico");
		btn_CadMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(Medico.Medicos.size() > 0) { //redundante mas ajuda a entender
					idMed = (Medico.Medicos.get(Medico.Medicos.size() -1).getId())+1;
				} else {
					idMed = 0;
				}
				if (Medico.Medicos.size() >= CamposdetextoMed) {
					JOptionPane.showMessageDialog(btn_CadMed, "Número Máximo de Medicos possíveis já cadastrado! Por favor remova pacientes se quiser adicionar novos");
				} else {
				Medico novoMedico = new Medico(idMed, textFieldNomeMed.getText(), Especialidade);
				Medico.Medicos.add(novoMedico);
				JOptionPane.showMessageDialog(btn_CadMed, "O(a) Doutor(a) " + novoMedico.getEspecMedico()+ " de nome " + novoMedico.getNome() + " foi cadastrado(a) com sucesso!");
				}
			}
		});
		panel.add(btn_CadMed);
		
		JButton btn_Voltar = new JButton("Voltar");   //voltar a JanelaOperador
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaOperador JO = new JanelaOperador();
				JO.JOpframe.setVisible(true);
				JCad.dispose();
			}
		});
		btn_Voltar.setFont(new Font("Arial Black", Font.BOLD, 22));
		panel.add(btn_Voltar);
		
		JPanel panel_1 = new JPanel();
		JCad.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		
		JLabel lblNewLabel = new JLabel("Cadastro Paciente:");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Nome:");
		panel_1.add(lblNewLabel_3);
		
		textFieldNomePac = new JTextField();
		panel_1.add(textFieldNomePac);
		textFieldNomePac.setColumns(40);
		
		JLabel lblNewLabel_2 = new JLabel("Idade\r\n:");
		panel_1.add(lblNewLabel_2);
		
		TextFieldIdadePac = new JTextField();
		panel_1.add(TextFieldIdadePac);
		TextFieldIdadePac.setColumns(2);
		
		JLabel lblNewLabel_4 = new JLabel("Sexo:");
		panel_1.add(lblNewLabel_4);
		
		JButton btn_CadPac = new JButton("Cadastrar Paciente\r\n"); 
		btn_CadPac.addActionListener(new ActionListener() { // cadastro paciente
			public void actionPerformed(ActionEvent e) {
				String IdadeString = TextFieldIdadePac.getText();
				try {
				setIdadeint(Integer.parseInt(IdadeString));
				IdadeValidada = true;
				} catch (Exception ErroConvIntString) {
					JOptionPane.showMessageDialog(btn_CadPac, "ERRO! Por favor digite a idade corretamente, use apenas números");
					IdadeValidada = false;
				}
				if (IdadeValidada) {
					if (Paciente.Pacientes.size() >= CamposdeTextoPac ) { //se maior ou igual ao numero de textfields em ListarDeletPac
						JOptionPane.showMessageDialog(btn_CadPac, "Número Máximo de Pacientes possíveis já cadastrado! Por favor remova pacientes se quiser adicionar novos");
					} else if (Paciente.Pacientes.size() >0) {
					 idPac = (Paciente.Pacientes.get(Paciente.Pacientes.size() -1).getId()) + 1; //pega o ID do ultimo item da lista (index tamanho - 1) e retorna um novo id que é um numero a mais. dessa forma cada novo objeto Paciente terá um id diferente e imutável, independente se itens anteriores foram deletados 
					} else {
						idPac = 0; //significa que se nenhum item for deletado o index sempre será igual ao id
					}
					Paciente novoPaciente = new Paciente(idPac ,textFieldNomePac.getText(),Idadeint,SexoPac); //teste 
					Paciente.Pacientes.add(novoPaciente);
					JOptionPane.showMessageDialog(btn_CadPac,"O(a) Paciente " + novoPaciente.getNome() + ", de idade "+ novoPaciente.getIdadePaciente()+" do sexo "+ novoPaciente.getSexoPaciente() +" foi cadastrado com sucesso!");
					//JOptionPane.showMessageDialog(btn_CadPac, "O Paciente" + (novoPaciente.getNomPaciente()));
					
				} else {
					//feijoada
				}
			}

		});
		
		JComboBox Cb_sexoPac = new JComboBox(); //Combobox sexo paciente
		Cb_sexoPac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Cb_sexoPac.getSelectedItem().equals("Masc")) {
					SexoPac = "Maculino";
				}else {
					SexoPac = "Feminino";
				}
			}
		});
		Cb_sexoPac.setModel(new DefaultComboBoxModel(new String[] {"Masc", "Fem"}));
		Cb_sexoPac.setMaximumRowCount(2);
		panel_1.add(Cb_sexoPac);
		panel_1.add(btn_CadPac);
	}
}
