package oralsys.controller;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import oralsys.entidades.Material;
import oralsys.persistencia.MaterialDao;
import oralsys.persistencia.ConverterEntidades;

public class MaterialController implements Controller {
    private MaterialDao materialDao;
    private ConverterEntidades converterEntidades;

    public MaterialController() {
        this.materialDao = new MaterialDao();
        this.converterEntidades = new ConverterEntidades();
    }

    public String cadastrarMaterial(JSONObject materialJSON) {
        List<String> status = new LinkedList<>();
        if (materialJSON.get("nome").equals("") || materialJSON.get("nome") == null) {
            status.add("Nome invalido!");
        }
        if (materialJSON.get("qtdMinina").equals("") || materialJSON.get("qtdMinina") == null) {
            status.add("Quantidade Minina invalida!");
        }
        if (status.isEmpty()) {
            Material material = new Material();
            material.setNome(materialJSON.getString("nome"));
            material.setQtdMinina(materialJSON.getInt("qtdMinina"));

            if (materialJSON.has("usuarioCadastroId")) {
                Long usuarioCadastroId = materialJSON.optLong("usuarioCadastroId");
                material.setUsuarioCadastro(converterEntidades.converterLoginPorId(usuarioCadastroId));
            }

            materialDao.salvar(material);
            status.add("Sucesso!");
        }
        return String.join(", ", status);
    }

    public String alterarMaterial(int id, JSONObject materialJSON) {
    List<String> status = new LinkedList<>();
    if (id <= 0) {
        status.add("ID Invalido!");
        return String.join(", ", status);
    }

    Material material = materialDao.buscarPorId(id);
    if (material == null) {
        status.add("Material não encontrado!");
        return String.join(", ", status);
    }

    if (!materialJSON.optString("nome").isEmpty()) {
        material.setNome(materialJSON.optString("nome"));
    }
    if (materialJSON.has("qtdMinina")) {
        material.setQtdMinina(materialJSON.getInt("qtdMinina"));
    }
    if (materialJSON.has("usuarioCadastroId")) {
        Long usuarioCadastroId = materialJSON.optLong("usuarioCadastroId");
        material.setUsuarioCadastro(converterEntidades.converterLoginPorId(usuarioCadastroId));
    }

    materialDao.atualiza(material);
    status.add("Sucesso!");
    return String.join(", ", status);
}


    public String excluirMaterial(int id) {
    List<String> status = new LinkedList<>();
    if (id <= 0) {
        status.add("ID Invalido!");
        return String.join(", ", status);
    }

    Material material = materialDao.buscarPorId(id);
    if (material == null) {
        status.add("Material não encontrado!");
        return String.join(", ", status);
    }

    materialDao.remove(material);
    status.add("Sucesso!");
    return String.join(", ", status);
}


    public JSONArray listarMaterial(String condicao) {
        List<Material> retorno = materialDao.listarMaterial(condicao);

        JSONArray jsonArray = new JSONArray();

        for (Material material : retorno) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", material.getId());
            jsonObject.put("nome", material.getNome());
            jsonObject.put("qtdMinina", material.getQtdMinina());
            jsonArray.put(jsonObject);
        }

        return jsonArray;
    }

    @Override
    public Material converte(JSONObject json) {
        if (json == null) {
            throw new IllegalArgumentException("O objeto JSON não pode ser nulo");
        }

        Material material = new Material();
        material.setNome(json.optString("nome"));
        material.setQtdMinina(json.optInt("qtdMinina"));

        if (json.has("usuarioCadastroId")) {
            Long usuarioCadastroId = json.getLong("usuarioCadastroId");
            material.setUsuarioCadastro(converterEntidades.converterLoginPorId(usuarioCadastroId));
        }

        return material;
    }
}
