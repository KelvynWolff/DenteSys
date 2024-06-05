package oralsys.controller;

import java.util.List;
import oralsys.entidades.TipoContato;
import oralsys.persistencia.TipoContatoDao;
import org.json.JSONObject;


public class TipoContatoController {
    private TipoContatoDao tipoContatoDao;

    public TipoContatoController() {
        this.tipoContatoDao = new TipoContatoDao();
    }

    public String criarTipoContato(JSONObject tipoContatoJSON) {
        String status = "Sucesso!";

        if (tipoContatoJSON.getString("tipoContato").isEmpty()) {
            status = "Tipo de contato inválido!";
        }

        if (status.equals("Sucesso!")) {
            TipoContato tipoContato = new TipoContato();
            tipoContato.setTipoContato(tipoContatoJSON.getString("tipoContato"));
            tipoContatoDao.salvar(tipoContato);
        }

        return status;
    }

    public String atualizarTipoContato(JSONObject tipoContatoJSON) {
        String status = "Sucesso!";

        if (tipoContatoJSON.getLong("id") == 0) {
            status = "ID inválido!";
        } else if (tipoContatoJSON.getString("tipoContato").isEmpty()) {
            status = "Tipo de contato inválido!";
        }

        if (status.equals("Sucesso!")) {
            String condicao = "id = " + tipoContatoJSON.getLong("id");
            List<TipoContato> tiposContato = tipoContatoDao.listarTipoContato(condicao);
            if (!tiposContato.isEmpty()) {
                TipoContato tipoContato = tiposContato.get(0);
                tipoContato.setTipoContato(tipoContatoJSON.getString("tipoContato"));
                tipoContatoDao.atualiza(tipoContato);
            } else {
                status = "Tipo de contato não encontrado!";
            }
        }

        return status;
    }

    public String removerTipoContato(Long id) {
        String status = "Sucesso!";

        if (id == null || id == 0) {
            status = "ID inválido!";
        }

        if (status.equals("Sucesso!")) {
            String condicao = "id = " + id;
            List<TipoContato> tiposContato = tipoContatoDao.listarTipoContato(condicao);
            if (!tiposContato.isEmpty()) {
                TipoContato tipoContato = tiposContato.get(0);
                tipoContatoDao.remove(tipoContato);
            } else {
                status = "Tipo de contato não encontrado!";
            }
        }

        return status;
    }
}
