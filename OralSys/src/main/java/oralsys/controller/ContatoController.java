package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Contato;
import oralsys.entidades.Paciente;
import oralsys.entidades.TipoContato;
import oralsys.persistencia.ContatoDao;
import oralsys.persistencia.ConverterEntidades;
import org.json.JSONObject;

public class ContatoController implements Controller {
    private ContatoDao contatoDao;
    private ConverterEntidades converterEntidades;

    public ContatoController(ContatoDao contatoDao, ConverterEntidades converterEntidades) {
        this.contatoDao = contatoDao;
        this.converterEntidades = converterEntidades;
    }

    public String inserirContato(JSONObject contatoJSON) {
        List<String> status = new LinkedList<>();
        
        if (contatoJSON.optString("informacao").isEmpty()) {
            status.add("Informação inválida!");
        }
        if (!contatoJSON.has("pacienteId")) {
            status.add("Paciente inválido!");
        }
        if (!contatoJSON.has("tipoContatoId")) {
            status.add("Tipo de contato inválido!");
        }

        if (status.isEmpty()) {
            try {
                Contato contato = converte(contatoJSON);
                contatoDao.salvar(contato);
                status.add("Sucesso!");
            } catch (IllegalArgumentException e) {
                status.add(e.getMessage());
            }
        }

        return String.join(", ", status);
    }

    public String alterarContato(JSONObject contatoJSON) {
        List<String> status = new LinkedList<>();
        
        if (!contatoJSON.has("id") || contatoJSON.optString("id").isEmpty()) {
            status.add("ID Inválido!");
        }

        if (status.isEmpty()) {
            Long contatoId = contatoJSON.getLong("id");
            Contato contato = contatoDao.buscarPorId(contatoId);

            if (contato != null) {
                if (contatoJSON.has("informacao") && !contatoJSON.optString("informacao").isEmpty()) {
                    contato.setInformacao(contatoJSON.getString("informacao"));
                }
                if (contatoJSON.has("pacienteId")) {
                    Long pacienteId = contatoJSON.getLong("pacienteId");
                    Paciente paciente = converterEntidades.converterPacientePorId(pacienteId);
                    contato.setPaciente(paciente);
                }
                if (contatoJSON.has("tipoContatoId")) {
                    Long tipoContatoId = contatoJSON.getLong("tipoContatoId");
                    TipoContato tipoContato = converterEntidades.converterTipoContatoPorId(tipoContatoId);
                    contato.setTipo(tipoContato);
                }
                contatoDao.atualiza(contato);
                status.add("Sucesso!");
            } else {
                status.add("Contato não encontrado!");
            }
        }

        return String.join(", ", status);
    }

    public String removerContato(String id) {
        List<String> status = new LinkedList<>();
        
        if (id == null || id.isEmpty()) {
            status.add("ID Inválido!");
        }

        if (status.isEmpty()) {
            Long contatoId = Long.parseLong(id);
            Contato contato = contatoDao.buscarPorId(contatoId);

            if (contato != null) {
                contatoDao.remove(contato);
                status.add("Sucesso!");
            } else {
                status.add("Contato não encontrado!");
            }
        }

        return String.join(", ", status);
    }

    @Override
    public Contato converte(JSONObject json) {
        Contato contato = new Contato();

        contato.setInformacao(json.optString("informacao"));

        if (json.has("pacienteId")) {
            Long pacienteId = json.getLong("pacienteId");
            Paciente paciente = converterEntidades.converterPacientePorId(pacienteId);
            contato.setPaciente(paciente);
        }

        if (json.has("tipoContatoId")) {
            Long tipoContatoId = json.getLong("tipoContatoId");
            TipoContato tipoContato = converterEntidades.converterTipoContatoPorId(tipoContatoId);
            contato.setTipo(tipoContato);
        }

        return contato;
    }
}