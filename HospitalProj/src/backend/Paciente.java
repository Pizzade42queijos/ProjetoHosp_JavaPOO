package backend;


import java.util.ArrayList;

public class Paciente extends Pessoa {
private String SexoPaciente;
private int IdadePaciente;

public Paciente(int id, String nome, int idade, String sexo) {
	super(nome, id);
	if(sexo == null) {
		setSexoPaciente("Masculino");
	}
	setSexoPaciente(sexo);
	setIdadePaciente(idade);
}

public static ArrayList<Paciente> Pacientes = new ArrayList<Paciente>();

public String getSexoPaciente() {
	return SexoPaciente;
}

public void setSexoPaciente(String sexoPaciente) {
	SexoPaciente = sexoPaciente;
}

public int getIdadePaciente() {
	return IdadePaciente;
}

public void setIdadePaciente(int idadePaciente) {
	IdadePaciente = idadePaciente;
}

// podem ser feito metodos de cadastrar ou excluir cadastro do paciente similar a como funcionaria o marcar e desmarcar consulta

}
