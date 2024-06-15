package oralsys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Consulta;
import static oralsys.entidades.Consulta_.paciente;
import oralsys.entidades.Contato;
import oralsys.entidades.Endereco;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import oralsys.persistencia.ContatoDao;
import oralsys.persistencia.PacienteDao;
import oralsys.persistencia.ConverterEntidades;
import oralsys.persistencia.EnderecoDao;
import org.json.JSONArray;
import org.json.JSONObject;

public class PacienteController implements Controller {
    private PacienteDao pacienteDao;
    private ConverterEntidades converterEntidades;
    
    public PacienteController() {
        this.pacienteDao = new PacienteDao();
        this.converterEntidades = new ConverterEntidades();
    }
    
    public String inserirPaciente(JSONObject pacienteJSON) {
     List<String> status = new LinkedList<>();
     
     String cpf = pacienteJSON.optString("cpf");
     if (cpf.isEmpty()) {
         status.add("CPF inválido!");
     }

     String nome = pacienteJSON.optString("nome");
     if (nome.isEmpty()) {
         status.add("Nome inválido!");
     }

     String dataNascimentoStr = pacienteJSON.optString("dataNascimento");
     if (dataNascimentoStr.isEmpty()) {
         status.add("Data de Nascimento inválida!");
     }
     
     String enderecoString = pacienteJSON.optString("endereco");
     EnderecoController enderecoController = new EnderecoController();
     JSONArray registros = enderecoController.listarEndereco("rua like '%" + enderecoString + "%'");
     int enderecoId = registros.getJSONObject(0).getInt("id");
     EnderecoDao enderecoDao = new EnderecoDao();
     Endereco endereco = enderecoDao.buscarPorId((long) enderecoId);
     
    
     String numeroCasa = pacienteJSON.optString("numeroCasa");
     if (numeroCasa.isEmpty()) {
         status.add("Número da Casa inválido!");
     }

     Long responsavelId = pacienteJSON.optLong("responsavelId", -1);
     Paciente responsavel = null;
     if (responsavelId != -1) {
         responsavel = pacienteDao.buscarPorId(responsavelId);
         if (responsavel == null) {
             status.add("Responsável inválido!");
         }
     }

     if (status.isEmpty()) {
         Paciente paciente = new Paciente();
         paciente.setCpf(cpf);
         paciente.setNome(nome);

         try {
             Date dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimentoStr);
             paciente.setDataNascimento(dataNascimento);
         } catch (ParseException e) {
             status.add("Formato de data inválido!");
         }

         if (responsavel != null) {
             paciente.setResponsavel(responsavel);
         }
         
         if (endereco != null) {
             paciente.setEndereco(endereco);
         }

         pacienteDao.salvar(paciente);
         status.add("Sucesso!");
        String telefone = pacienteJSON.optString("telefone");
        Contato contato = new Contato();
        contato.setPaciente(paciente);
        contato.setTelefone(telefone);
        ContatoDao contatoDao = new ContatoDao();
        contatoDao.salvar(contato);
     }
     return String.join(", ", status);
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
        paciente.setNumeroCasa(pacienteJSON.optString("numeroCasa"));

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

    public String removerPaciente(int id) {
        List<String> status = new LinkedList<>();
        if (id == 0) {
            status.add("ID Invalido!");
            return String.join(", ", status);
        }

        Paciente paciente = pacienteDao.buscarPorId((long) id);
        if (paciente == null) {
            status.add("Paciente não encontrado!");
            return String.join(", ", status);
        }

        pacienteDao.remove(paciente);
        status.add("Sucesso!");
        return String.join(", ", status);
    }
    
    public JSONArray listarPaciente(String condicao, boolean join) {
        PacienteDao pacienteDao = new PacienteDao();
        List<Paciente> retorno = pacienteDao.listarPaciente(condicao, join);

        JSONArray jsonArray = new JSONArray();

        for (Paciente paciente : retorno) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", paciente.getId());
            jsonObject.put("nome", paciente.getNome());
            jsonObject.put("dataNascimento", paciente.getDataNascimento() + "");
            jsonObject.put("cpf", paciente.getCpf());
            jsonObject.put("numeroCasa", paciente.getNumeroCasa());
            if (paciente.getEndereco() != null) {
                jsonObject.put("endereco", paciente.getEndereco().getRua());
                jsonObject.put("cidade", paciente.getEndereco().getCidade().getNome());
                jsonObject.put("estado", paciente.getEndereco().getCidade().getEstado().getUf());
            } else {
                jsonObject.put("endereco", "");
                jsonObject.put("cidade", "");
                jsonObject.put("estado", "");
            }
            jsonArray.put(jsonObject);
        }

        return jsonArray;
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

        if (!json.isNull("responsavelId")) {
            Long responsavelId = json.getLong("responsavelId");
            Paciente responsavel = pacienteDao.buscarPorId(responsavelId);
            paciente.setResponsavel(responsavel);
        }

        return paciente;
    }
}
