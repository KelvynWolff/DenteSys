package oralsys.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import oralsys.entidades.Agendamento;
import oralsys.entidades.Cidade;
import oralsys.entidades.Consulta;
import oralsys.entidades.Contato;
import oralsys.entidades.Endereco;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import oralsys.persistencia.PacienteDao;
import org.json.JSONObject;

public class PacienteController extends PacienteDao {
    public String inserirPaciente(JSONObject pacienteJSON) {
        List status = new LinkedList();
        if (pacienteJSON.get("agendamentos").equals("") || pacienteJSON.get("agendamentos") == null) {
            status.add("Agendamento invalido!");
        }
        if (pacienteJSON.get("consultas").equals("") || pacienteJSON.get("consultas") == null) {
            status.add("Consultas invalido!");
        }
        if (pacienteJSON.get("contatos").equals("") || pacienteJSON.get("contatos") == null) {
            status.add("Contato invalido!");
        }
        if (pacienteJSON.get("cpf").equals("") || pacienteJSON.get("cpf") == null) {
            status.add("CPF invalido!");
        }
        if (pacienteJSON.get("dataNascimento").equals("") || pacienteJSON.get("dataNascimento") == null) {
            status.add("Data Nascimento invalido!");
        }
        if (pacienteJSON.get("pacienteId").equals("") || pacienteJSON.get("pacienteId") == null) {
            status.add("PacienteId invalido!");
        }
        if (pacienteJSON.get("nome").equals("") || pacienteJSON.get("nome") == null) {
            status.add("Nome invalido!");
        }
        if (pacienteJSON.get("numeroCasa").equals("") || pacienteJSON.get("numeroCasa") == null) {
            status.add("Numero da Casa invalido!");
        }
        if (pacienteJSON.get("pacientes").equals("") || pacienteJSON.get("pacientes") == null) {
            status.add("Pacientes invalido!");
        }
        if (pacienteJSON.get("prontuarios").equals("") || pacienteJSON.get("prontuarios") == null) {
            status.add("Prontuarios invalido!");
        }
        if (pacienteJSON.get("responsavel").equals("") || pacienteJSON.get("responsavel") == null) {
            status.add("Responsavel invalido!");
        }
        if (status.equals("")) {
            Paciente paciente = new Paciente();
            paciente.setAgendamentos((List<Agendamento>) pacienteJSON.get("agendamentos"));
            paciente.setConsultas((List<Consulta>) pacienteJSON.get("consultas"));
            paciente.setContatos((List<Contato>) pacienteJSON.get("contatos"));
            paciente.setCpf((String) pacienteJSON.get("cpf"));
            paciente.setDataNascimento((Date) pacienteJSON.get("dataNascimento"));
            paciente.setPacientes((List<Paciente>) pacienteJSON.get("pacienteId"));
            paciente.setNome((String) pacienteJSON.get("nome"));
            paciente.setNumeroCasa((String) pacienteJSON.get("numeroCasa"));
            paciente.setPacientes((List<Paciente>) pacienteJSON.get("pacientes"));
            paciente.setProntuarios((List<Prontuario>) pacienteJSON.get("prontuarios"));
            paciente.setResponsavel((Paciente) pacienteJSON.get("responsavel"));
            
            status.add("Sucesso!");
            this.salvar(paciente);
        }
        return status.toString();
    }
    
    public String alterarPaciente(String id, JSONObject pacienteJSON) {
        List status = new LinkedList();
        if (id.isEmpty()) {
            status.add("ID Invalido!");
        }
        String condicao = "id=' " + id + "'";
        if (status.equals("Sucesso!")) {
            List<Paciente> paciente = this.listarPaciente(condicao);
            if (!pacienteJSON.get("agendamentos").equals("")) {
                paciente.get(0).setAgendamentos((List<Agendamento>) pacienteJSON.get("agendamentos"));
            }
            if (!pacienteJSON.get("consultas").equals("consultas")) {
                paciente.get(0).setConsultas((List<Consulta>) pacienteJSON.get("consultas"));
            }
            if (!pacienteJSON.get("contatos").equals("contatos")) {
                paciente.get(0).setContatos((List<Contato>) pacienteJSON.get("contatos"));
            }
            if (!pacienteJSON.get("cpf").equals("cpf")) {
                paciente.get(0).setCpf((String) pacienteJSON.get("cpf"));
            }
            if (!pacienteJSON.get("dataNascimento").equals("dataNascimento")) {
                paciente.get(0).setDataNascimento((Date) pacienteJSON.get("dataNascimento"));
            }
            if (!pacienteJSON.get("pacienteId").equals("pacienteId")) {
                paciente.get(0).setPacientes((List<Paciente>) pacienteJSON.get("pacienteId"));
            }
            if (!pacienteJSON.get("nome").equals("nome")) {
                paciente.get(0).setNome((String) pacienteJSON.get("nome"));
            }
            if (!pacienteJSON.get("numeroCasa").equals("numeroCasa")) {
                paciente.get(0).setNumeroCasa((String) pacienteJSON.get("numeroCasa"));
            }
            if (!pacienteJSON.get("pacientes").equals("pacientes")) {
                paciente.get(0).setPacientes((List<Paciente>) pacienteJSON.get("pacientes"));
            }
            if (!pacienteJSON.get("prontuarios").equals("prontuarios")) {
                paciente.get(0).setProntuarios((List<Prontuario>) pacienteJSON.get("prontuarios"));
            }
            if (!pacienteJSON.get("responsavel").equals("responsavel")) {
                paciente.get(0).setResponsavel((Paciente) pacienteJSON.get("responsavel"));
            }
            this.atualiza(paciente);
        }
        return status.toString();
    }

    public String removerPaciente(String id) {
        List status = new LinkedList();
        if (id.isEmpty()) {
            status.add("ID Invalido!");
        }
        String condicao = "id=' " + id + "'";
        if (status.equals("Sucesso!")) {
            List<Endereco> endereco = this.listarPaciente(condicao);
            this.remove(endereco.get(0));
        }
        return status.toString();
    }
}
