package backend;

import java.util.ArrayList;

public class Medico extends Pessoa {
private String EspecMedico;

public Medico(int id, String nome, String especialidade) {
	super(nome, id);
	if (especialidade == null) {
		this.EspecMedico = "Cardiologista"; //primeira opção do combobox por ordem alfabética
	} else {
	this.EspecMedico = especialidade;
	}
}

public static ArrayList<Medico> Medicos = new ArrayList<Medico>();

public String getEspecMedico() {
	return EspecMedico;
}

public void setEspecMedico(String especMedico) {
	this.EspecMedico = especMedico;
}

}
