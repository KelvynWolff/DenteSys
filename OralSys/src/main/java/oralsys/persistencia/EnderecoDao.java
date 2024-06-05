package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Endereco;

public class EnderecoDao extends Dao {
    public List listarEndereco (String condicao) {   
        String queryString = "SELECT * FROM Endereco";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Endereco.class)
                 .getResultList();
    }
}
