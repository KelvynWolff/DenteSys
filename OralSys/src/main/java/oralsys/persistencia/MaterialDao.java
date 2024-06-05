package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Material;

public class MaterialDao extends Dao {
    public List<Material> listarMaterial(String condicao) {
        String queryString = "SELECT * FROM Material";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Material.class).getResultList();
    }
}