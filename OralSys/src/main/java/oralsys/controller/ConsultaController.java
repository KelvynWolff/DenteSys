package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Consulta;
import oralsys.entidades.FormaPagamento;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import oralsys.persistencia.ConsultaDao;
import oralsys.persistencia.ConverterEntidades;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConsultaController implements Controller {
    private ConverterEntidades converterEntidades;
    
    public ConsultaController() {
        this.converterEntidades = new ConverterEntidades();
    }

    @Override
    public Consulta converte(JSONObject json) {
        if (json == null) {
            throw new IllegalArgumentException("O objeto JSON não pode ser nulo");
        }

        Consulta consulta = new Consulta();

        if (json.has("dentistaId")) {
            Long dentistaId = json.getLong("dentistaId");
            Funcionario dentista = converterEntidades.converterFuncionarioPorId(dentistaId);
            consulta.setDentista(dentista);
        }

        if (json.has("formaPagamentosIds")) {
            JSONArray formaPagamentosIds = json.getJSONArray("formaPagamentosIds");
            List<FormaPagamento> formaPagamentos = converterEntidades.converterFormaPagamentosPorIds(formaPagamentosIds);
            consulta.setFormaPagamentos(formaPagamentos);
        }

        consulta.setObservacao(json.optString("observacao"));

        if (json.has("pacienteId")) {
            Long pacienteId = json.getLong("pacienteId");
            Paciente paciente = converterEntidades.converterPacientePorId(pacienteId);
            consulta.setPaciente(paciente);
        }

        if (json.has("prontuariosIds")) {
            JSONArray prontuariosIds = json.getJSONArray("prontuariosIds");
            List<Prontuario> prontuarios = converterEntidades.converterProntuariosPorIds(prontuariosIds);
            consulta.setProntuarios(prontuarios);
        }

        consulta.setStatus(json.optString("status"));

        return consulta;
    }

    public String marcarConsulta(JSONObject consultaJSON) {
        List<String> status = new LinkedList<>();
        
        if (consultaJSON.optString("dentistaId").isEmpty()) {
            status.add("Dentista invalido!");
        }
        if (consultaJSON.optString("formaPagamentosIds").isEmpty()) {
            status.add("Forma de pagamento invalida!");
        }
        if (consultaJSON.optString("pacienteId").isEmpty()) {
            status.add("Paciente invalido!");
        }
        if (consultaJSON.optString("prontuariosIds").isEmpty()) {
            status.add("Prontuario invalido!");
        }
        if (consultaJSON.optString("status").isEmpty()) {
            status.add("Status invalido!");
        }

        if (status.isEmpty()) {
            try {
                Consulta consulta = converte(consultaJSON);
                ConsultaDao consultaDao = new ConsultaDao();
                consultaDao.salvar(consulta);
                status.add("Sucesso!");
            } catch (IllegalArgumentException e) {
                status.add(e.getMessage());
            }
        }
        return String.join(", ", status);
    }

    public String excluirConsulta(int id) {
        String status = "Sucesso!";
        if (id == 0) {
            status = "ID Invalido!";
        } else {
            ConsultaDao consultaDao = new ConsultaDao();
            Consulta consulta = consultaDao.buscarPorId(id);
            if (consulta != null) {
                consultaDao.remove(consulta);
            } else {
                status = "Consulta não encontrada!";
            }
        }
        return status;
    }
    
    public String confirmarConsulta(int id) {
        String status = "Sucesso!";
        if (id == 0) {
            status = "ID Invalido!";
        } else {
            ConsultaDao consultaDao = new ConsultaDao();
            Consulta consulta = consultaDao.buscarPorId(id);
            if (consulta != null) {
                consulta.setStatus("confirmado");
                consultaDao.atualiza(consulta);
            } else {
                status = "Consulta não encontrada!";
            }
        }
        return status;
    }
}
