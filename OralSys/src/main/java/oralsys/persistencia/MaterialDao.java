package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Material;

public class MaterialDao extends Dao {
    public String inserirMaterial(Material material) {
        String status = "";
        if (material.getNome().isEmpty()) {
            status = "Nome invalido!";
        } else if (material.getQtdMinina() < 0) {
            status = "Quantidade minima invalida!";
        } else if (material.getUsuarioCadastro() == null) {
            status = "Usuario invalido!";
        }
        if (status.equals("")) {
            this.salvar(material);
            status = "Sucesso!";
        }
        return status;
    }
    
    public String alterarMaterial(Material material) {
        String status = "";
        if (material.getNome().isEmpty()) {
            status = "Nome invalido!";
        } else if (material.getQtdMinina() < 0) {
            status = "Quantidade minima invalida!";
        } else if (material.getUsuarioCadastro() == null) {
            status = "Usuario invalido!";
        }
        if (status.equals("")) {
            this.atualiza(material);
            status = "Sucesso!";
        }
        return status;
    }
    
    public void removerMaterial(Material material) {
        this.remove(material);
    }
}