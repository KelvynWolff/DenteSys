package oralsys.persistencia;

import java.util.List;
import oralsys.entidades.Consulta;
import oralsys.entidades.Contato;

public class ContatoDao extends Dao {
    public List listarContato (String condicao) {   
        String queryString = "SELECT * FROM Contato";
        if (condicao != null && !condicao.isEmpty()) {
            queryString += " WHERE " + condicao;
        }
        return em.createNativeQuery(queryString, Contato.class)
                 .getResultList();
    }
}
