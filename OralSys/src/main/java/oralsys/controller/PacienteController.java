package oralsys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Agendamento;
import oralsys.entidades.Consulta;
import oralsys.entidades.Contato;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import oralsys.persistencia.PacienteDao;
import oralsys.persistencia.ConverterEntidades;
import org.json.JSONArray;
import org.json.JSONObject;

public class PacienteController implements Controller {
    private PacienteDao pacienteDao;
    private ConverterEntidades converterEntidades;
    
    public PacienteController(PacienteDao pacienteDao, ConverterEntidades converterEntidades) {
        this.pacienteDao = pacienteDao;
        this.converterEntidades = converterEntidades;
    }
    
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
        if (status.isEmpty()) {
            Paciente paciente = new Paciente();
            
            if (pacienteJSON.has("agendamentosIds")) {
                JSONArray agendamentosIds = pacienteJSON.getJSONArray("agendamentosIds");
                List<Agendamento> agendamentos = converterEntidades.converterAgendamentosPorIds(agendamentosIds);
                paciente.setAgendamentos(agendamentos);
            }

            if (pacienteJSON.has("consultasIds")) {
                JSONArray consultasIds = pacienteJSON.getJSONArray("consultasIds");
                List<Consulta> consultas = converterEntidades.converterConsultasPorIds(consultasIds);
                paciente.setConsultas(consultas);
            }

            if (pacienteJSON.has("contatosIds")) {
                JSONArray contatosIds = pacienteJSON.getJSONArray("contatosIds");
                List<Contato> contatos = converterEntidades.converterContatosPorIds(contatosIds);
                paciente.setContatos(contatos);
            }

            paciente.setCpf(pacienteJSON.optString("cpf"));
            String dataStr = pacienteJSON.optString("dataNascimento");
            if (!dataStr.isEmpty()) {
                try {
                    Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(dataStr);
                    paciente.setDataNascimento(dataNascimento);
                } catch (ParseException e) {
                    status.add("Formato de data inválido!");
                }
            }

            if (pacienteJSON.has("pacientesIds")) {
                JSONArray pacientesIds = pacienteJSON.getJSONArray("pacientesIds");
                List<Paciente> pacientes = converterEntidades.converterPacientesPorIds(pacientesIds);
                paciente.setPacientes(pacientes);
            }

            if (pacienteJSON.has("prontuariosIds")) {
                JSONArray prontuariosIds = pacienteJSON.getJSONArray("prontuariosIds");
                List<Prontuario> prontuarios = converterEntidades.converterProntuariosPorIds(prontuariosIds);
                paciente.setProntuarios(prontuarios);
            }

            if (pacienteJSON.has("responsavelId")) {
                Long responsavelId = pacienteJSON.optLong("responsavelId");
                Paciente responsavel = pacienteDao.buscarPorId(responsavelId);
                paciente.setResponsavel(responsavel);
            }

            if (status.isEmpty()) {
                pacienteDao.salvar(paciente);
                status.add("Sucesso!");
            }
        }

