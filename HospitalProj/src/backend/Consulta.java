package backend;
import java.util.ArrayList;

public class Consulta{
private int Id;
private Paciente Paciente;
private Medico Medico;
private String Data;
public static ArrayList<Consulta> Consultas = new ArrayList<Consulta>(); 

public Consulta(int id, Paciente paciente, Medico medico, String data) {
	setPaciente(paciente);
	setMedico(medico);
	if (data == null) {
		setData("Hoje");
	} else {
	setData(data);
	}
}

public int getId() {
	return Id;
}

public void setId(int id) {
	this.Id = id;
}

public Paciente getPaciente() {
	return Paciente;
}


public void setPaciente(Paciente paciente) {
	this.Paciente = paciente;
}

public Medico getMedico() {
	return Medico;
}

public void setMedico(Medico medico) {
	this.Medico = medico;
}

public String getData() {
	return Data;
}

public void setData(String horario) {
	this.Data = horario;
}




}
