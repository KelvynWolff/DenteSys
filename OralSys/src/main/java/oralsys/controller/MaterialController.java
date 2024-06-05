package oralsys.controller;

import java.util.List;
import oralsys.entidades.Material;
import oralsys.persistencia.MaterialDao;
import org.json.JSONObject;
import oralsys.entidades.Login;


public class MaterialController {
    private MaterialDao materialDao;

    public MaterialController() {
        this.materialDao = new MaterialDao();
    }

    public String criarMaterial(JSONObject materialJSON) {
        String status = "Sucesso!";

        if (materialJSON.getString("nome").isEmpty()) {
            status = "Nome inválido!";
        } else if (materialJSON.getInt("qtdMinina") < 0) {
            status = "Quantidade mínima inválida!";
        } else if (materialJSON.get("usuarioCadastro") == null) {
            status = "Usuário inválido!";
        }

        if (status.equals("Sucesso!")) {
            Material material = new Material();
            material.setNome(materialJSON.getString("nome"));
            material.setQtdMinina(materialJSON.getInt("qtdMinina"));
            material.setUsuarioCadastro((Login) materialJSON.get("usuarioCadastro"));
            materialDao.salvar(material);
        }

        return status;
    }

    public String atualizarMaterial(JSONObject materialJSON) {
        String status = "Sucesso!";

        if (materialJSON.getLong("id") == 0) {
            status = "ID inválido!";
        } else if (materialJSON.getString("nome").isEmpty()) {
            status = "Nome inválido!";
        } else if (materialJSON.getInt("qtdMinina") < 0) {
            status = "Quantidade mínima inválida!";
        } else if (materialJSON.get("usuarioCadastro") == null) {
            status = "Usuário inválido!";
        }

        if (status.equals("Sucesso!")) {
            Material material = new Material();
            material.setId(materialJSON.getLong("id"));
            material.setNome(materialJSON.getString("nome"));
            material.setQtdMinina(materialJSON.getInt("qtdMinina"));
            material.setUsuarioCadastro((Login) materialJSON.get("usuarioCadastro"));
            materialDao.atualiza(material);
        }

        return status;
    }

    public String removerMaterial(Long id) {
        String status = "Sucesso!";

        if (id == null || id == 0) {
            status = "ID inválido!";
        }

        if (status.equals("Sucesso!")) {
            String condicao = "id = " + id;
            List<Material> materiais = materialDao.listarMaterial(condicao);
            if (!materiais.isEmpty()) {
                Material material = materiais.get(0);
                materialDao.remove(material);
            } else {
                status = "Material não encontrado!";
            }
        }

        return status;
    }
}
