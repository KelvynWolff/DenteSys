package oralsys.controller;

import java.util.List;
import java.util.stream.Collectors;
import oralsys.entidades.Prontuario;
import oralsys.persistencia.ProntuarioDao;
import org.json.JSONObject;


public class ProntuarioController {
    private ProntuarioDao prontuarioDao;

    public ProntuarioController() {
        this.prontuarioDao = new ProntuarioDao();
    }

    public String criarProntuario(JSONObject prontuarioJSON) {
        String status = "Sucesso!";

        if (prontuarioJSON.getJSONArray("prontuarios").isEmpty()) {
            status = "Prontuários inválidos!";
        }

        if (status.equals("Sucesso!")) {
            Prontuario prontuario = new Prontuario();
            prontuario.setId(prontuarioJSON.getLong("id"));
            prontuario.setProntuarios(prontuarioJSON.getJSONArray("prontuarios").toList().stream()
                    .map(Object::toString)
                    .collect(Collectors.toList()));
            prontuarioDao.salvar(prontuario);
        }

        return status;
    }

    public String atualizarProntuario(JSONObject prontuarioJSON) {
        String status = "Sucesso!";

        if (prontuarioJSON.getLong("id") == 0) {
            status = "ID inválido!";
        } else if (prontuarioJSON.getJSONArray("prontuarios").isEmpty()) {
            status = "Prontuários inválidos!";
        }

        if (status.equals("Sucesso!")) {
            String condicao = "id = " + prontuarioJSON.getLong("id");
            List<Prontuario> prontuarios = prontuarioDao.listarProntuario(condicao);
            if (!prontuarios.isEmpty()) {
                Prontuario prontuario = prontuarios.get(0);
                prontuario.setProntuarios(prontuarioJSON.getJSONArray("prontuarios").toList().stream()
                        .map(Object::toString)
                        .collect(Collectors.toList()));
                prontuarioDao.atualiza(prontuario);
            } else {
                status = "Prontuário não encontrado!";
            }
        }

        return status;
    }

    public String removerProntuario(Long id) {
        String status = "Sucesso!";

        if (id == null || id == 0) {
            status = "ID inválido!";
        }

        if (status.equals("Sucesso!")) {
            String condicao = "id = " + id;
            List<Prontuario> prontuarios = prontuarioDao.listarProntuario(condicao);
            if (!prontuarios.isEmpty()) {
                Prontuario prontuario = prontuarios.get(0);
                prontuarioDao.remove(prontuario);
            } else {
                status = "Prontuário não encontrado!";
            }
        }

        return status;
    }
}
