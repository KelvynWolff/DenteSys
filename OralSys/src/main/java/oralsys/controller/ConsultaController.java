package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Consulta;
import oralsys.entidades.FormaPagamento;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import oralsys.entidades.TipoPagamento;
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
            int dentistaId = json.getInt("dentistaId");
            Funcionario dentista = converterEntidades.converterFuncionarioPorId(dentistaId);
            consulta.setDentista(dentista);
        }
        
        if (json.has("funcionarioId")) {
            int funcionarioId = json.getInt("funcionarioId");
            Funcionario funcionario = converterEntidades.converterFuncionarioPorId(funcionarioId);
            consulta.setFuncionario(funcionario);
        }

        if (json.has("tipoPagamentosIds")) {
            int tipoPagamentosId = json.getInt("tipoPagamentosIds");
            TipoPagamento tipoPagamentos = converterEntidades.converterTipoPagamentosPorIds(tipoPagamentosId);
            consulta.setTipoPagamento(tipoPagamentos);
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
    
    public JSONArray listarConsulta(String condicao, boolean join) {
        ConsultaDao consultaDao = new ConsultaDao();
        List<Consulta> retorno = consultaDao.listarConsulta(condicao, join);

        JSONArray jsonArray = new JSONArray();

        for (Consulta consulta : retorno) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", consulta.getId());
            
            Funcionario dentista = consulta.getDentista();
            if (dentista != null) {
                jsonObject.put("dentista", dentista.getNome());
                jsonObject.put("dentistaId", dentista.getId());
            } else {
                jsonObject.put("dentista", "--");
            }
            
            
            jsonObject.put("tipoPagamento", consulta.getTipoPagamento().getId());
            
            String observacao = consulta.getObservacao();
            jsonObject.put("observacao", observacao != null ? observacao : "--");
            
            Paciente paciente = consulta.getPaciente();
            if (paciente != null) {
                jsonObject.put("paciente", paciente.getNome());
                jsonObject.put("pacienteCpf", paciente.getCpf());
            } else {
                jsonObject.put("paciente", "--");
            }

            jsonObject.put("status", consulta.getStatus());
            jsonArray.put(jsonObject);
        }

        return jsonArray;
    }


    public String marcarConsulta(JSONObject consultaJSON) {
        List<String> status = new LinkedList<>();
        
        if (consultaJSON.optString("dentistaId").isEmpty()) {
            status.add("Dentista invalido!");
        }
        if (consultaJSON.optString("tipoPagamentosIds").isEmpty()) {
            status.add("Tipo de pagamento invalido!");
        }
        if (consultaJSON.optString("pacienteId").isEmpty()) {
            status.add("Paciente invalido!");
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
