package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Funcao;


public class FuncaoDao extends Dao {
    public List listarFuncao (String condicao) {   
        String queryString = "SELECT * FROM Funcao";
        if (condicao != null && !Funcao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Funcao.class)
                 .getResultList();
    }
}