        return status.toString();
    }
    
    public String alterarPaciente(String id, JSONObject pacienteJSON) {
        List<String> status = new LinkedList<>();
        if (id == null || id.isEmpty()) {
            status.add("ID Invalido!");
            return String.join(", ", status);
        }

        Paciente paciente = pacienteDao.buscarPorId(Long.parseLong(id));
        if (paciente == null) {
            status.add("Paciente não encontrado!");
            return String.join(", ", status);
        }

        if (!pacienteJSON.optString("agendamentos").isEmpty()) {
            JSONArray agendamentosIds = pacienteJSON.getJSONArray("agendamentos");
            List<Agendamento> agendamentos = converterEntidades.converterAgendamentosPorIds(agendamentosIds);
            paciente.setAgendamentos(agendamentos);
        }
        if (!pacienteJSON.optString("consultas").isEmpty()) {
            JSONArray consultasIds = pacienteJSON.getJSONArray("consultas");
            List<Consulta> consultas = converterEntidades.converterConsultasPorIds(consultasIds);
            paciente.setConsultas(consultas);
        }
        if (!pacienteJSON.optString("contatos").isEmpty()) {
            JSONArray contatosIds = pacienteJSON.getJSONArray("contatos");
            List<Contato> contatos = converterEntidades.converterContatosPorIds(contatosIds);
            paciente.setContatos(contatos);
        }
        paciente.setCpf(pacienteJSON.optString("cpf", paciente.getCpf()));
        paciente.setNome(pacienteJSON.optString("nome", paciente.getNome()));
        paciente.setNumeroCasa(pacienteJSON.optString("numeroCasa", paciente.getNumeroCasa()));

        String dataNascimentoStr = pacienteJSON.optString("dataNascimento");
        if (!dataNascimentoStr.isEmpty()) {
            try {
                Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimentoStr);
                paciente.setDataNascimento(dataNascimento);
            } catch (ParseException e) {
                status.add("Formato de data inválido!");
            }
        }

        if (!pacienteJSON.optString("pacientes").isEmpty()) {
            JSONArray pacientesIds = pacienteJSON.getJSONArray("pacientes");
            List<Paciente> pacientes = converterEntidades.converterPacientesPorIds(pacientesIds);
            paciente.setPacientes(pacientes);
        }

        if (!pacienteJSON.optString("prontuarios").isEmpty()) {
            JSONArray prontuariosIds = pacienteJSON.getJSONArray("prontuarios");
            List<Prontuario> prontuarios = converterEntidades.converterProntuariosPorIds(prontuariosIds);
            paciente.setProntuarios(prontuarios);
        }

        if (!pacienteJSON.isNull("responsavelId")) {
            Long responsavelId = pacienteJSON.optLong("responsavelId");
            Paciente responsavel = pacienteDao.buscarPorId(responsavelId);
            paciente.setResponsavel(responsavel);
        }

        pacienteDao.atualiza(paciente);
        status.add("Sucesso!");
        return String.join(", ", status);
    }

    public String removerPaciente(String id) {
        List<String> status = new LinkedList<>();
        if (id == null || id.isEmpty()) {
            status.add("ID Invalido!");
            return String.join(", ", status);
        }

        Paciente paciente = pacienteDao.buscarPorId(Long.parseLong(id));
        if (paciente == null) {
            status.add("Paciente não encontrado!");
            return String.join(", ", status);
        }

        pacienteDao.remove(paciente);
        status.add("Sucesso!");
        return String.join(", ", status);
    }
    
   @Override
    public Paciente converte(JSONObject json) {
        if (json == null) {
            throw new IllegalArgumentException("O objeto JSON não pode ser nulo");
        }

        Paciente paciente = new Paciente();
        paciente.setNome(json.optString("nome"));
        paciente.setCpf(json.optString("cpf"));
        paciente.setNumeroCasa(json.optString("numeroCasa"));

        try {
            String dataNascimentoStr = json.optString("dataNascimento");
            if (!dataNascimentoStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dataNascimento = sdf.parse(dataNascimentoStr);
                paciente.setDataNascimento(dataNascimento);
            }
        } catch (ParseException e) {
            System.err.println("Erro ao converter a data de nascimento: " + e.getMessage());
        }

        if (json.has("pacientesIds")) {
            JSONArray pacientesIds = json.getJSONArray("pacientesIds");
            List<Paciente> pacientes = converterEntidades.converterPacientesPorIds(pacientesIds);
            paciente.setPacientes(pacientes);
        }

        if (json.has("consultasIds")) {
            JSONArray consultasIds = json.getJSONArray("consultasIds");
            List<Consulta> consultas = converterEntidades.converterConsultasPorIds(consultasIds);
            paciente.setConsultas(consultas);
        }

        if (json.has("prontuariosIds")) {
            JSONArray prontuariosIds = json.getJSONArray("prontuariosIds");
            List<Prontuario> prontuarios = converterEntidades.converterProntuariosPorIds(prontuariosIds);
            paciente.setProntuarios(prontuarios);
        }

        if (json.has("agendamentosIds")) {
            JSONArray agendamentosIds = json.getJSONArray("agendamentosIds");
            List<Agendamento> agendamentos = converterEntidades.converterAgendamentosPorIds(agendamentosIds);
            paciente.setAgendamentos(agendamentos);
        }

        if (!json.isNull("responsavelId")) {
            Long responsavelId = json.getLong("responsavelId");
            Paciente responsavel = pacienteDao.buscarPorId(responsavelId);
            paciente.setResponsavel(responsavel);
        }

        return paciente;
    }
}
