package oralsys.controller;

import oralsys.persistencia.CidadeDao;
import java.util.LinkedList;
import java.util.List;
import oralsys.entidades.Cidade;
import oralsys.entidades.Estado;
import oralsys.persistencia.EstadoDao;
import org.json.JSONObject;

public class CidadeController implements Controller {
    
     public String cadastrarCidade(JSONObject cidadeJSON) {
        List<String> status = new LinkedList<>();

        if (cidadeJSON.optString("estado").isEmpty()) {
            status.add("Estado invalido!");
        }
        if (cidadeJSON.optString("nome").isEmpty()) {
            status.add("Nome invalido!");
        }
        if (status.isEmpty()) {
            try {
                Cidade cidade = converte(cidadeJSON);
                CidadeDao cidadeDao = new CidadeDao();
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
            CidadeDao cidadeDao = new CidadeDao();
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
            EstadoDao estadoDao = new EstadoDao();
            Estado estado = estadoDao.buscarPorUf(estadoNome);
            if (estado != null) {
                cidade.setEstado(estado);
            } else {
                throw new IllegalArgumentException("Estado inválido: " + estadoNome);
            }
        }

        return cidade;
    }   
}