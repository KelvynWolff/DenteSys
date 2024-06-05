package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.FormaPagamento;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Login;
import oralsys.entidades.Paciente;
import oralsys.persistencia.FuncionarioDao;
import org.json.JSONObject;

public class FuncionarioController extends FuncionarioDao {
    public String cadastrarPaciente(JSONObject funcionarioJSON) {
        List status = new LinkedList();
        if (funcionarioJSON.get("agendamentos").equals("")) {
            status.add("Agendamento inválido!");
        }
        if (funcionarioJSON.get("consultas").equals("")) {
            status.add("Consulta inválida!");
        }
        if (funcionarioJSON.get("login") == null) {
            status.add("Login inválido!");
        }
        if (funcionarioJSON.get("nome").equals("")) {
            status.add("Nome inválido!");
        }
        if (funcionarioJSON.get("registro").equals("")) {
            status.add("Registro inválido!");
        }
        if (status.equals("")) {
            Funcionario funcionario = new Funcionario();
            funcionario.setAgendamentos((List<String>) funcionarioJSON.get("agendamentos"));
            funcionario.setConsultas((List<String>) funcionarioJSON.get("consultas"));
            funcionario.setLogin((Login) funcionarioJSON.get("login"));
            funcionario.setNome((String) funcionarioJSON.get("nome"));
            funcionario.setRegistro((String) funcionarioJSON.get("registro"));
            this.salvar(funcionario);
            status.add("Sucesso!");
        }
        return status.toString();
    }

}
