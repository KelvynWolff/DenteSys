package oralsys.controller;

import oralsys.persistencia.CidadeDao;
import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Cidade;
import oralsys.entidades.Cidade;
import oralsys.entidades.Endereco;
import oralsys.entidades.Estado;
import oralsys.entidades.FormaPagamento;
import oralsys.entidades.Funcionario;
import oralsys.entidades.Paciente;
import oralsys.entidades.Prontuario;
import oralsys.persistencia.ConverterEntidades;
import oralsys.persistencia.EstadoDao;
import org.json.JSONArray;
import org.json.JSONObject;

public class CidadeController implements Controller {
    private CidadeDao cidadeDao;
    private ConverterEntidades converterEntidades;
    private EstadoDao estadoDao;
    
    public CidadeController(CidadeDao cidadeDao, ConverterEntidades converterEntidades, EstadoDao estadoDao) {
        this.cidadeDao = cidadeDao;
        this.converterEntidades = converterEntidades;
        this.estadoDao = estadoDao;
    }
    
     public String cadastrarCidade(JSONObject cidadeJSON) {
        List<String> status = new LinkedList<>();

        if (cidadeJSON.optString("enderecosIds").isEmpty()) {
            status.add("Endereco invalido!");
        }
        if (cidadeJSON.optString("estado").isEmpty()) {
            status.add("Estado invalido!");
        }
        if (cidadeJSON.optString("nome").isEmpty()) {
            status.add("Nome invalido!");
        }
        if (status.isEmpty()) {
            try {
                Cidade cidade = converte(cidadeJSON);
                cidadeDao.salvar(cidade);
                status.add("Sucesso!");
            } catch (IllegalArgumentException e) {
                status.add(e.getMessage());
            }
        }
        return String.join(", ", status);
    }
     
    public String excluirCidade(String id) {
        String status = "Sucesso!";
        if (id.isEmpty()) {
            status = "ID Invalido!";
        }
        String condicao = "id=' " + id + "'";
        if (status.equals("Sucesso!")) {
            List<Cidade> cidade = cidadeDao.listarCidade(condicao);
            cidadeDao.remove(cidade.get(0));
        }
        return status;
    }

    @Override
    public Cidade converte(JSONObject json) {
        if (json == null) {
            throw new IllegalArgumentException("O objeto JSON não pode ser nulo");
        }

        Cidade cidade = new Cidade();
        cidade.setNome(json.optString("nome"));

        if (json.has("estado")) {
            String estadoNome = json.optString("estado");
            Estado estado = estadoDao.buscarPorUf(estadoNome);
            if (estado != null) {
                cidade.setEstado(estado);
            } else {
                throw new IllegalArgumentException("Estado inválido: " + estadoNome);
            }
        }

        if (json.has("enderecosIds")) {
            JSONArray enderecosIds = json.getJSONArray("enderecosIds");
            List<Endereco> enderecos = converterEntidades.converterEnderecosPorIds(enderecosIds);
            cidade.setEnderecos(enderecos);
        }

        return cidade;
    }
    
}
