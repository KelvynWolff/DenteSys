package oralsys.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Consulta;
import oralsys.entidades.Consulta;
import oralsys.entidades.FormaPagamento;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import oralsys.persistencia.ConsultaDao;
import org.json.JSONObject;

public class ConsultaController extends ConsultaDao {
    
        public String marcarConsulta(JSONObject consultaJSON) {
        List status = new LinkedList();
        if (consultaJSON.get("dentista").equals("") || consultaJSON.get("dentista") == null) {
            status.add("Dentista invalido!");
        }
        if (consultaJSON.get("formaPagamento").equals("")) {
            status.add("Forma de pagamento invalida!");
        }
        if (consultaJSON.get("paciente").equals("") || consultaJSON.get("paciente") == null) {
            status.add("Paciente invalido!");
        }
        if (consultaJSON.get("prontuario").equals("") || consultaJSON.get("prontuario") == null) {
            status.add("Prontuario invalido!");
        }
        if (consultaJSON.get("status").equals("") || consultaJSON.get("status") == null) {
            status.add("Status invalido!");
        }
        if (status.equals("")) {
            Consulta consulta = new Consulta();
            consulta.setDentista((Funcionario) consultaJSON.get("dentista"));
            consulta.setFormaPagamentos((List<FormaPagamento>) consultaJSON.get("formaPagamento"));
            consulta.setObservacao((String) consultaJSON.get("observacao"));
            consulta.setPaciente((Paciente) consultaJSON.get("paciente"));
            consulta.setProntuarios((List<Prontuario>) consultaJSON.get("prontuario"));
            consulta.setStatus((String) consultaJSON.get("status"));
            status.add("Sucesso!");
            this.atualiza(consulta);
        }
            
        return status.toString();
    }
    public String cancelarConsulta(String id) {
        String status = "Sucesso!";
        if (id.isEmpty()) {
            status = "ID Invalido!";
        }
        String condicao = "id=' " + id + "'";
        if (status.equals("Sucesso!")) {
            List<Consulta> consulta = this.listarConsulta(condicao);
            consulta.get(0).setStatus("cancelado");
            this.atualiza(consulta);
        }
        return status;
    }
    
    public String confirmarConsulta(String id) {
        String status = "Sucesso!";
        if (id.isEmpty()) {
            status = "ID Invalido!";
        }
        String condicao = "id=' " + id + "'";
        if (status.equals("Sucesso!")) {
            List<Consulta> consulta = this.listarConsulta(condicao);
            consulta.get(0).setStatus("confirmado");
            this.salvar(consulta);
        }
        return status;
    }
}
